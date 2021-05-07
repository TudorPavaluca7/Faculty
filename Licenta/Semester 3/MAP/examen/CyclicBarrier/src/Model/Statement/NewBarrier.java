package Model.Statement;


import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.ADT.Pair;
import Model.Expression.IExpression;
import Model.FileHandling.IdGenerator;
import Model.ProgramState;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class NewBarrier implements IStmt {
    private String var;
    private IExpression exp;
    private static ReentrantLock lock=new ReentrantLock();
    public NewBarrier(String var,IExpression exp)
    {
        this.var=var;
        this.exp=exp;
    }

    @Override
    public ProgramState execute(ProgramState p) {

        lock.lock();
        IHeap<Integer, Integer> heap = p.getHeap();
        IDictionary<String, Integer> d = p.getSymbolTable();
        int val = this.exp.eval(d, heap);
        int id = IdGenerator.generateId();
        p.getBarrierTable().add(id, new Pair(val,new ArrayList<Integer>()));
            if (p.getSymbolTable().check(this.var))
                p.getSymbolTable().update(var,id);
            else
                p.getSymbolTable().add(var,id);

            lock.unlock();

        return null;
    }

    @Override
    public String toString() {
        return "newBarrier("+ var +","+exp+")";
    }
}
