package Repository;
import Model.*;
public interface IRepo {
    public void addPrg(ProgramState prg);
    public ProgramState getCurrentP();
    public void logPrgStateExec();
}
