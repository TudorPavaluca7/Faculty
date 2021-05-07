package Project;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FiniteAutomata {

    private ArrayList<String> Q = new ArrayList<>();
    private ArrayList<String> E = new ArrayList<>();
    private String q0;
    private Utils utils = new Utils();
    private ArrayList<String> F= new ArrayList<>();
    ArrayList<Pair<Pair<String,String>,String>> T = new ArrayList<>();
    private String path;

    public FiniteAutomata(String path) throws Exception
    {
        this.path=path;
        ReadFromFile();
    }


    public void ReadFromFile() throws Exception {

        File file = new File(path);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String stringBuilder = "";
        String st;
        int count = 0;
        while ((st = br.readLine()) != null)
        {
            switch(count){

                case 0:
                    Q=utils.SplitLine(st);
                    break;
                case 1:
                    E=utils.SplitLine(st);
                    break;
                case 2:
                    String ss[]=st.split("=");
                    this.q0=ss[1];
                    break;
                case 3:
                    F=utils.SplitLine(st);
                    break;
                default:
                    stringBuilder=stringBuilder+st;
                    break;
            }
            count++;

        }
        ArrayList<String> al=new ArrayList<>();
        String core = stringBuilder.replaceAll(" ","");
        core=core.split("\\{")[1];
        core=core.split("\\}")[0];
        String[] elems=core.split("");
        core="";
        for (String s:elems)
            if (s.equals("\t")==false)
                core=core+s;
         String[] elements = core.split(",");
        for (String s : elements) {

            al.add(s);
        }
        T=splitTransations(al);
    }

    public ArrayList<Pair<Pair<String,String>,String>> splitTransations(ArrayList<String> rules)
    {
        ArrayList<Pair<Pair<String,String>,String>> result=new ArrayList<>();
        ArrayList<String> transitions= new ArrayList<>();
        int index = 0;

        while (index < rules.size())
        {
            transitions.add(rules.get(index) + "," + rules.get(index + 1));
            index += 2;
        }

        for (String transition:transitions)
        {
            String lhs = transition.split("->")[0];
            lhs = lhs.substring(1, lhs.length()-1);
            String rhs = transition.split("->")[1];


            String state2 = rhs;
            String state1 = lhs.split(",")[0];
            String route = lhs.split(",")[1];

            result.add(new Pair<Pair<String, String>, String>(new Pair<String,String>(state1,route),state2));

        }
        return result;


    }

     public String form( ArrayList<Pair<Pair<String,String>,String>> result)
     {

         String str = "";
         for (Pair<Pair<String,String>,String> st:result)
         {
             str += "(" + st.getKey().getKey() + ", " + st.getKey().getValue() + ") ->" + st.getValue() +", ";
         }

         return str.substring(0,str.length()-2);
     }

     public ArrayList<Pair<Pair<String,String>,String>> getTransitions(String state)
     {
         ArrayList<Pair<Pair<String,String>,String>> result=new ArrayList<>();


         for (Pair<Pair<String,String>,String> t:T) {

             if (t.getKey().getKey().equals(state))
                 result.add(t);
         }
         return result;

     }

    public ArrayList<String> getQ() {
        return Q;
    }

    public ArrayList<String> getE() {
        return E;
    }

    public String getQ0() {
        return q0;
    }

    public ArrayList<String> getF() {
        return F;
    }

    public ArrayList<Pair<Pair<String, String>, String>> getT() {
        return T;
    }

    @Override
    public String toString() {
        return "N = { " + utils.form(Q) + " }\nE = { " + utils.form(E) + " }\nq0 =" + q0 + "\nF = { "+utils.form(F)+ " }\nT= { "+form(T)+ "}\n";
    }

    public void setQ(ArrayList<String> q) {
        Q = q;
    }

    public void setE(ArrayList<String> e) {
        E = e;
    }

    public void setQ0(String q0) {
        this.q0 = q0;
    }

    public void setF(ArrayList<String> f) {
        F = f;
    }

    public void setT(ArrayList<Pair<Pair<String, String>, String>> t) {
        T = t;
    }
}
