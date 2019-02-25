package Model.Statements;

import Model.Expressions.IExpr;
import Model.ProgramState;
import Model.Utilities.IDictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileStmt implements IStmt {
    private IExpr id;
    private String var;
    public ReadFileStmt(IExpr e, String s){id=e; var=s;}

    @Override
    public ProgramState execute(ProgramState state) throws IOException {
        IDictionary<String,Integer> dic=state.getSymTable();
        IDictionary<Integer, Integer> heap=state.getHeap();
        int val=id.evaluate(dic,heap);
        IDictionary<Integer,BufferedReader> filetable=state.getFileTable();
        if(filetable.exists(val)) {
            BufferedReader b = filetable.getValue(val);
            String line=b.readLine();
            int myValue;
            if(line==null)
                myValue=0;
            else
                myValue=Integer.parseInt(line);
            if(dic.exists(var)){
                dic.delete(var);
                dic.setValue(var,myValue);
            }
            else
                dic.setValue(var,myValue);

        }else
            throw new FileNotFoundException("File not found!");
        return null;
    }

    public String toString(){
        return "ReadFile("+id+","+var+")";
    }
}
