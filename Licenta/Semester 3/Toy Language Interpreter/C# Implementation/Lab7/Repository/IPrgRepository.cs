using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Lab7.Model;
namespace Lab7.Repository
{
    public interface IPrgRepository
    {
        
        PrgState getCurrentPrgState();

        void logPrgState();
    }
}
