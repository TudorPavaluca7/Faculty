using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Lab7.Model.ADT;
namespace Lab7.Model.Expressions
{
    public interface Expression
    {
        int Eval(ADT.IDictionary<string, int> dict);
    }
}
