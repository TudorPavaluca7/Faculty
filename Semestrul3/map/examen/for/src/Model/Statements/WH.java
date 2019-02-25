package Model.Statements;

import Model.Expressions.IExpr;
import Model.ProgramState;
import Model.Utilities.IDictionary;
import Exception.VariableNotDefined;

public class WH implements IStmt {
    private String var;
    private IExpr expr;
    public WH(String s, IExpr e){ var=s; expr=e; }

    @Override
    public ProgramState execute(ProgramState state){
        IDictionary<String,Integer> dic=state.getSymTable();
        IDictionary<Integer,Integer> heap=state.getHeap();
        if(!dic.exists(var))
            throw new VariableNotDefined("Variable not found!");
        int addr=dic.getValue(var);
        if(!heap.exists(addr))
            throw new VariableNotDefined("Variable not found!");
        int val=expr.evaluate(dic,heap);
        heap.delete(addr);
        heap.setValue(addr,val);
        return null;
    }

    public String toString(){ return "wR("+var+","+expr+")"; }
}
