package Model.Statements;

import Model.Expressions.IExpr;
import Model.ProgramState;
import Model.Utilities.IDictionary;

public class New implements IStmt {
    String var;
    IExpr expr;
    public New(String s, IExpr e){var=s; expr=e;}

    @Override
    public ProgramState execute(ProgramState state){
        IDictionary<String,Integer> dic=state.getSymTable();
        IDictionary<Integer, Integer> heap=state.getHeap();
        int e=expr.evaluate(dic,heap);
        int i=1;
        while(true){
            if(heap.exists(i))
                i++;
            else
                break;
        }
        if(dic.exists(var)){
            dic.delete(var);
        }
        heap.setValue(i,e);
        dic.setValue(var,i);

        return null;
    }

    public String toString(){ return "new("+var+','+expr+')'; }
}
