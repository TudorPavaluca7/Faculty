package Repository;

import Model.ProgramState;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepo {
    private List<ProgramState> listPrg = new ArrayList<>();
    private int current = 0;
    @Override
    public void addPrg(ProgramState prg) {
        listPrg.add(prg);
    }

    public void logProgramStateExec(ProgramState state) throws IOException {
        String logFilePath="log";
        logFilePath+=state.getID();
        PrintWriter logFile=new PrintWriter(new BufferedWriter(new FileWriter(logFilePath,true)));
        logFile.println(state.toString());
        logFile.println("------------------");
        logFile.close();
    }

    public List<ProgramState> getPrgList(){
        return listPrg;
    }

    public void setPrgList(List<ProgramState> list){
        this.listPrg=list;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (ProgramState state : listPrg){
            sb.append(state).append("\n");
        }
        return sb.toString();
    }

    public IRepo clone(){
            IRepo r= new Repository();
            for(ProgramState p:listPrg){
                r.addPrg(p);
            }
            return r;
    }
}
