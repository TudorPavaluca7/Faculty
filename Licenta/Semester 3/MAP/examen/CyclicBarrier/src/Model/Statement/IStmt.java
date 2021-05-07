package Model.Statement;

import Model.ProgramState;

public interface IStmt {
    ProgramState execute(ProgramState state);
}
