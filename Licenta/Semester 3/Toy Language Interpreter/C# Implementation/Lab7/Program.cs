using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Lab7.View;
using Lab7.Repository;
using Lab7.Controller;
using Lab7.Model;
using Lab7.Model.ADT;
using Lab7.Model.Statements;
using Lab7.Model.Expressions;
namespace Lab7
{
   class Program
    {
        static void Main(string[] args)
        {
            //IExeStack<Statement> exeStack = new ExeStack<Statement>();
            //Model.ADT.IDictionary<string, int> symbolTable = new DictionaryC<string, int>();
            //IOutput<int> messages = new Output<int>();
            //IFileTable<int, FileData> fd = new FileTable<int, FileData>();

            //Statement s = new CompoundStatement(new AssignStatement("v", new ConstantExpression(2)), new PrintStatement(new VariableExpression("v")));
            //exeStack.Push(s);
            //PrgState state = new PrgState(symbolTable, exeStack, messages, fd);
            //IPrgRepository repo = new PrgRepository(state);
            //Controller.Controller ctrl = new Controller.Controller(repo);

            IExeStack<Statement> exeStack1 = new ExeStack<Statement>();
            Model.ADT.IDictionary<string, int> symbolTable1 = new DictionaryC<string, int>();
            IOutput<int> messages1 = new Output<int>();
            IFileTable<int, FileData> fd1 = new FileTable<int, FileData>();

            Statement s1= new CompoundStatement(
                           new CompoundStatement(
                                   new CompoundStatement(
                                           new OpenFileStatement("var_f", "D:\\Semestrul3\\map\\Lab7\\Lab7\\test.in"),
                                           
                                           new ReadFileStatement(new VariableExpression("var_f"), "var_c")
                                   ),
                                   new CompoundStatement(
                                           new PrintStatement(new VariableExpression("var_c")),
                                           new IfStatement(
                                                   new VariableExpression("var_c"),
                                                   new PrintStatement(new ConstantExpression(0))
                                                  , new CompoundStatement(
                                                           new ReadFileStatement(new VariableExpression("var_f"), "var_c"),
                                                           new PrintStatement(new VariableExpression("var_c")))))),new CloseFileStatement(new VariableExpression("var_f")));

            //exeStack1.Push(s1);
            PrgState state1 = new PrgState(symbolTable1, exeStack1, messages1, fd1,s1);
            IPrgRepository repo1 = new PrgRepository(state1);
            Controller.Controller ctrl1 = new Controller.Controller(repo1);

            TextMenu menu = new TextMenu();
            menu.addCommand(new ExitCommand("0", "exit"));
            //menu.addCommand(new RunExample("1", s.ToString(), ctrl));
            menu.addCommand(new RunExample("2", s1.ToString(), ctrl1));
            menu.show();
        }
    }
}
