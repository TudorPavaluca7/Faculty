package Project;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Grammar {

    private ArrayList<String> N = new ArrayList<>();
    private ArrayList<String> E = new ArrayList<>();
    private ArrayList<Pair<String, String>> P = new ArrayList<>();
    private String S;
    private Utils utils = new Utils();
    private String path;

    public Grammar(String path) throws Exception {
        this.path = path;
        ReadFromFile();


    }

    public void setN(ArrayList<String> n) {
        N = n;
    }

    public void setE(ArrayList<String> e) {
        E = e;
    }

    public void setP(ArrayList<Pair<String, String>> p) {
        P = p;
    }

    public void setS(String s) {
        S = s;
    }

    public void ReadFromFile() throws Exception {

        File file = new File(path);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String stringBuilder = "";
        String st;
        int count = 0;
        while ((st = br.readLine()) != null) {
            switch (count) {

                case 0:
                    N = utils.SplitLine(st);
                    break;
                case 1:
                    E = utils.SplitLine(st);
                    break;
                case 2:
                    String ss[] = st.split("=");
                    this.S = ss[1];
                    break;
                default:
                    stringBuilder = stringBuilder + st;
                    break;
            }
            count++;


        }

        ArrayList<String> al = new ArrayList<>();
        String core = stringBuilder.replaceAll(" ", "");
        core = core.split("\\{")[1];
        core = core.split("\\}")[0];
        String[] elems = core.split("");
        core = "";
        for (String s : elems)
            if (s.equals("\t") == false)
                core = core + s;
        for (String s : core.split(","))
            al.add(s);
        for (String s : al)
            P = utils.splitRules(al);
    }


    public String form2(ArrayList<Pair<String, String>> s) {
        String str = "";
        for (Pair<String, String> st : s) {
            str += st.getKey() + "->" + st.getValue() + ", ";
        }

        return str.substring(0, str.length() - 2);

    }

    public ArrayList<Pair<String, String>> getProduction(String nonTerminal) {
        ArrayList<Pair<String, String>> result = new ArrayList<>();

        for (Pair<String, String> p : P) {
            String a = p.getKey();
            String b = nonTerminal;

            if (a.equals(b))
                result.add(p);
        }
        return result;
    }


    public ArrayList<String> getN() {
        return N;
    }

    @Override
    public String toString() {
        return "N = { " + utils.form(N) + " }\nE = { " + utils.form(E) + " }\nP = {" + form2(P) + "}\nS =" + S + "\n";
    }

    public ArrayList<String> getE() {
        return E;
    }

    public ArrayList<Pair<String, String>> getP() {
        return P;
    }

    public String getS() {
        return S;
    }

    public boolean isRegular() {
        Map<String, Boolean> dict = new HashMap<>();
        ArrayList<String> notAllowed = new ArrayList<>();

        for (Pair<String, String> rule : P) {
            String left = rule.getKey();
            String right = rule.getValue();
            boolean hasTerminal = false;
            boolean hasNonTerminal = false;
            if (right.length() > 2)
                return false;
            String[] elems = right.split("");
            for (String s : elems) {
                if (N.contains(s)) {
                    if (!dict.containsKey(s))
                        dict.put(s, true);
                    hasNonTerminal = true;
                } else if (E.contains(s)) {
                    if (hasNonTerminal)
                        return false;

                    hasTerminal = true;
                }
                if (s.equals("E"))
                    notAllowed.add(left);
            }
            if (hasNonTerminal && !hasTerminal) {
                return false;
            }
        }
            for (String s : notAllowed) {
                System.out.print(s);
                if (dict.containsKey(s))
                    return false;
            }
            return true;





    }
}
