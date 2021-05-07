package Model;

import javafx.util.Pair;

import java.util.ArrayList;

public class PIF {

    private ArrayList<Pair<Integer,Integer>> pif = new ArrayList<Pair<Integer,Integer>>();

    public void add(int code,int id)
    {

       this.pif.add(new Pair<Integer, Integer>(code, id));

    }

    @Override
    public String toString() {
        StringBuilder ss = new StringBuilder();
        for (Pair<Integer,Integer> p : this.pif)
            ss.append(p.getKey()+","+p.getValue()+" ");
        return ss.toString();
    }
}
