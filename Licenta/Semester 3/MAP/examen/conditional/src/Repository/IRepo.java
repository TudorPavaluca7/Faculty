package Repository;

import Model.ProgramState;

import java.util.List;

public interface IRepo {
    public void addPrg(ProgramState prg);
    //public ProgramState getCurrentP();
    public void logPrgStateExec(ProgramState p);
    public List<ProgramState> getPrgList();
    public void setPrgList(List<ProgramState> list);

}
