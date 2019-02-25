import Controller.Controller;
import Model.Fish;
import Model.Turtle;
import Repo.RepoC;
import View.*;
import javax.swing.text.View;

public class main {
    public static void main(String args[])
    {
        Fish f1 = new Fish(0.2);
        Fish f2 = new Fish(2);
        Fish f3 = new Fish(0.5);
        Fish f4 = new Fish(1);
        Fish f5 = new Fish(1.2);
        Turtle t1 = new Turtle(1);
        Turtle t2 = new Turtle(10);
        Turtle t3 = new Turtle(0.1);
        Turtle t4 = new Turtle(20);
        Turtle t5 = new Turtle(0.9);
        RepoC rep = new RepoC(100);
        Controller ctrl = new Controller(rep);
        ctrl.Add(f1);
        ctrl.Add(f2);
        ctrl.Add(f3);
        ctrl.Add(f4);
        ctrl.Add(f5);
        ctrl.Add(t1);
        ctrl.Add(t2);
        ctrl.Add(t3);
        ctrl.Add(t4);
        ctrl.Add(t5);
        view v=new view(ctrl);
        v.start();

    }
}
