package Model;

import java.util.ArrayList;

public class Scanner {
    private Language_Specification ls;
    private String token;
    private int index;

    public Scanner(Language_Specification ls) {

        this.ls=ls;
    }

    public boolean isOperator(String st) {
        for (String s : ls.getOperators())
            if (s.equals(st))
                return true;
        return false;

    }


    public boolean isSeparator(String st) {
        for (String s : ls.getSeparators())
            if (s.equals(st))
                return true;
        return false;

    }

    public void operatorToken(String[] line) {
        String token2 = "";
        while (index < line.length && isOperator(line[index])) {
            token2 += line[index];
            index += 1;
        }
        token = token + token2;


    }
    public void getString(String[] line)
    {
        String token2="";
        int quoteCount=0;
        while (index < line.length && quoteCount<2) {
            if (line[index]=="\"")
                quoteCount++;
            token2 += line[index];
            index += 1;
        }
        token = token + token2;


    }

    public ArrayList<String> Generator(String line) {
        this.index = 0;
        this.token = "";
        ArrayList<String> tokens = new ArrayList<>();
        String[] arrOfStr = line.split("");
        while (this.index < line.length()) {
            if (arrOfStr[index]=="\"")
            {
                if (token.equals("") == false)
                    tokens.add(token);
                getString(arrOfStr);
                tokens.add(token);
                token="";
            }
            else
                if (isOperator(arrOfStr[index])) {
                if (token.equals("") == false)
                    tokens.add(token);
                operatorToken(arrOfStr);
                tokens.add(token);
                token = "";
            } else if (isSeparator(arrOfStr[index]) ) {
                if (token.equals("") == false)
                    tokens.add(token);
                token = arrOfStr[index];
                index += 1;
                if (token.equals(" ")==false)
                    tokens.add(token);
                token = "";

            } else {
                token += arrOfStr[index];
                index += 1;
            }
        }
        if (token.equals("") == false)
            tokens.add(token);
        return tokens;

    }

}








