package Model.Statement;

import Exceptions.VariableNotDefined;
import Model.ADT.Pair;
import Model.ProgramState;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Await implements IStmt {
    private String var;
    private static ReentrantLock lock = new ReentrantLock();
    public Await(String var)
    {
        this.var=var;
    }

    @Override
    public ProgramState execute(ProgramState p) {
        lock.lock();
        Integer foundIndex=p.getSymbolTable().LookUp(var);
        if (foundIndex==null)
            throw new VariableNotDefined("the variable doesn't exist in symtable");
        if (p.getBarrierTable().contains(foundIndex)==false)
            throw new VariableNotDefined("the variable doesn't exist in brtable");
        if (p.getBarrierTable().get(foundIndex).getList().size()<p.getBarrierTable().get(foundIndex).getNumber())
            if (p.getBarrierTable().get(foundIndex).getList().contains(p.getID()))
                p.getExeStack().push(new Await(var));
            else {
                p.getBarrierTable().get(foundIndex).getList().add(p.getID());
                p.getExeStack().push(new Await(var));
            }

        lock.unlock();

        return null;
    }

    @Override
    public String toString() {
        return "Await("+var+")";
    }
}
