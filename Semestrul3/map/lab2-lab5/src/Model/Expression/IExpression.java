package Model.Expression;

import Model.ADT.IDictionary;
import Model.ADT.*;
public interface IExpression {
    public int eval(IDictionary<String,Integer> dict,IHeap<Integer,Integer> heap);
}
