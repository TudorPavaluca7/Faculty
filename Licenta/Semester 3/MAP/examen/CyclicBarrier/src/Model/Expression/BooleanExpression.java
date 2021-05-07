package Model.Expression;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;

public class BooleanExpression implements IExpression {

    private String operator;
    private IExpression expr1,expr2;

    public BooleanExpression(String op, IExpression expr1, IExpression expr2)
    {
        this.operator=op;
        this.expr1=expr1;
        this.expr2=expr2;
    }

    public int eval(IDictionary<String,Integer> dict, IHeap<Integer,Integer> heap)
    {
        int res1=this.expr1.eval(dict,heap);
        int res2=this.expr2.eval(dict,heap);
        if(this.operator.equals("<"))
        {
            if(res1<res2) {
                return 1;
            }
            return 0;
        }
        else if(this.operator.equals("<="))
        {
            if(res1<=res2)
            {
                return 1;
            }
            return 0;
        }
        else if(this.operator.equals(">"))
        {
            if(res1>res2)
            {
                return 1;
            }
            return 0;
        }
        else if(this.operator.equals(">="))
        {
            if(res1>=res2)
            {
                return 1;
            }
            return 0;
        }
        else if(this.operator.equals("=="))
        {
            if(res1==res2)
            {
                return 1;
            }
            return 0;
        }
        else
        {
            if(res1!=res2)
            {
                return 1;
            }
            return 0;
        }
    }

    @Override
    public String toString()
    {
        StringBuffer buff = new StringBuffer();
        buff.append(this.expr1);
        buff.append(this.operator);
        buff.append(this.expr2);
        buff.append("\n");
        return buff.toString();
    }

}
