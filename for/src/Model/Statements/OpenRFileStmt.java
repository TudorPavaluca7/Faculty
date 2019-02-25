package Model.Statements;

import Model.ProgramState;
import Model.Utilities.IDictionary;
import Exception.FileAlreadyExists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OpenRFileStmt implements IStmt {
    private String var;
    private String path;

    public OpenRFileStmt(String v, String s){var=v; path=s;}

    @Override
    public ProgramState execute(ProgramState state) throws IOException{
            BufferedReader b = new BufferedReader(new FileReader(path));
            IDictionary<Integer, BufferedReader> filetable=state.getFileTable();
            IDictionary<String, Integer> dic=state.getSymTable();

            if(!dic.exists(var)) {
                int i=0;
                while(true){
                    if(filetable.exists(i))
                        i++;
                    else break;
                }
                dic.setValue(var,i);
                filetable.setValue(i,b);
            }
            else throw new FileAlreadyExists("File already exists!");
            return null;
    }

    public String toString(){
        return "OpenFile("+var+","+path+")";
    }
}
