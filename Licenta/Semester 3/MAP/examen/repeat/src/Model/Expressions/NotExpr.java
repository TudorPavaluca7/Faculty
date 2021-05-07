package Model.Expressions;
import Exception.InvalidOperator;
import Model.Utilities.IDictionary;

public class NotExpr implements IExpr {
    private String operator;
    private IExpr left, right;

    public NotExpr(String op, IExpr l, IExpr r){
        operator = op;
        left = l;
        right = r;
    }

    @Override
    public int evaluate(IDictionary<String, Integer> dic, IDictionary<Integer, Integer> heap) {
        int left = this.left.evaluate(dic,heap);
        int right = this.right.evaluate(dic,heap);

        switch (operator){
            case "<":
                if(left> right)return 1; else return 0;
            case ">":
                if(left< right)return 1; else return 0;
            case "<=":
                if(left>=right)return 1; else return 0;
            case ">=":
                if(left<=right)return 1; else return 0;
            case "==":
                if(left!=right)return 1; else return 0;
            case "!=":
                if(left==right)return 1; else return 0;

        }
        throw new InvalidOperator("Invalid operator!");
    }

    public String toString(){
        return "!(" + left + operator + right +")";
    }
}
