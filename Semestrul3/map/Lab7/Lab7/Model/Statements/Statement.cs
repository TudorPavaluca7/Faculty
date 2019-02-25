using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7.Model.Statements
{
    public interface Statement
    {
        PrgState Execute(PrgState p);
    }
}
