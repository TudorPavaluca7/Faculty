package View;
import Controller.Controller;
import Model.ADT.*;
import Model.Expression.ArithmeticExpression;
import Model.Expression.ConstExpression;
import Model.Expression.ConstExpression;
import Model.Expression.ReadHeapExpression;
import Model.Expression.VarExpression;
import Model.FileHandling.FileData;
import Model.FileHandling.FileTable;
import Model.FileHandling.IFileTable;
import Model.FileHandling.IdGenerator;
import Model.ProgramState;
import Model.Statement.*;
import Repository.CRepo;
import Repository.IRepo;

public class Main {
    public static void main(String[] args)
    {

       IStack<IStmt> exeStack = new CStack<>();
       IDictionary<String, Integer> symbolTable = new CDictionary<>();
       IList<Integer> messages = new CList<>();
       IFileTable<Integer,FileData> fileTable=new FileTable<>();
        IHeap<Integer,Integer> heap1 = new Heap<>();

        IStmt ex1=new CompoundStatement(new AssignStatement("v",new ConstExpression(2)),new PrintStatement(new VarExpression("v")));
        exeStack.push(ex1);
        ProgramState state1 = new ProgramState(exeStack, symbolTable, messages,ex1,fileTable,heap1);
        IRepo repo1 = new CRepo("log.txt");
        Controller ctrl1 = new Controller(repo1);
        repo1.addPrg(state1);


        IStack<IStmt> exeStack1 = new CStack<>();
        IDictionary<String, Integer> symbolTable1 = new CDictionary<>();
        IList<Integer> messages1 = new CList<>();
        IFileTable<Integer,FileData> fileTable1=new FileTable<>();
        IHeap<Integer,Integer> heap2 = new Heap<>();


        IStmt ex2=new CompoundStatement(new AssignStatement("a", new ArithmeticExpression('+', new ConstExpression(2), new
                        ArithmeticExpression('*', new ConstExpression(3), new ConstExpression(5)))),
                new CompoundStatement(new AssignStatement("b", new ArithmeticExpression('+', new VarExpression("a"), new
                        ConstExpression(1))), new PrintStatement(new VarExpression("b"))));
        ProgramState state2 = new ProgramState(exeStack1, symbolTable1, messages1,ex2,fileTable1,heap2);
        IRepo repo2 = new CRepo("log.txt");
        Controller ctrl2 = new Controller(repo2);
        repo2.addPrg(state2);

        IStack<IStmt> exeStack2 = new CStack<>();
        IDictionary<String, Integer> symbolTable2 = new CDictionary<>();
        IList<Integer> messages2 = new CList<>();
        IFileTable<Integer,FileData> fileTable2=new FileTable<>();
        IHeap<Integer,Integer> heap3 = new Heap<>();

        IStmt ex3=new CompoundStatement(new AssignStatement("a", new ArithmeticExpression('-', new ConstExpression(2), new
                ConstExpression(2))),
                new CompoundStatement(new IfStatement(new VarExpression("a"), new AssignStatement("v", new ConstExpression(2)), new
                        AssignStatement("v", new ConstExpression(3))), new PrintStatement(new VarExpression("v"))));

        ProgramState state3 = new ProgramState(exeStack2, symbolTable2, messages2,ex3,fileTable2,heap3);
        IRepo repo3 = new CRepo("log.txt");
        Controller ctrl3 = new Controller(repo3);
        repo3.addPrg(state3);


        IStack<IStmt> exeStack3 = new CStack<>();
        IDictionary<String, Integer> symbolTable3 = new CDictionary<>();
        IList<Integer> messages3 = new CList<>();
        IFileTable<Integer,FileData> fileTable3=new FileTable<>();
        IHeap<Integer,Integer> heap4 = new Heap<>();


        IStmt ex4=
                //new CompoundStatement(
                new CompoundStatement(
                        new CompoundStatement(
                                new OpenFileStatement("var_f","D:\\JavaRepository\\Map\\lab3\\src\\test.in"),
                                new ReadFileStatement(new VarExpression("var_f"),"var_c")
                        ),
                        new CompoundStatement(
                                new PrintStatement(new VarExpression("var_c")),
                                new IfStatement(
                                        new VarExpression("var_c"),
                                        new CompoundStatement(
                                                new ReadFileStatement(new VarExpression("var_f"),"var_c"),
                                                new PrintStatement(new VarExpression("var_c"))
                                        ),
                                        new PrintStatement(new ConstExpression(0))
                                )
                        )
                //),new CloseFileStatement(new VarExpression("var_f"))
        );
        ProgramState state4 = new ProgramState(exeStack3, symbolTable3, messages3,ex4,fileTable3,heap4);
        IRepo repo4 = new CRepo("log.txt");
        Controller ctrl4 = new Controller(repo4);
        repo4.addPrg(state4);


        IStack<IStmt> exeStack4 = new CStack<>();
        IDictionary<String, Integer> symbolTable4 = new CDictionary<>();
        IList<Integer> messages4 = new CList<>();
        IFileTable<Integer,FileData> fileTable4=new FileTable<>();
        IHeap<Integer,Integer> heap5 = new Heap<>();

//        IStmt ex5 = new CompoundStatement(
//                new AssignStatement("v",new ConstExpression(10)), new CompoundStatement(
//                new NewStatement("v",new ConstExpression(20)),new CompoundStatement(
//                new NewStatement("a",new ConstExpression(22)),new CompoundStatement(
//                new HeapWriteStatement("a",new ConstExpression(30)),new CompoundStatement(
//                new PrintStatement(new VarExpression("a")),new CompoundStatement(
//                new PrintStatement(new ReadHeapExpression("a")),new AssignStatement("a",new ConstExpression(0))))))));

        IStmt q = new AssignStatement("v", new ConstExpression(10));
        IStmt q1 = new NewStatement("v",new ConstExpression(20));
        IStmt q2 = new NewStatement("a", new ConstExpression(22));
        IStmt q3 = new HeapWriteStatement("a", new ConstExpression(30));
        IStmt q4 = new PrintStatement(new VarExpression("a"));
        IStmt q5 = new PrintStatement(new ReadHeapExpression("a"));
        IStmt q6 = new AssignStatement("a", new ConstExpression(0));

        IStmt d1 = new CompoundStatement(q, q1);
        IStmt d2 = new CompoundStatement(q2, q3);
        IStmt d3 = new CompoundStatement(q4, q5);

        IStmt ex5 = new CompoundStatement(new CompoundStatement(d1,d2), new CompoundStatement(d3,q6));

        ProgramState state5 = new ProgramState(exeStack4, symbolTable4, messages4,ex5,fileTable4,heap5);
        IRepo repo5 = new CRepo("log.txt");
        Controller ctrl5 = new Controller(repo5);
        repo5.addPrg(state5);

        IStack<IStmt> exeStack5 = new CStack<>();
        IDictionary<String, Integer> symbolTable5 = new CDictionary<>();
        IList<Integer> messages5 = new CList<>();
        IFileTable<Integer,FileData> fileTable5=new FileTable<>();
        IHeap<Integer,Integer> heap6 = new Heap<>();




        IStmt a1 =  new AssignStatement("v", new ConstExpression(6));
        IStmt a2 = new WhileStatement(new ArithmeticExpression('-',new VarExpression("v"), new ConstExpression(4) ),
             new CompoundStatement(new PrintStatement(new VarExpression("v")), new AssignStatement("v", new ArithmeticExpression('-',new VarExpression("v"), new ConstExpression(1) ))));

        IStmt a3 = new PrintStatement(new VarExpression("v"));

        IStmt ex6 = new CompoundStatement(new CompoundStatement(a1,a2), a3);

        ProgramState state6 = new ProgramState(exeStack5, symbolTable5, messages5,ex6,fileTable5,heap6);
        IRepo repo6 = new CRepo("log.txt");
        Controller ctrl6 = new Controller(repo6);
        repo6.addPrg(state6);

        IStack<IStmt> exeStack6 = new CStack<>();
        IDictionary<String, Integer> symbolTable6 = new CDictionary<>();
        IList<Integer> messages6 = new CList<>();
        IFileTable<Integer,FileData> fileTable6=new FileTable<>();
        IHeap<Integer,Integer> heap7 = new Heap<>();
//
//        IStmt f1 = new AssignStatement("v", new ConstExpression(10));
//        IStmt f2 = new NewStatement("a", new ConstExpression(22));
//
//        IStmt f3 = new HeapWriteStatement("a", new ConstExpression(30));
//        IStmt f4 = new AssignStatement("v", new ConstExpression(32));
//        IStmt f5 = new PrintStatement(new VarExpression("v"));
//        IStmt f6 = new PrintStatement(new ReadHeapExpression("a"));
//        IStmt f7 = new CompoundStatement(new CompoundStatement(f3,f4), new CompoundStatement(f5,f6));
//
//        IStmt f8 = new ForkStatement(f7);
//
//        IStmt f9 = new PrintStatement(new VarExpression("v"));
//        IStmt f10 = new PrintStatement(new ReadHeapExpression("a"));
//
//        IStmt c1 = new CompoundStatement(f1, f2);
//        IStmt c2 = new CompoundStatement(f8, new CompoundStatement(f9, f10));
//
//        IStmt ex7 = new CompoundStatement(c1,c2);
        IStmt ex7=new CompoundStatement(new AssignStatement("v",new ConstExpression(10)),new CompoundStatement(
             new NewStatement("a",new ConstExpression(22)),new CompoundStatement(
             new ForkStatement(new CompoundStatement(new HeapWriteStatement("a",new ConstExpression(30)),new CompoundStatement(
                     new AssignStatement("v",new ConstExpression(32)),new CompoundStatement(
                     new PrintStatement(new VarExpression("v")),new PrintStatement(new ReadHeapExpression("a"))
             )))),new CompoundStatement(
             new PrintStatement(new VarExpression("v")),new PrintStatement(new ReadHeapExpression("a"))
     ))));

     //IStmt ex7 =new CompoundStatement(new CompoundStatement(new AssignStatement("v",new ConstExpression(2)),new ForkStatement(new AssignStatement("v",new ConstExpression(2)))),new ForkStatement(new AssignStatement("v",new ConstExpression(3))));
        exeStack6.push(ex7);
        ProgramState state7 = new ProgramState(exeStack6, symbolTable6, messages6,ex7,fileTable6,heap7);
        IRepo repo7 = new CRepo("log.txt");
        Controller ctrl7 = new Controller(repo7);
        repo7.addPrg(state7);



     TextMenu menu = new TextMenu();
     menu.addCommand(new ExitCommand("0", "exit"));
     menu.addCommand(new RunExample("1",ex1.toString(),ctrl1));
     menu.addCommand(new RunExample("2",ex2.toString(),ctrl2));
     menu.addCommand(new RunExample("3",ex3.toString(),ctrl3));
     menu.addCommand(new RunExample("4",ex4.toString(),ctrl4));
     menu.addCommand(new RunExample("5",ex5.toString(),ctrl5));
     menu.addCommand(new RunExample("6",ex6.toString(),ctrl6));
     menu.addCommand(new RunExample("7",ex7.toString(),ctrl7));
     menu.show();


    }
}
