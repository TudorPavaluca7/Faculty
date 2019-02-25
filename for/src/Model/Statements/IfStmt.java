package Model.Statements;

import  Model.Utilities.*;
import Model.ProgramState;
import Model.Expressions.*;

public class IfStmt implements IStmt {
    private IExpr expr;
    private IStmt thenStmt;
    private IStmt elseStmt;

    public IfStmt(IExpr expression, IStmt thenS, IStmt elseS){
        expr = expression;
        thenStmt = thenS;
        elseStmt = elseS;
    }
    @Override
    public ProgramState execute(ProgramState state){
        IDictionary<String, Integer> dic = state.getSymTable();
        IStack<IStmt> stack = state.getStack();
        IDictionary<Integer, Integer> heap=state.getHeap();
        int val = expr.evaluate(dic,heap);

        if(val != 0)
            stack.add(thenStmt);
        else
            stack.add(elseStmt);
        return null;
    }

    public String toString(){
        return "if(" + expr + ") then(" + thenStmt +  ")else(" + elseStmt + ")";
    }
}
