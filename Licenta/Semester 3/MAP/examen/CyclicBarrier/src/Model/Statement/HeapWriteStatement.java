package Model.Statement;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Expression.IExpression;
import Model.ProgramState;

public class HeapWriteStatement implements IStmt {
        private String varName;
        private IExpression expr;

    public HeapWriteStatement(String varName,IExpression expr)
        {
            this.varName=varName;
            this.expr=expr;
        }

        @Override
        public ProgramState execute(ProgramState p) {

            IDictionary<String,Integer> symTable = p.getSymbolTable();
            IHeap<Integer,Integer> heap = p.getHeap();
            int id=symTable.get(this.varName);
            int val= this.expr.eval(symTable,heap);
            if(heap.contains(id))
                heap.update(id,val);
            else
                heap.add(id,val);
            return null;
        }

        @Override
        public String toString()
        {
            return "wR("+varName+","+expr+")";
        }
}
