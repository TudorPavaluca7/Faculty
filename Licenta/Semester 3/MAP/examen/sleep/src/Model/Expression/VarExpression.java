package Model.Expression;

import Exceptions.VariableNotDefined;
import Model.ADT.IDictionary;
import Model.ADT.IHeap;

public class VarExpression implements IExpression {
    String var;
    public VarExpression(String var){this.var=var;}

    @Override
    public int eval(IDictionary<String, Integer> dict, IHeap<Integer,Integer> heap) {

        Integer x = dict.LookUp(this.var);
        if (x == null)
            throw new VariableNotDefined("the variable doesn't exist");
        return dict.LookUp(this.var);
    }
    @Override
    public String toString()
    {
        return ""+this.var;
    }
}
