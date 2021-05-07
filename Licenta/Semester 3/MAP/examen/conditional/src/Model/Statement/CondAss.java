package Model.Statement;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Expression.IExpression;
import Model.ProgramState;

public class CondAss implements IStmt {
  private IExpression expr1;
  private IExpression expr2;
  private IExpression expr3;
  private String id;
  public CondAss(IExpression expr1,IExpression expr2,IExpression expr3,String id)
  {
      this.expr1=expr1;
      this.expr2=expr2;
      this.expr3=expr3;
      this.id=id;

  }

    @Override
    public ProgramState execute(ProgramState p) {

        IHeap<Integer, Integer> heap = p.getHeap();
        IDictionary<String, Integer> d = p.getSymbolTable();
        int val = this.expr1.eval(d, heap);
        if (val==1)
            p.getExeStack().push(new AssignStatement(id,expr2));
        else
            p.getExeStack().push(new AssignStatement(id,expr3));
      return null;
    }

    @Override
    public String toString() {
        return id+"="+expr1+"?"+expr2+":"+expr3;
    }
}
