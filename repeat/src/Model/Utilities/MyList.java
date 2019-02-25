package Model.Utilities;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> implements IList<T> {
    private List<T> elements=new ArrayList<T>();

    @Override
    public void add(T e){
        elements.add(e);
    }
    public Iterable<T> getElements(){
        return elements;
    }
    public List<T> getElementsL(){
        return elements;
    }
    public void remove(T e){
        elements.remove(e);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(T i : elements){
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}
