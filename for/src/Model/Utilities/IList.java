package Model.Utilities;

import java.util.List;

public interface IList<T> {
    void add(T x);

    Iterable<T> getElements();
    List<T> getElementsL();

    void remove(T x);
}
