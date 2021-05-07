package Model;

import Exceptions.EmptyStackException;
import Model.ADT.IDictionary;
import Model.ADT.IHeap;
import Model.ADT.IList;
import Model.ADT.IStack;
import Model.FileHandling.FileData;
import Model.FileHandling.IFileTable;
import Model.Statement.IStmt;

import java.util.Map;

public class ProgramState {
    private IStack<IStmt> exeStack;
    private IDictionary<String,Integer> symTable;
    private IList<Integer> output;
    private IStmt originalProgram;
    private IFileTable<Integer, FileData> fileTable;
    private IHeap<Integer,Integer> heap;
    private int ID;

    public ProgramState(IStack<IStmt> stk, IDictionary<String,Integer> symtbl,
                        IList<Integer> ot, IStmt prg, IFileTable<Integer, FileData> fd, IHeap<Integer,Integer> h){
        this.exeStack=stk;
        this.symTable=symtbl;
        this.output = ot;
        this.fileTable=fd;
        this.heap=h;
        this.ID=1;
        //stk.push(prg);
    }
    public IStack<IStmt> getExeStack() {
        return this.exeStack;
    }

    public IDictionary<String, Integer> getSymbolTable() {
        return this.symTable;
    }

    public boolean  isNotCompleted()
    {
        if (this.exeStack.isEmpty()==true)
            return false;
        else
            return true;

    }
    public ProgramState oneStep(){
        if(exeStack.isEmpty())
            throw new EmptyStackException("The stack is empty");
        IStmt crtStmt = exeStack.pop();


        return crtStmt.execute(this);
    }

    public void setHeapMap(Map<Integer, Integer> table) {
        heap.setContent(table);
    }
    //public void clearFileTable(){this.fileTable.}
    public IList<Integer> getMessages() {
        return this.output;
    }
    public IFileTable<Integer, FileData> getFileTable(){return this.fileTable;}
    public IHeap<Integer,Integer> getHeap() {return this.heap;}
    public int getID() {
        return ID;
    }
    public void setID(Integer i){this.ID=i;}
    @Override
    public String toString()
    {
        StringBuffer buff = new StringBuffer();
        buff.append("\nID:"+this.ID+"\n");
        buff.append("Exestack:\n");
        buff.append(exeStack);
        buff.append("\nSymbolTable:\n");
        buff.append(symTable);
        buff.append("\nMessages:\n");
        buff.append(output);
        buff.append("\n");
        buff.append("\nFileTable:\n");
        buff.append(fileTable);
        buff.append("\n");
        buff.append("\nHeap:\n");
        buff.append(this.heap);
        buff.append("\n");
        return buff.toString();
    }
}
