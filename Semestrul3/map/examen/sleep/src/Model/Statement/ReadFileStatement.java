package Model.Statement;

import Exceptions.FileException;
import Model.Expression.ConstExpression;
import Model.Expression.IExpression;
import Model.FileHandling.FileData;
import Model.FileHandling.IFileTable;
import Model.ProgramState;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileStatement implements IStmt {
    private IExpression fileDescriptor;
    private String varName;

    public ReadFileStatement(IExpression fd, String var)
    {
        this.fileDescriptor=fd;
        this.varName=var;
    }

    @Override
    public ProgramState execute(ProgramState p)
    {
        try
        {
            int descriptor=this.fileDescriptor.eval(p.getSymbolTable(),p.getHeap());
            IFileTable<Integer, FileData> filetable=p.getFileTable();
            if(!filetable.contains(descriptor))
                throw new FileException("Descriptor does not match any open file");
            BufferedReader buff= filetable.get(descriptor).getHeader();
            String line = buff.readLine();
            ConstExpression val;
            if(line==null)
                val = new ConstExpression(0);
            else
                val=new ConstExpression(Integer.parseInt(line));

            IStmt st = new AssignStatement(this.varName,val);
            st.execute(p);
            return null;

        }
        catch (IOException e)
        {
            throw  new FileException(e.toString()+"Eroare read file");
        }


    }

   @Override
    public String toString()
   {
       return "Read (" +this.fileDescriptor +","+this .varName+")";
   }

}
