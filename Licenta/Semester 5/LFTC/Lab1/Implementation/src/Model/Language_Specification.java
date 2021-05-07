package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Language_Specification {
    private  ArrayList<String> separators;
    private  ArrayList<String> operators;
    private  ArrayList<String> reservedWords;
    private  ArrayList<String> everything ;

    public Language_Specification() {
        this.separators = new ArrayList<String> (Arrays.asList("[", "]", "{", "}", "(", ")", ";", " ", ","));
        this.operators =  new ArrayList<String> (Arrays.asList("+", "-", "*", "/", "<", "<=", "=", ">=", ">", "==", "&&", "||", "!", "!=", "++", "--"));
        this.reservedWords = new ArrayList<String> (Arrays.asList("array", "char", "else", "if", "int", "read", "while", "write", "float", "string", "return", "VAR"));
        this.everything=new ArrayList<>();
        this.codification();
    }


    public ArrayList<String> getSeparators() {
        return separators;
    }

    public ArrayList<String> getOperators() {
        return operators;
    }

    public ArrayList<String> getReservedWords() {
        return reservedWords;
    }

    public ArrayList<String> getEverything() {

        return everything;
    }





    public void codification()
    {
        everything.add("identifier");
        everything.add("constant");
        everything.addAll(separators);
        everything.addAll(operators);
        everything.addAll(reservedWords);

    }

}
