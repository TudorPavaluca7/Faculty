using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7.Model.Expressions
{
    public class ConstantExpression : Expression
    {
        private int value;

        public ConstantExpression(int value)
        {
            this.value = value;
        }

        public int Eval(ADT.IDictionary<string, int> dict)
        {
            return this.value;
        }

        public override string ToString()
        {
            return "" + this.value;
        }
    }
}
