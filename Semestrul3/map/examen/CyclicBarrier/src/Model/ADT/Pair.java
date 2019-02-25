package Model.ADT;

import java.util.ArrayList;

public class Pair {
    private Integer number;
    private ArrayList<Integer> lista;
    public Pair(Integer number,ArrayList<Integer> lista)
    {
        this.number=number;
        this.lista=lista;
    }
    public ArrayList<Integer> getList()
    {return this.lista;}
    public Integer getNumber()
    {return this.number;}

    @Override
    public String toString() {
        return " "+this.getNumber()+this.getList();
    }
}
