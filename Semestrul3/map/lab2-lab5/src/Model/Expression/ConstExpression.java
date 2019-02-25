package Model.Expression;
import Model.ADT.*;
import Model.ADT.IDictionary;

public class ConstExpression implements IExpression {
    int number;
    public ConstExpression(int nr){this.number=nr;}

    @Override
    public int eval(IDictionary<String, Integer> dict,IHeap<Integer,Integer> heap) {
        return this.number;
    }
    @Override
    public String toString()
    {
        return ""+this.number;
    }
}
