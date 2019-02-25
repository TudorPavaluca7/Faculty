package Model.Statement;

import Model.ADT.IDictionary;
import Model.ADT.IStack;
import Model.Expression.IExpression;
import Model.ProgramState;

public class AssignStatement implements IStmt {
    String id;
    IExpression expr;
    public AssignStatement(String id, IExpression expr)
    {
        this.id=id;
        this.expr= expr;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IStack<IStmt> stk=state.getExeStack();
        IDictionary<String,Integer> symTbl= state.getSymbolTable();
        int val = expr.eval(symTbl,state.getHeap());
        if (symTbl.check(this.id))
            symTbl.update(this.id,val);
        else
            symTbl.add(this.id,val);
        return null;

    }
    @Override
    public String toString(){ return id+"="+ expr.toString();}

}
