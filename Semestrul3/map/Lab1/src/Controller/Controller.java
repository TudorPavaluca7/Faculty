package Controller;

import Model.MyObjects;
import Repo.RepoI;

public class Controller implements  ICtrl {
    RepoI repo;
    public Controller(RepoI rep)
    {
        this.repo=rep;
    }
    public void Add(MyObjects obj){
        this.repo.add(obj);
    }
    public void remove(int index){
        this.repo.delete(index);
    }
    public String morethan(){
        return repo.moreThan();
    }

}
