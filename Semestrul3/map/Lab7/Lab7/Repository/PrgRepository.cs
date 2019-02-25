using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using Lab7.Model;
using Lab7.Model.Statements;
namespace Lab7.Repository
{
    public class PrgRepository : IPrgRepository
    {
        private PrgState p;
        public PrgRepository(PrgState p)
        {
            this.p = p;
        }

        public PrgState getCurrentPrgState()
        {
            return this.p;
        }
        public void logPrgState()
        {
            PrgState p = this.getCurrentPrgState();

            using (StreamWriter log = File.AppendText("D:\\Semestrul3\\map\\Lab7\\Lab7\\log.txt"))
            {

                log.WriteLine("ExeStack:\n");
                foreach (Statement st in p.Stack)
                {
                    log.WriteLine(st);
                }
                log.WriteLine("SymbolTable:\n");
                foreach (KeyValuePair<string, int> v in p.Dict)
                {
                    log.WriteLine(v.Key + "->" + v.Value);
                }

                log.WriteLine("Output list:");
                foreach (int v in p.Messages)
                {
                    log.WriteLine(v);
                }
                log.WriteLine("File Table:");
                foreach (KeyValuePair<int, FileData> kvp in p.FileTable)
                {
                    log.WriteLine(kvp.Key + "->" + kvp.Value.FileName);
                }

            }

        }
    }
}
