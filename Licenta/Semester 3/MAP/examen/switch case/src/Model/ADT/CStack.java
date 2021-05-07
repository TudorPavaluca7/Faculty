package Model.ADT;
import java.util.Stack;

public class CStack<E> implements IStack<E> {
    private Stack<E> stack;
    public CStack(){stack=new Stack<>();}
    @Override
    public void push(E elem) {
        this.stack.push(elem);
    }

    @Override
    public E pop() {
        return this.stack.pop();
    }

    @Override
    public boolean isEmpty() {
        if(this.stack.size()==0)
            return true;
        return false;
    }

    @Override
    public Iterable<E> getAll() {
        return this.stack;
    }

    @Override
    public String toString()
    {
        StringBuffer buff=new StringBuffer();
        for(E s:this.stack)
        {

            buff.append(s).append(" ");
        }
        //buff.append("\n");
        return buff.toString();
    }

}
