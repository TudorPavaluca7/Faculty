package Model.Statement;
import Exceptions.FileException;
import Model.FileHandling.FileData;
import Model.FileHandling.IdGenerator;
import Model.ProgramState;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class OpenFileStatement implements IStmt {
    private String fileName;
    private String varFile;

    public OpenFileStatement(String varFile, String fileName)
    {
        this.varFile=varFile;
        this.fileName=fileName;
    }

    @Override
    public ProgramState execute(ProgramState p) {

        if(isOpen(p))
        {
            throw new FileException("File already opened");
        }
        try
        {
            BufferedReader buff = new BufferedReader(new FileReader("D:\\Semestrul3\\map\\ToyLanguageInterpreter\\src\\test.in"));
            FileData fd= new FileData("D:\\Semestrul3\\map\\ToyLanguageInterpreter\\src\\test.in",buff);
            int id= IdGenerator.generateId();
            p.getFileTable().add(id,fd);
            p.getSymbolTable().add(this.varFile,id);
        }
        catch (IOException e)
        {
            throw  new FileException(e.toString()+"Eroare open file");
        }
        return null;

    }
    private boolean isOpen(ProgramState p)
    {
        for(FileData fd:p.getFileTable().getValues())
        {
            if(fd.getFileName().equals(fileName))
                return true;
        }
        return false;

    }
    @Override
    public String toString()
    {
        return "Open("+this.varFile+","+this.fileName+")";
    }



}
