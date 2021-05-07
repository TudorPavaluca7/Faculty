package Project;

import javafx.util.Pair;

import java.util.ArrayList;

public class Utils {

public ArrayList<String> SplitLine(String line)
{

    ArrayList<String> st=new ArrayList<>();
    int ok=0;
    line=line.split("=")[1];
    line=line.split("\\{")[1];
    line=line.split("\\}")[0];
    line=line.replaceAll("\\s","");
    String[] elements=line.split(",");
    for (int i=0;i<elements.length;i++) {

        st.add(elements[i]);


    }
    return st;


}
    public ArrayList<Pair<String,String>> splitRules(ArrayList<String> rules)
    {
        ArrayList<Pair<String,String>> result=new ArrayList<>();
        for (String rule:rules)
        {
            String left = rule.split("->")[0];
            String right = rule.split("->")[1];
            ArrayList<String> elems=new ArrayList<>();
            for (String s:right.split("\\|"))
                elems.add(s);
            for (String elem:elems)
                result.add(new Pair<String,String>(left,elem));


        }
        return result;


    }
    public String form(ArrayList<String> s)
    {
        String str = "";
        for (String st:s)
        {
            str += st + ", ";
        }

        return str.substring(0,str.length()-2);

    }

    public  Grammar CreateGrammarFromFa(FiniteAutomata fa,Grammar grammar) throws Exception
    {

        ArrayList<Pair<String,String>> p=new ArrayList<>();
        grammar.setN(fa.getQ());
        grammar.setE(fa.getE());
        grammar.setS(fa.getQ0());

        if (fa.getF().contains(fa.getQ0().substring(1)))
        {
            p.add(new Pair<String, String>(fa.getQ0(), "E"));
        }

        for (Pair<Pair<String, String>, String> transition : fa.getT())
        {
            Pair<String, String> lhs = transition.getKey();
            String state2 = transition.getValue();
            String state1 = lhs.getKey();
            String route = lhs.getValue();

            p.add(new Pair<String, String>(state1, route + state2));

            if (fa.getF().contains(state2))
            {
                p.add(new Pair<String, String>(state1, route));
            }
        }

        grammar.setP(p);

        return grammar;

    }

    public FiniteAutomata CreateFaFromGrammar(FiniteAutomata fa,Grammar grammar)
    {
        if (!grammar.isRegular())
        {
            System.out.println("Is not regular");
            return null;
        }
        ArrayList<String> n=new ArrayList<>();
        ArrayList<String> F= new ArrayList<>();
        ArrayList<Pair<Pair<String, String>, String>> T=new ArrayList<>();
        for (String s:grammar.getN())
            n.add(s);
        n.add("K");
        fa.setQ(n);
        fa.setE(grammar.getE());
        fa.setQ0(grammar.getS());
        F.add("K");

        for(Pair<String,String> production:grammar.getP())
        {
            String state2 = "K";
            String state1=production.getKey();
            String rhs=production.getValue();
            if (state1.equals(fa.getQ0().substring(1)) && rhs.charAt(0)=='E')
            {
                F.add(fa.getQ0());
                continue;
            }
            String route=String.valueOf(rhs.charAt(0));
            if (rhs.length()==2)
                state2 = String.valueOf(rhs.charAt(1));
            T.add(new Pair<Pair<String, String>, String>(new Pair<String,String>(state1,route),state2));
        }
        fa.setF(F);
        fa.setT(T);
        return fa;



    }



}
