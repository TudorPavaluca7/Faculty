package Model.Statements;

import Model.ProgramState;

import java.io.IOException;

public interface IStmt {
    ProgramState execute(ProgramState state)throws IOException;
}
