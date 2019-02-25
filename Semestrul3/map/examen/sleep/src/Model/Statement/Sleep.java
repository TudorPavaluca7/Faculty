package Model.Statement;

import Model.ProgramState;

public class Sleep implements IStmt {
    private int number;
    public Sleep(int number)
    {
        this.number=number;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        if (this.number>0)
            state.getExeStack().push(new Sleep(number-1));

        return null;
    }

    @Override
    public String toString() {
        return "sleep("+number+")";
    }
}
