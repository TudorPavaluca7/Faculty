package Model.Statement;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Expression.IExpression;
import Model.ProgramState;

public class WhileStatement implements IStmt {

    private IExpression expr;
    private IStmt state;
    public WhileStatement(IExpression expr, IStmt s)
    {
        this.expr=expr;
        this.state=s;
    }

    @Override
    public ProgramState execute(ProgramState p) {
        IHeap<Integer, Integer> heap = p.getHeap();
        IDictionary<String, Integer> d = p.getSymbolTable();
        int val = this.expr.eval(d, heap);

        if (val != 0)
        {
            IStmt s = new WhileStatement(this.expr,this.state);
            p.getExeStack().push(s);
            p.getExeStack().push(state);

        }
        return null;

    }

    @Override
    public String toString()
    {
        return "while("+expr+")"+state;
    }
}
