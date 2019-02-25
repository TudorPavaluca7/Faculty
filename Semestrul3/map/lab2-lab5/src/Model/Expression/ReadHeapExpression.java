package Model.Expression;
import Exceptions.VariableNotDefined;
import Model.ADT.*;
public class ReadHeapExpression implements IExpression {
    private String varName;

    public ReadHeapExpression(String varName)
        {
            this.varName=varName;
        }
        public int eval(IDictionary<String,Integer> dict, IHeap<Integer,Integer> heap)
        {
            int val;
            if(dict.check(varName))
                val=dict.get(this.varName);
            else
                throw new VariableNotDefined("Key not found in the symboltable");
            if(!heap.contains(val))
                throw new VariableNotDefined("Key not found in the heap");

            return heap.get(val);
        }

        @Override
        public String toString()
        {
            StringBuffer buffer = new StringBuffer();
            buffer.append("readH(");
            buffer.append(this.varName);
            buffer.append(")\n");
            return buffer.toString();
        }
}
