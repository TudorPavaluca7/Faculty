import Model.BinaryTree.BinarySearchTree;
import Model.Language_Specification;
import Model.PIF;
import Model.Scanner;
import Model.SymbolTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//public class Program {
//
//    private static ArrayList<String> lines = new ArrayList<String>();
//    private static Language_Specification ls =  new Language_Specification();
//    private static Scanner scanner=new Scanner(ls);
//
//    static void readFromFile() throws Exception
//    {
//        File file = new File("D:\\Semestrul 5\\LFTC\\Laboratoare\\Lab1\\Implementation\\src\\a.txt");
//
//        BufferedReader br = new BufferedReader(new FileReader(file));
//
//        String st;
//        while ((st = br.readLine()) != null)
//            lines.add(st);
//
//    }
//
//    static boolean isIdentifier(String s)
//    {
//        if (s.length()>250)
//            return false;
//        if (!Character.isLetter(s.charAt(0)))
//            return false;
//        for (int i=1; i<s.length(); i++)
//            if (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i)))
//                return false;
//        return true;
//    }
//
//    static boolean isConstant(String s)
//    {
//        int ok=0;
//        if (s.charAt(0)=='"' && s.charAt(s.length()-1)=='"')
//            return true;
//        else
//         if (String.valueOf(s.charAt(0)).equals("'") && String.valueOf(s.charAt(s.length()-1)).equals("'"))
//             return true;
//         for (int i=0; i<s.length(); i++)
//             if (Character.isDigit(s.charAt(i))==false && s.charAt(i)!=',')
//                 return false;
//             else
//                 if (s.charAt(i)!=',' && ok==0)
//                     ok=1;
//         return true;
//    }
//
//
//    public static void main(String[] args) throws Exception {
//        int nrLine=0,id;
//
//        try {
//            readFromFile();
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        SymbolTable identifiers = new SymbolTable();
//        SymbolTable constants = new SymbolTable();
//        PIF pif=new PIF();
//        for (String line:lines) {
//            ArrayList<String> tokens = scanner.Generator(line);
//            System.out.println(line);
//            nrLine += 1;
//            for (String token : tokens) {
//                //System.out.println(token);
//                if (ls.getEverything().contains(token))
//
//                    pif.add(ls.getEverything().indexOf(token),-1);
//
//                else
//                    if (isIdentifier(token))
//                    {
//                        id=identifiers.add(token);
//                        pif.add(ls.getEverything().indexOf("identifier"),id);
//                    }
//                else
//                    if (isConstant(token))
//                    {
//                        id = constants.add(token);
//                        pif.add(ls.getEverything().indexOf("constant"),id);
//                    }
//                 else
//                     throw new Exception("Undentified token " + token + " at line " + nrLine);
//
//            }
//
//        }
//
//        identifiers.print();
//        constants.print();
//        System.out.println(pif.toString());
//        System.out.println("codification:");
//
//        for (int i=0; i<ls.getEverything().size(); i++)
//            System.out.println(ls.getEverything().get(i)+" -> "+i);
//    }
//
//}
class Solution {
    public int[] luckyNumbers (int[] matrix) {

        int aux=matrix[0];
        for (int i=0;i<matrix.length-1;i++)
        {

            matrix[i]=matrix[i+1];

        }
        matrix[matrix.length-1]=aux;

        return matrix;

    }
}
public class Program{

    public static void main(String[] args) {
        Solution problem = new Solution();
        int[] multiples = new int[6];
        multiples[0]=41205;
        multiples[1]=87385;
        multiples[2]=71957;
        multiples[3]=59605;
        multiples[4]=57152;
        multiples[5]=61601;
        multiples=problem.luckyNumbers(multiples);
        for (int i=0;i<multiples.length;i++)
            System.out.println(multiples[i]);

    }







}
