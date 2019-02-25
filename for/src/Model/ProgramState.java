package Model;

import Model.Utilities.*;
import  Model.Statements.*;
import Exception.EmptyStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgramState {
    private Integer id;
    private IStack<IStmt> stack;
    private IDictionary<String, Integer> SymTable;
    private IList<Integer> list;
    private IDictionary<Integer, BufferedReader> FileTable;
    private IDictionary<Integer, Integer> heap;

    public ProgramState(IStack<IStmt> stack, IDictionary<String, Integer> symTable, IList<Integer> list, IDictionary<Integer, BufferedReader> file,IDictionary<Integer, Integer> h) {
        this.stack = stack;
        this.SymTable = symTable;
        this.list = list;
        this.FileTable = file;
        this.heap=h;
        this.id=1;
    }

    public Integer getID(){return id;}

    public void setID(Integer i){id=i;}

    public IStack<IStmt> getStack() {
        return stack;
    }

    public List<IStmt> getStackList(){return stack.getToList();}

    public List<String> getStackListString(){
        List<String> l=new ArrayList<String>();
        for(IStmt s:getStackList()){
            l.add(s.toString());
        }
        return l;
    }

    public void setStack(IStack<IStmt> stack) {
        this.stack = stack;
    }

    public IDictionary<String, Integer> getSymTable() {
        return SymTable;
    }

    public void setFileTable(IDictionary<Integer, BufferedReader> table) {
        FileTable = table;
    }

    public IDictionary<Integer, BufferedReader> getFileTable() {
        return FileTable;
    }

    public void setHeap(IDictionary<Integer, Integer> table) {
        heap = table;
    }

    public void setHeapMap(Map<Integer, Integer> table) {
        heap.setMap(table);
    }

    public void setFileTableMap(Map<Integer, BufferedReader> table) {
        FileTable.setMap(table);
    }

    public void clearFileTable(){this.FileTable.clear();}

    public void clearFileFromSym(){
        this.SymTable.setMap(SymTable.getMap().entrySet().stream().
            filter(e->!FileTable.getMap().containsKey(e.getValue())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)));
    }

    public IDictionary<Integer, Integer> getHeap() {
        return heap;
    }

    public void setSymTable(IDictionary<String, Integer> symTable) {
        SymTable = symTable;
    }

    public IList<Integer> getList() {
        return list;
    }

    public List<Integer> getOut(){return list.getElementsL();}

    public void setList(IList<Integer> list) {
        this.list = list;
    }

    public Boolean isNotCompleted(){return !this.stack.isEmpty();}

    public ProgramState oneStep() throws IOException {
        if(stack.isEmpty()) throw new EmptyStack("The execution stack is empty!");
        IStmt crtStmt = stack.pop();
        return crtStmt.execute(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nProgram state -= "+id+" =-\n\n");

        sb.append("\nExeStack:\n");
        for(IStmt s : stack.getElements()) {
            sb.append(s).append("\n");
        }

        sb.append("\nSymTable:\n");
        for(String key : SymTable.getElements()){
            sb.append(key).append(" : ").append(SymTable.getValue(key)).append("\n");
        }

        sb.append("\nOut:\n");
        for(Integer i : list.getElements()){
            sb.append(i).append("\n");
        }

        sb.append("\nHeap:\n");
        for(Integer i : heap.getElements()){
            sb.append(i+" : "+heap.getValue(i)).append("\n");
        }

        sb.append("\nFileTable:\n");
        for(Integer i : FileTable.getElements()){
            sb.append(i+" : "+FileTable.getValue(i)).append("\n");
        }

        return sb.toString();
    }
}
