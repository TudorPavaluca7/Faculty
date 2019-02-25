package Model.Statements;

import Model.ProgramState;
import Model.Utilities.IStack;

import java.io.IOException;

public class CompStmt implements IStmt {
    private  IStmt first, second;

    public CompStmt(IStmt f, IStmt s){
        first = f;
        second = s;
    }

    @Override
    public ProgramState execute(ProgramState state){
        IStack<IStmt> stack = state.getStack();
        stack.add(second);
        stack.add(first);

        return null;
    }

    public String toString(){
        return "(" + first + "; " + second + ")";
    }
}
