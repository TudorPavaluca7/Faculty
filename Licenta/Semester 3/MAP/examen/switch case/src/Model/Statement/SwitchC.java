package Model.Statement;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Expression.IExpression;
import Model.ProgramState;

public class SwitchC implements IStmt {
    private IExpression exp;
    private IExpression exp1;
    private IExpression exp2;
    private IStmt state1;
    private IStmt state2;
    private IStmt state3;
    public SwitchC(IExpression exp,IExpression exp1,IStmt state1,IExpression exp2,IStmt state2,IStmt state3)
    {
        this.exp=exp;
        this.exp1=exp1;
        this.state1=state1;
        this.exp2=exp2;
        this.state2=state2;
        this.state3=state3;

    }

    @Override
    public ProgramState execute(ProgramState p) {
        IHeap<Integer, Integer> heap = p.getHeap();
        IDictionary<String, Integer> d = p.getSymbolTable();
        int e=this.exp.eval(d,heap);
        int e1=this.exp.eval(d,heap);
        int e2=this.exp.eval(d,heap);
        if (e==e1)
            p.getExeStack().push(state1);
        else if(e==e2)
            p.getExeStack().push(state2);
        else
            p.getExeStack().push(state3);


        return null;
    }

    @Override
    public String toString() {
        return "switch("+this.exp+")" + "(case " + this.exp1 +":"+ this.state1 +")" + "(case " + exp2 + ":" + state2 +")" + "(default:" + state3;
    }
}
