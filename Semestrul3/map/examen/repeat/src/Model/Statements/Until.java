package Model.Statements;

import Model.Expressions.IExpr;
import Model.ProgramState;
import Model.Utilities.IStack;

import java.io.IOException;

public class Until implements IStmt {
    private IStmt stmt;
    private IExpr expr;
    public Until(IStmt stmt,IExpr expr)
    {
        this.expr=expr;
        this.stmt=stmt;

    }

    @Override
    public ProgramState execute(ProgramState state) {
        IStack<IStmt> stack=state.getStack();
        IStmt s1=new WhileStmt(expr,stmt);
        IStmt s=new CompStmt(stmt,s1);
        stack.add(s);
        return null;
    }

    @Override
    public String toString() {
        return "repeat" + stmt + "until" + expr;
    }
}
