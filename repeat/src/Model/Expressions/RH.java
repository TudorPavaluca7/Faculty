package Model.Expressions;

import Exception.VariableNotDefined;
import Model.Utilities.IDictionary;

public class RH implements IExpr {
    private String var;
    public RH(String s){ var=s; }

    @Override
    public int evaluate(IDictionary<String,Integer> dic, IDictionary<Integer, Integer> heap){
        int addr=dic.getValue(var);
        if(heap.exists(addr)) {
            int val = heap.getValue(addr);
            return val;
        }
        else throw new VariableNotDefined("Variable not found!");

    }

    public String toString(){ return "rH("+var+")"; }
}
