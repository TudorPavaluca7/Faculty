package Repository;

import Exceptions.FileException;
import Model.ADT.IDictionary;
import Model.FileHandling.FileData;
import Model.FileHandling.IFileTable;
import Model.ProgramState;
import Model.Statement.IStmt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CRepo implements IRepo {
    private List<ProgramState> programs;
    private String filename;

    public CRepo(String filename){this.filename=filename;
        this.programs=new ArrayList<>();

    }


    @Override
    public void addPrg(ProgramState prg) {
        this.programs.add(prg);
    }

//    @Override
//    public ProgramState getCurrentP() {
//        return this.programs.get(0);
//    }

    @Override
    public void logPrgStateExec(ProgramState p) {
        // ProgramState p = this.getCurrentP();
        try (PrintWriter log = new PrintWriter(new BufferedWriter(new FileWriter(this.filename,true)));
        )
        {
            log.println("ProgramId:"+p.getID());
            log.println("ExeStack:\n");
            for(IStmt st:p.getExeStack().getAll())
            {
                log.println(st);
            }
            log.println("SymbolTable:\n");
            IDictionary<String,Integer> d = p.getSymbolTable();
            for(String key:p.getSymbolTable().getAll())
            {
                log.println(key+"->"+d.get(key));
            }
            log.println("Output list:");
            for(Integer v:p.getMessages().getAll())
            {
                log.println(v);
            }
            log.println("FileTable: ");
            IFileTable<Integer, FileData> iif=p.getFileTable();
            for(Integer key:iif.getAll())
                log.println(key+"->"+iif.get(key));

            log.flush();
            log.close();
        }
        catch (IOException e)
        {
            throw new FileException(e.toString());
        }


    }
    @Override
    public List<ProgramState> getPrgList()
    {
        return this.programs;
    }

    @Override
    public void setPrgList(List<ProgramState> list) {
        this.programs=list;
    }
}
