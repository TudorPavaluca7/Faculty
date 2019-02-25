package Controller;
import Exceptions.EmptyStackException;
import Exceptions.FileException;
import Exceptions.InterpretorException;
import Model.ADT.IHeap;
import Model.ADT.IStack;
import Model.Statement.IStmt;
import Repository.*;
import Model.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    private IRepo repo;
    public Controller(IRepo repo){this.repo=repo;}
    public void oneStep(ProgramState state){
        IStack<IStmt> stk=state.getExeStack();
        if(stk.isEmpty())
            throw new EmptyStackException("The stack is empty");
        IStmt crtStmt = stk.pop();
        crtStmt.execute(state);
        state.getHeap().setContent(conservativeGarbageCollector(state.getSymbolTable().getValues(),state.getHeap()));
        System.out.print(state);
    }
    public void allSteps(){
        ProgramState prg = repo.getCurrentP();
            try{
            while (!prg.getExeStack().isEmpty()) {
                oneStep(prg);
                repo.logPrgStateExec();
                //System.out.println(prg);

            }
           }catch(InterpretorException e) {
                System.out.println(e.toString());
            }
            finally {
                prg.getFileTable().GetAllValues().stream().forEach(e-> {
                   try {
                        e.getHeader().close();
                   } catch (IOException ex) {
                        throw new FileException(ex.toString());
                    }

                });
            }
        }



    private Map<Integer,Integer> conservativeGarbageCollector(List<Integer> symTableValues, IHeap<Integer,Integer> heap)
    {
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

}
