package Model.Expressions;

import Model.Utilities.IDictionary;
import Exception.*;

public class ArithmExpr implements IExpr {

    private IExpr left, right;
    private String operator;

    public ArithmExpr(String op, IExpr l, IExpr r){
        operator = op;
        left = l;
        right = r;
    }

    @Override
    public int evaluate(IDictionary<String, Integer> dic, IDictionary<Integer, Integer> heap) {
        int left = this.left.evaluate(dic,heap);
        int right = this.right.evaluate(dic,heap);

        switch (operator){
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if(right == 0)
                    throw new DivisionByZero("Division by 0 is not admitted!");
                return left/right;
        }
        throw new InvalidOperator("Invalid operator!");
    }

    public String toString(){
        return "" + left + operator + right;
    }
}
