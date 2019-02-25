package Model.Statement;

import Model.Expression.IExpression;
import Model.ProgramState;
import Model.ADT.*;
public class HeapWriteStatement implements IStmt{
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
            return p;
        }

        @Override
        public String toString()
        {
            StringBuffer buff = new StringBuffer();
            buff.append("writeHeap(");
            buff.append(this.varName);
            buff.append(", ");
            buff.append(this.expr);
            buff.append(")\n");
            return buff.toString();
        }
}
