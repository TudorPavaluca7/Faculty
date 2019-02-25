package Model.Statement;

import Model.ADT.IStack;
import Model.ProgramState;

public class CompoundStatement implements IStmt {
    IStmt first;
    IStmt snd;
    public CompoundStatement(IStmt f, IStmt s)
    {
        this.first=f;
        this.snd=s;
    }

    @Override
    public ProgramState execute(ProgramState state)
    {
        IStack<IStmt> stk=state.getExeStack();
        stk.push(snd);
        stk.push(first);
        return null;
    }

    @Override
    public String toString()
    {
        return "("+first.toString() + ";" + snd.toString()+")";
    }
}

