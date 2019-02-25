package Controller;

import Model.Expressions.ConstExpr;
import Model.Expressions.VarExpr;
import Model.ProgramState;
import Model.Statements.AssignStmt;
import Model.Statements.CompStmt;
import Model.Statements.IStmt;
import Model.Statements.PrintStmt;
import Model.Utilities.*;
import Repository.IRepo;
import Repository.Repository;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.*;

public class Controller {
    private IRepo repo;
    private ExecutorService executor;
    private ProgramState selectedState;
    private List<ProgramState> prglist;

    public Controller(IRepo repo) {
        this.repo = repo;
        this.prglist=repo.getPrgList();
    }

    public void setExecutor(ExecutorService e){executor=e;}
    public void setPrglist(List<ProgramState> p){prglist=p;repo.setPrgList(p);}
    public List<ProgramState> getPrglist(){return prglist;}
    public ProgramState getSelectedState(){return selectedState;}
    public void setSelectedState(ProgramState s){selectedState=s;}
    public IRepo getRepo(){return repo;}

    public Map<Integer,Integer> conservativeGarbageCollector(List<Integer> symTableValues,
                                                      Map<Integer,Integer> heap){
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));}

    public ProgramState closeAllOpenFiles(ProgramState prg){
            prg.clearFileFromSym();
            List<BufferedReader> myList=prg.getFileTable().getValues();
            myList.stream().forEach(el->{try{el.close();}catch(IOException e){System.out.println(e.getMessage());}});
            prg.clearFileTable();
            return prg;
    }

    public ProgramState nothing(){
        IStack<IStmt> ExeStack1 = new Stack<>();
        IDictionary<String, Integer> SymTable1 = new Dictionary<String, Integer>();
        IList<Integer> out1 = new MyList<Integer>();
        IDictionary<Integer, BufferedReader> fileTable1=new Dictionary<Integer, BufferedReader>();
        IDictionary<Integer, Integer> heap1=new Dictionary<Integer, Integer>();
        IStmt expr1=new CompStmt(new AssignStmt("v", new ConstExpr(2)),
                new PrintStmt(new VarExpr("c")));
        ExeStack1.add(expr1);
        ProgramState prgCurrent1 = new ProgramState(ExeStack1, SymTable1, out1,fileTable1,heap1);
        IRepo repo1 = new Repository();
        repo1.addPrg(prgCurrent1);
        Controller ctrl1 = new Controller(repo1);
        return prgCurrent1;
    }

    public ProgramState getProgramByID(List<ProgramState> inPrgList,Integer id){
        for(ProgramState pr:inPrgList){
            if(pr.getID()==id)
                return pr;
        }
        return null;
    }

    public List<ProgramState> removeCompletedPrg(List<ProgramState> inPrgList){
        return inPrgList.stream()
                .filter(p -> p.isNotCompleted())
                .collect(Collectors.toList());
    }

    public Integer processesAdd(List<ProgramState> inPrgList, Integer sum){
        List<ProgramState> aux=inPrgList.stream()
                .filter(p -> !p.isNotCompleted())
                .collect(Collectors.toList());
        sum+=aux.size();
        return sum;
    }

    public Integer processesDelete(List<ProgramState> inPrgList, Integer sum){
        List<ProgramState> aux=inPrgList.stream()
                .filter(p -> p.isNotCompleted())
                .collect(Collectors.toList());
        sum-=aux.size();
        return sum;
    }

    public void oneStepForAllPrgFX(List<ProgramState> prgList){
        try{

            List<Callable<ProgramState>> callList = prgList.stream()
                    .map((ProgramState p) -> (Callable<ProgramState>)(() -> {return p.oneStep();}))
                    .collect(Collectors.toList());
            List<ProgramState> newPrgList = executor.invokeAll(callList). stream()
                    . map(future -> { try { return future.get();} catch(Exception e) {Alert a=new Alert(Alert.AlertType.ERROR,e.getMessage());a.show(); return null;}})
                    .filter(p -> p!=null).collect(Collectors.toList());
            prgList.addAll(newPrgList);
            prgList.forEach(prg ->{try{repo.logProgramStateExec(prg);}catch(IOException e){Alert a=new Alert(Alert.AlertType.ERROR,e.getMessage());a.show();}});
            repo.setPrgList(prgList);
        }
        catch(Exception e){Alert a=new Alert(Alert.AlertType.ERROR,e.getMessage());a.show();}
    }

    public void oneStepForAllPrg(List<ProgramState> prgList){
        try{

            List<Callable<ProgramState>> callList = prgList.stream()
                .map((ProgramState p) -> (Callable<ProgramState>)(() -> {return p.oneStep();}))
                .collect(Collectors.toList());
            List<ProgramState> newPrgList = executor.invokeAll(callList). stream()
                . map(future -> { try { return future.get();} catch(Exception e) { System.out.println(e.getMessage()); return null;}})
                            .filter(p -> p!=null).collect(Collectors.toList());
            prgList.addAll(newPrgList);
            prgList.forEach(prg ->{try{repo.logProgramStateExec(prg);}catch(IOException e){System.out.println(e.getMessage());}});
            repo.setPrgList(prgList);
        }
        catch(Exception e){System.out.println(e.getMessage());}
    }

    public void exShutdown(){
        executor.shutdownNow();
    }

    public void allStep() {
        executor = Executors.newFixedThreadPool(2);
        Integer sum=0;
        List<ProgramState> prgList=removeCompletedPrg(repo.getPrgList());
        while(prgList.size() > 0){
            prgList.stream().forEach(e->e.setHeapMap(conservativeGarbageCollector(e.getSymTable().getValues(),e.getHeap().getMap())));
            oneStepForAllPrg(prgList);
            prgList.stream().forEach(e->{System.out.println("--------------------");System.out.println(e);});
            sum=processesAdd(repo.getPrgList(),sum);
            prgList=removeCompletedPrg(repo.getPrgList());
        }
        executor.shutdownNow();
        List<ProgramState> temp=repo.getPrgList();
        temp.stream().forEach(e->{closeAllOpenFiles(e);System.out.println("--------------------");System.out.println(e);
          try{repo.logProgramStateExec(e);}catch(IOException ex){System.out.println(ex.getMessage());}});
        repo.setPrgList(prgList);
    }

    @Override
    public String toString(){
        return "Controller: " + repo.toString();
    }
}
