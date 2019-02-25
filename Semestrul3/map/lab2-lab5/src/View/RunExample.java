package View;
import Controller.*;
import Exceptions.*;
public class RunExample extends Command {
   private Controller ctrl;
    public RunExample(String key, String desc,Controller ctr){
        super(key, desc);
        this.ctrl=ctr;
    }

    @Override
    public void execute() {
        try{
            this.ctrl.allSteps();
        }catch (Exception e){ System.out.println(e);}
    }
}
