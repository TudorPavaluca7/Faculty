package Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        menu();
        Utils utils=new Utils();
        Scanner keyboard = new Scanner(System.in);
        Grammar grammar = new Grammar("D:\\Semestrul 5\\LFTC\\Laboratoare\\Lab2\\src\\rg.txt");
        FiniteAutomata finiteAutomata = new FiniteAutomata("D:\\Semestrul 5\\LFTC\\Laboratoare\\Lab2\\src\\fa.txt");
        while(true) {

            System.out.println("choose the option: ");
            int option = keyboard.nextInt();
            if (option==0)
                break;
            switch(option) {
                case 1:
                  System.out.print(grammar.toString());
                  for (String s:grammar.getN())
                     System.out.println(grammar.form2(grammar.getProduction(s)));
                  break;
                case 2:
                    System.out.println(finiteAutomata.toString());
                    for (String s:finiteAutomata.getQ())
                        System.out.println(finiteAutomata.form(finiteAutomata.getTransitions(s)));
                    break;
                case 3:
                    System.out.println(utils.CreateGrammarFromFa(finiteAutomata,grammar));
                    break;
                case 4:
                    System.out.println(utils.CreateFaFromGrammar(finiteAutomata,grammar));
                    break;

            }
        }


    }
    private static void menu()
    {

        System.out.println("1. Read grammar from file");
        System.out.println("2. Read finite automata from file");
        System.out.println("3. Construct grammar from finite automata");
        System.out.println("4. Construct finite automata from grammar");
        System.out.println("0. Exit");

    }

}
