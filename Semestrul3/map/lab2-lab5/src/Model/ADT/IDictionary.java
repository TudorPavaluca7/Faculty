package Model.ADT;
import java.util.*;
public interface IDictionary<K,V> {
    public void add(K key,V value);
    public void update(K key,V value);
    public boolean check(K key);
    public V LookUp(K key);
    public V get(K key);
    public List<V> getValues();
    public Iterable<K> getAll();
}
