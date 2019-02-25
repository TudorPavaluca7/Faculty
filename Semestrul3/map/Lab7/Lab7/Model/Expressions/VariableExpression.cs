using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Lab7.Model.ADT;
namespace Lab7.Model.Expressions
{
    public class VariableExpression : Expression
    {
        private string varName;

        public VariableExpression(string varName)
        {
            this.varName = varName;
        }

        public int Eval(ADT.IDictionary<string, int> dict)
        {
            return dict.getValue(this.varName);
        }

        public override string ToString()
        {
            return ""+this.varName;
        }
    }
}
