package Model.Statements;

import Model.Expressions.IExpr;
import Model.ProgramState;
import Model.Utilities.IStack;

import java.io.IOException;

public class WhileStmt implements IStmt {
    private IStmt stmt;
    private IExpr expr;

    public WhileStmt(IExpr e, IStmt s){ stmt=s; expr=e; }

    @Override
    public ProgramState execute(ProgramState state){
        IStack<IStmt> stack=state.getStack();
        if(expr.evaluate(state.getSymTable(),state.getHeap())!=0)
        {
            stack.add(this);
            stack.add(stmt);
        }
        return null;
    }

    public String toString(){ return "while("+expr+")"+stmt; }
}
