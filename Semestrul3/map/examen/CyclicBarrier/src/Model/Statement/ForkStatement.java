package Model.Statement;

import Model.ADT.*;
import Model.FileHandling.FileData;
import Model.FileHandling.IFileTable;
import Model.ProgramState;

public class ForkStatement implements IStmt {
    private IStmt stmt;
    public ForkStatement(IStmt stmt)
    {
        this.stmt=stmt;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IStack<IStmt> exeStack = new CStack<>();
        IDictionary<String,Integer> symTable = state.getSymbolTable().copy();
        IList<Integer> output = state.getMessages();
        IFileTable<Integer, FileData> ft = state.getFileTable();
        IHeap<Integer,Integer> heap = state.getHeap();
        IBarrierTable<Integer,Pair> barrierTable = state.getBarrierTable();
        exeStack.push(stmt);
        Integer ID = GenIDFork.getID();
        ProgramState newp = new ProgramState(exeStack,symTable,output,stmt,ft,heap,barrierTable,ID);
        //newp.setID(newp.getID()+1);
        return newp;
    }
    @Override
    public String toString(){
        return "fork("+stmt+")";
    }


}
