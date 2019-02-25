package Model.Statements;

import Model.Expressions.*;
import Model.ProgramState;
import Model.Utilities.*;

public class PrintStmt implements IStmt {
    private IExpr expr;

    public PrintStmt(IExpr expression){
        expr = expression;
    }

    @Override
    public ProgramState execute(ProgramState state){
        IList<Integer> list = state.getList();
        IDictionary<String, Integer> dic = state.getSymTable();
        IDictionary<Integer, Integer> heap=state.getHeap();
        int val = expr.evaluate(dic,heap);
        list.add(val);
        return null;
    }

    public String toString(){
        return "print(" + expr + ")";
    }
}
