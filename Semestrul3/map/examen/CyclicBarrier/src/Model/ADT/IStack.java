package Model.ADT;

public interface IStack<E> {
    public void push(E elem);
    public E pop();
    public boolean isEmpty();
    public Iterable<E> getAll();
}
