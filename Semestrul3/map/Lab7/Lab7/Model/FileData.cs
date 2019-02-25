using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
namespace Lab7.Model
{
    public class FileData
    {
        private string filename;
        private StreamReader header;

        public FileData(string filename, StreamReader h)
        {
            this.filename = filename;
            this.header = h;
        }

        public string FileName
        {
            get { return this.filename; }
            set { this.filename = value; }
        }
        public StreamReader Header
        {
            get { return this.header; }
            set { this.header = value; }
        }

        public override string ToString()
        {
            return filename;
        }
    }
}

