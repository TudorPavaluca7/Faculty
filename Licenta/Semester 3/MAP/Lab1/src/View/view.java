package View;
import java.util.Scanner;
import Model.Fish;
import Model.MyObjects;
import Model.Turtle;
import Controller.*;
import Repo.RepoC;

public class view {
    private Controller ctrl;
    Scanner S=new Scanner(System.in);
    public view(Controller ctrl) {
        this.ctrl = ctrl;
    }

    public void menu() {
        System.out.print("1-add\n");
        System.out.print("2-delete\n");
        System.out.print("3-show\n");
    }

    public void add() {
        MyObjects tf;
        tf=null;
        System.out.print("give the animal:");
       // System.out.println("give the age: ");
        switch(S.next())
        {
            case "turtle":
            {
                System.out.print("give the age: ");
                tf= new Turtle(S.nextDouble());
                break;
            }
            case "fish":
            {
                System.out.print("give the age: ");
                tf= new Fish(S.nextDouble());
                break;
            }
            default:
                System.out.print("invalid animal\n");
                return;
        }

        try{
            this.ctrl.Add(tf);
        }catch (IndexOutOfBoundsException e){System.out.print("you can't add anymore\n");};
    }
    public void remove(){
        System.out.print("give the index: ");
        //Scanner S=new Scanner(System.in);
        int id=S.nextInt();
        try {
            this.ctrl.remove(id);
        }catch (IndexOutOfBoundsException e){System.out.print("the index is invalid\n");}
    }
    public void start() {


        this.menu();
        while (true) {

            System.out.print("give the command: ");
            //int com=Integer.parseInt(System.console().readLine());
            //Scanner S = new Scanner(System.in);
            int com = S.nextInt();

            if (com == 0)
                break;
            switch (com) {
                case 1: {
                    this.add();

                    break;
                }
                case 2: {
                    this.remove();
                    break;
                }
                case 3: {
                    System.out.print(this.ctrl.morethan());
                    break;
                }
                default:
                {
                    System.out.print("invalid command");

                }

            }

        }
    }
}
