package Model.Expression;

import Exceptions.VariableNotDefined;
import Model.ADT.IDictionary;
import Model.ADT.IHeap;

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
            return "rH("+varName+")";
        }
}
