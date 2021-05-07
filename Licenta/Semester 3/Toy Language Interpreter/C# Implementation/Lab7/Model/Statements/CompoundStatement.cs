using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Lab7.Model.ADT;
namespace Lab7.Model.Statements
{
    public class CompoundStatement : Statement
    {
        private Statement first, second;

        public CompoundStatement(Statement f, Statement s)
        {
            this.first = f;
            this.second = s;
        }

        public PrgState Execute(PrgState p)
        {
            IExeStack<Statement> stk = p.Stack;
            stk.Push(this.second);
            stk.Push(this.first);
            return p;
        }

        public override string ToString()
        {


             return "(" + first.ToString() + ";" + second.ToString() + ")";
           
        }
    }
}
