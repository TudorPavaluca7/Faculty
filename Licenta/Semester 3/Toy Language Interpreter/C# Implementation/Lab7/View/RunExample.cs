using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Lab7.Controller;
namespace Lab7.View
{
    public class RunExample : Command
    {
        private Controller.Controller ctrl;
        public RunExample(string key, string desc, Controller.Controller ctr) : base(key, desc)
        {
            this.ctrl = ctr;
        }

        public override void execute()
        {

            try
            {
                ctrl.executeAllSteps();
            }
            catch (SystemException e)
            {
                Console.WriteLine(e.Message);
            }
        }

    }
}
