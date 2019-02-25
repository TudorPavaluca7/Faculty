package Model.Statement;
import Exceptions.*;
import Model.Expression.IExpression;
import Model.FileHandling.*;
import Model.ProgramState;
import java.io.BufferedReader;
import java.io.IOException;
public class CloseFileStatement implements IStmt {
    private IExpression fileDescriptor;

    public CloseFileStatement(IExpression fd)
    {
        this.fileDescriptor =fd;
    }

    @Override
    public ProgramState execute(ProgramState p)
    {
        try
        {
            int descriptor = this.fileDescriptor.eval(p.getSymbolTable(),p.getHeap());
            IFileTable<Integer,FileData> file =p.getFileTable();
            BufferedReader buff =   file.get(descriptor).getHeader();
            buff.close();
            file.remove(descriptor);
            return null;
        }
        catch (IOException e)
        {
            throw new FileException(e.toString()+"Eroare close file");
        }

    }

    @Override
    public String toString() {
        return "CloseFile("+this.fileDescriptor+")";
    }




}
