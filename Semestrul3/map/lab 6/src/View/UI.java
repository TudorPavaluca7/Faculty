//package View;
//import Controller.*;
//import Model.ADT.*;
//import Model.Expression.ArithmeticExpression;
//import Model.Expression.ConstExpression;
//import Model.Expression.VarExpression;
//import Model.ProgramState;
//import Model.Statement.*;
//import Model.FileHandling.*;
//import Repository.CRepo;
//import Repository.IRepo;
//import Exceptions.*;
//import java.util.Scanner;
//
//public class UI {
//
//    private IStack<IStmt> exeStack = new CStack<>();
//    private IDictionary<String, Integer> symbolTable = new CDictionary<>();
//    private IList<Integer> messages = new CList<>();
//    private IFileTable<Integer,FileData> fileTable=new FileTable<>();
//
//    public void menu() {
//
//        System.out.println("Available Programs: ");
//        System.out.println("v=2;Print(v)\n");
//        System.out.println("a=2+3*5;b=a+1;Print(b)\n");
//        System.out.println("a=2-2;(If a Then v=2 Else v=3);Print(v)\n");
//        System.out.println("openRFile(var_f,\"test.in\");\n" + "readFile(var_f,var_c);print(var_c);\n" + "(if var_c then readFile(var_f,var_c);print(var_c)\n" + "else print(0));\n" + "closeRFile(var_f)\n");
//        System.out.println("Available commands:");
//        System.out.println("1-run first program");
//        System.out.println("2 - run second program");
//        System.out.println("3 - run third program");
//        System.out.println("4 - run the fourth program");
//
//    }
//
//    public void ExecuteAllSteps(IStmt st) {
//
//        ProgramState state = new ProgramState(exeStack, symbolTable, messages, st,fileTable);
//        IRepo repo = new CRepo("log.txt");
//        Controller ctrl = new Controller(repo);
//        repo.addPrg(state);
//        ctrl.allSteps();
//    }
//
//    public void start() {
//        Scanner S = new Scanner(System.in);
//        this.menu();
//        while (true) {
//            try {
//                System.out.print("give the command: ");
//                int com = S.nextInt();
//                if (com == 0)
//                    break;
//                switch (com) {
//                    case 1: {
//                        IStmt ex1 = new CompoundStatement(new AssignStatement("v",new ConstExpression(2)),new PrintStatement(new VarExpression("v")));
//                        System.out.print(ex1);
//
//                        this.ExecuteAllSteps(ex1);
//                        break;
//                    }
//                    case 2: {
//                        IStmt ex2 = new CompoundStatement(new AssignStatement("a", new ArithmeticExpression('+', new ConstExpression(2), new
//                                ArithmeticExpression('*', new ConstExpression(3), new ConstExpression(5)))),
//                                new CompoundStatement(new AssignStatement("b", new ArithmeticExpression('+', new VarExpression("a"), new
//                                        ConstExpression(1))), new PrintStatement(new VarExpression("b"))));
//
//
//                        this.ExecuteAllSteps(ex2);
//
//                        break;
//
//                    }
//                    case 3: {
//
//                        IStmt ex3 = new CompoundStatement(new AssignStatement("a", new ArithmeticExpression('-', new ConstExpression(2), new
//                                ConstExpression(2))),
//                                new CompoundStatement(new IfStatement(new VarExpression("a"), new AssignStatement("v", new ConstExpression(2)), new
//                                        AssignStatement("v", new ConstExpression(3))), new PrintStatement(new VarExpression("v"))));
//
//                        this.ExecuteAllSteps(ex3);
//
//                        break;
//                    }
//                    case 4: {
//                     IStmt ex4= new CompoundStatement(
//                                    new CompoundStatement(
//                                            new OpenFileStatement("var_f","D:\\JavaRepository\\Map\\lab3\\src\\test.in"),
//                                            new ReadFileStatement(new VarExpression("var_f"),"var_c")
//                                    ),
//                                    new CompoundStatement(
//                                            new PrintStatement(new VarExpression("var_c")), new CloseFileStatement(new VarExpression("var_f")))
//
//
//
//
//
//                     );
//                     this.ExecuteAllSteps(ex4);
//
//                     break;
//                    }
//
//                    default:
//                        System.out.print("invalid command");
//                }
//
//
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//
//
//        }
//    }
//}
