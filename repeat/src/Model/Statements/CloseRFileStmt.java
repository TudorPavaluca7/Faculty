package Model.Statements;

import Model.Expressions.IExpr;
import Model.ProgramState;
import Model.Utilities.IDictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CloseRFileStmt implements IStmt {
    private IExpr id;
    public CloseRFileStmt(IExpr e){id=e;}

    @Override
    public ProgramState execute(ProgramState state) throws IOException {
        IDictionary<String,Integer> dic=state.getSymTable();
        IDictionary<Integer, BufferedReader> filetable=state.getFileTable();
        IDictionary<Integer, Integer> heap=state.getHeap();
        int val=id.evaluate(dic,heap);
        if(filetable.exists(val)) {
            BufferedReader b = filetable.getValue(val);
            b.close();
            filetable.delete(val);
        }
        else throw new FileNotFoundException("File not found!");
        return null;
    }

    public String toString(){
        return "close("+id+")";
    }
}
