package Repo;
import Model.*;
public interface RepoI {
    public void add(MyObjects obj) throws IndexOutOfBoundsException;
    public void delete(int index) throws IndexOutOfBoundsException;
    public int currentPos();
    public MyObjects[] getAll();
    public String moreThan();
}
