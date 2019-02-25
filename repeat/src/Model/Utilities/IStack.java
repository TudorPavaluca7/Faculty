package Model.Utilities;

import java.util.List;

public interface IStack<T> {
    void add(T x);
    Iterable<T> getElements();
    boolean isEmpty();
    public List<T> getToList();
    T top();
    T pop();
}
