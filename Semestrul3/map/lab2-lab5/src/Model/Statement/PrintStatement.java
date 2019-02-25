package Model.Statement;

import Model.ADT.IDictionary;
import Model.Expression.IExpression;
import Model.ProgramState;

public class PrintStatement implements IStmt {
     IExpression expr;
    public PrintStatement(IExpression expr)
    {
        this.expr=expr;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IDictionary<String,Integer> dict = state.getSymbolTable();
        int r = this.expr.eval(dict,state.getHeap());
        state.getMessages().Add(r);
        return state;
    }

    @Override
    public String toString()
    {
        return "Print("+this.expr+")";
    }

}
