package Model.ADT;
import java.util.ArrayList;
import java.util.List;
public class CList<E> implements IList<E> {
    private List<E> list;
    public CList(){this.list=new ArrayList<>(); }

    @Override
    public void Add(E elem) {
        this.list.add(elem);
    }

    @Override
    public Iterable<E> getAll() {
        return this.list;
    }

    @Override
    public String toString()
    {
        StringBuffer buff = new StringBuffer();
        for(E i:this.list)
        {
            buff.append(i+"\n");

        }
        return buff.toString();
    }

}

