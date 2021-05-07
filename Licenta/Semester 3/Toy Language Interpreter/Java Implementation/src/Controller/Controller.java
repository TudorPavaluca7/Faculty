package Controller;

import Exceptions.EmptyStackException;
import Exceptions.FileException;
import Exceptions.InterpretorException;
import Model.ADT.IHeap;
import Model.ADT.IStack;
import Model.ProgramState;
import Model.Statement.IStmt;
import Repository.IRepo;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;


public class Controller {
    private IRepo repo;
    private ExecutorService executor;

    public Controller(IRepo repo) {
        this.repo = repo;

    }

    public IRepo getRepo() {
        return repo;
    }

    public void oneStep(ProgramState state) {
        IStack<IStmt> stk = state.getExeStack();
        if (stk.isEmpty())
            throw new EmptyStackException("The stack is empty");
        IStmt crtStmt = stk.pop();
        crtStmt.execute(state);
        state.getHeap().setContent(conservativeGarbageCollector(state.getSymbolTable().getValues(), state.getHeap()));
        System.out.print(state);
    }

    public void closeAllOpenFiles(ProgramState prg) {

        prg.getFileTable().GetAllValues().stream().forEach(e -> {
            try {
                e.getHeader().close();
            } catch (IOException ex) {
                throw new FileException(ex.toString());
            }


        });
    }
//    public void allSteps(){
//        ProgramState prg = repo.getCurrentP();
//            try{
//            while (!prg.getExeStack().isEmpty()) {
//                oneStep(prg);
//                repo.logPrgStateExec();
//                //System.out.println(prg);
//
//            }
//           }catch(InterpretorException e) {
//                System.out.println(e.toString());
//            }
//            finally {
//                prg.getFileTable().GetAllValues().stream().forEach(e-> {
//                   try {
//                        e.getHeader().close();
//                   } catch (IOException ex) {
//                        throw new FileException(ex.toString());
//                    }
//
//                });
//            }
//        }

    public void allSteps() {
        executor = Executors.newFixedThreadPool(2);
        List<ProgramState> prgList = removeCompletedPrg(repo.getPrgList());
        while (prgList.size() > 0) {

            prgList.stream().forEach(e -> e.setHeapMap(conservativeGarbageCollector(e.getSymbolTable().getValues(), e.getHeap())));
            oneStepForAll(prgList);
            prgList.stream().forEach(e -> {
                System.out.println(e);
            });
            prgList = removeCompletedPrg(repo.getPrgList());

        }
        executor.shutdownNow();
        List<ProgramState> temp = repo.getPrgList();


        for (ProgramState st : temp)
            closeAllOpenFiles(st);

        repo.setPrgList(prgList);

    }

    public int noPrgStates() {
        return repo.getPrgList().size();
    }

    public ProgramState getPrgStateByIndex(int index) {
        return repo.getPrgList().get(index);
    }

    public ObservableList<String> getPrgStatesID() {
        ObservableList<String> list = FXCollections.observableArrayList();
        for (ProgramState i : repo.getPrgList())
            list.add(String.valueOf(i.getID()));

        return list;
    }

    public void oneStepForAll(List<ProgramState> l) {

        List<Callable<ProgramState>> lc = l.stream().map((ProgramState p) -> (Callable<ProgramState>) (p::oneStep))
                .collect(Collectors.toList());

        List<ProgramState> lp = null;

        try {
            lp = executor.invokeAll(lc).stream().map(future -> {
                try {
                    return future.get();
                } catch (InterruptedException e) {
                    throw new InterpretorException(e.toString());
                } catch (ExecutionException e) {
                    throw new InterpretorException(e.toString());
                }
            }).filter(p -> p != null).collect(Collectors.toList());
        } catch (InterruptedException e) {
            throw new InterpretorException(e.toString());
        }

        l.addAll(lp);
        l.forEach(p -> repo.logPrgStateExec(p));
        repo.setPrgList(l);
    }

    public void oneStepForGui(List<ProgramState> prgList) {
        try {

            List<Callable<ProgramState>> callList = prgList.stream()
                    .map((ProgramState p) -> (Callable<ProgramState>) (() -> {
                        return p.oneStep();
                    }))
                    .collect(Collectors.toList());
            List<ProgramState> newPrgList = executor.invokeAll(callList).stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (Exception e) {
                            Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
                            a.show();
                            return null;
                        }
                    })
                    .filter(p -> p != null).collect(Collectors.toList());
            prgList.addAll(newPrgList);
            prgList.forEach(prg -> {
                try {
                    repo.logPrgStateExec(prg);
                } catch (FileException e) {
                    Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
                    a.show();
                }
            });
            repo.setPrgList(prgList);
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
            a.show();
        }
    }

    List<ProgramState> removeCompletedPrg(List<ProgramState> inPrgList) {
        return inPrgList.stream()
                .filter(p -> p.isNotCompleted())
                .collect(Collectors.toList());


    }

    private Map<Integer, Integer> conservativeGarbageCollector(List<Integer> symTableValues, IHeap<Integer, Integer> heap) {
        return heap.entrySet().stream()
                .filter(e -> symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public boolean oneStepGUI() {
        executor = Executors.newFixedThreadPool(2);
        List<ProgramState> prgList = removeCompletedPrg(repo.getPrgList());

        if (prgList.size() > 0) {
            oneStepForGui(prgList);
            prgList = removeCompletedPrg(repo.getPrgList());
            return true;
        } else {
            executor.shutdownNow();
            repo.setPrgList(prgList);
            return false;
        }


    }
}
