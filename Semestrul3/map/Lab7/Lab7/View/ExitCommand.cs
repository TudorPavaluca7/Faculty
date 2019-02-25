using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7.View
{
    public class ExitCommand : Command
    {
        public ExitCommand(string key, string desc) : base(key, desc) { }


        public override void execute()
        {
            Environment.Exit(0);
        }
    }
}
