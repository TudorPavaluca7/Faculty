package Model.Expression;

import Exceptions.DivisonByZero;
import Exceptions.InvalidOperator;
import Model.ADT.IDictionary;
import Model.ADT.IHeap;

public class ArithmeticExpression implements IExpression {
    IExpression e1,e2;
    char op;
    public ArithmeticExpression(char op, IExpression e1, IExpression e2)
    {
        this.op=op;
        this.e1=e1;
        this.e2=e2;
    }

    @Override
    public int eval(IDictionary<String, Integer> dict, IHeap<Integer,Integer> heap) {
        switch(this.op){
            case '+':
                 return e1.eval(dict,heap)+e2.eval(dict,heap);
            case '-':
                return e1.eval(dict,heap)-e2.eval(dict,heap);
            case '*':
                return e1.eval(dict,heap)*e2.eval(dict,heap);
            case '%':
                return e1.eval(dict,heap)%e2.eval(dict,heap);
            case '/':
                if (e2.eval(dict,heap)==0)
                    throw new DivisonByZero("error,division by 0");
                else
                    return e1.eval(dict,heap)/e2.eval(dict,heap);
            default:
                //return 0;
                throw  new InvalidOperator("invalid operator");

        }

    }
    @Override
    public String toString()
    {
        return ""+this.e1+this.op+this.e2;
    }
}
