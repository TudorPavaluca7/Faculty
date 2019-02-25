package Model.ADT;
import java.util.*;
public interface IHeap<K,V> {

    public void add(K key,V val);
    public boolean contains(K key);
    public  V get(K key);
    public void update(K key,V val);
    public Iterable<K> getAll();
    public Iterable<V> getValues();
    public void setContent(Map<K,V> m);
    public Map<K,V> getMap();
    public Set<Map.Entry<K, V>> entrySet();
}
