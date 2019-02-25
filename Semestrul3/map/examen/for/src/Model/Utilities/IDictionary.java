package Model.Utilities;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IDictionary<K,V> {
    void setValue(K key, V value);
    Map<K,V> getMap();
    void delete(K key);
    V getValue(K key);
    void clear();
    void setMap(Map<K,V> m);
    List<V> getValues();
    List<K> getKeys();
    boolean exists(K key);
    Iterable<K> getElements();
    IDictionary<K, V> copy();
}
