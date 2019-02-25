using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Lab7.Model.ADT;
using Lab7.Model.Expressions;
namespace Lab7.Model.Statements
{
    public class IfStatement : Statement
    {
        private Expression expr;
        private Statement elsestmt, thenstmt;

        public IfStatement(Expression e, Statement stmt1, Statement stmt2)
        {
            this.expr = e;
            this.elsestmt = stmt1;
            this.thenstmt = stmt2;
        }

        public PrgState Execute(PrgState p)
        {
            ADT.IDictionary<string, int> dict = p.Dict;
            int val = this.expr.Eval(dict);
            if (val != 0)
            {
                p.Stack.Push(thenstmt);
            }
            else
            {
                p.Stack.Push(elsestmt);
            }
            return p;
        }

        public override string ToString()
        {
            StringBuilder buff = new StringBuilder();
            buff.Append("if(");
            buff.Append(this.expr);
            buff.Append(")\n");
            buff.Append("\t{\n\t\t");
            buff.Append(thenstmt);
            buff.Append("\n");
            buff.Append("\t}\n\telse{\n\t\t");
            buff.Append(this.elsestmt);
            buff.Append("\n\t}");
            return buff.ToString();
        }
    }
}
