using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Lab7.Repository;
using Lab7.Model;
using Lab7.Model.Statements;
namespace Lab7.Controller
{
    public class Controller
    {
        private IPrgRepository repo;

        public Controller(IPrgRepository r)
        {
            this.repo = r;
        }

        public void executeOneStep()
        {
            PrgState p = repo.getCurrentPrgState();
            Statement stmt = p.Stack.pop();

            stmt.Execute(p);
            Console.WriteLine(p);
        }

        public void executeAllSteps()
        {
            PrgState p = repo.getCurrentPrgState();
            while (!p.Stack.IsEmpty())
            {
                this.executeOneStep();
                repo.logPrgState();
            }
        }

    }
}
