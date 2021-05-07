package Model.ADT;

import java.util.List;

public interface IDictionary<K,V> {
    public void add(K key, V value);
    public void update(K key, V value);
    public boolean check(K key);
    public V LookUp(K key);
    public V get(K key);
    public IDictionary<K,V> copy();
    public List<V> getValues();
    public Iterable<K> getAll();
}
