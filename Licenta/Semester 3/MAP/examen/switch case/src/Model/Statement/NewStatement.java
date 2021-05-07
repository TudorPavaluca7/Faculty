package Model.Statement;

import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.Expression.IExpression;
import Model.FileHandling.IdGenerator;
import Model.ProgramState;

public class NewStatement implements IStmt {

        private String varName;
        private IExpression expr;

    public NewStatement(String varName, IExpression expr)
        {
            this.varName=varName;
            this.expr=expr;
        }

        @Override
        public ProgramState execute(ProgramState p) {
            IHeap<Integer,Integer> heap = p.getHeap();
            IDictionary<String,Integer> symTable= p.getSymbolTable();
            int res = this.expr.eval(symTable,heap);
            int id = IdGenerator.generateId();
            heap.add(id,res);
            if(symTable.check(this.varName))
                symTable.update(this.varName,id);
            else
                symTable.add(this.varName,id);
            return null;
        }

        @Override
        public String toString()
        {
           return  "new("+varName+','+expr+')';
        }

}
