package Controller;
import Model.MyObjects;
import Repo.*;
public interface ICtrl {
    public void Add(MyObjects obj);
    public void remove(int index);
    public String morethan();
}
