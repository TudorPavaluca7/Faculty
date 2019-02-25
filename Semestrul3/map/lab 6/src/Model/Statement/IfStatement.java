package Model.Statement;

import Model.ADT.IDictionary;
import Model.Expression.IExpression;
import Model.ProgramState;

public class IfStatement implements IStmt {
    IExpression expr;
    IStmt thenS;
    IStmt elseS;
    public IfStatement(IExpression expr,IStmt els,IStmt then)
    {
        this.expr=expr;
        this.elseS=els;
        this.thenS=then;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IDictionary<String,Integer> dict = state.getSymbolTable();
        int val = this.expr.eval(dict,state.getHeap());
        if(val == 1)
        {
            state.getExeStack().push(thenS);
        }
        else
            state.getExeStack().push(elseS);
        return null;
    }
    @Override
    public String toString()
    {

            StringBuffer buff = new StringBuffer();
            buff.append("if(");
            buff.append(expr);
            buff.append(")\n");
            buff.append("\t{\n\t\t");
            buff.append(this.thenS);
            buff.append("\n");
            buff.append("\t}\n\telse{\n\t\t");
            buff.append(this.elseS);
            buff.append("\n\t}");
            return buff.toString();




    }
}
