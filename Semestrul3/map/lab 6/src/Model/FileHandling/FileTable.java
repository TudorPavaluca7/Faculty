package Model.FileHandling;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class FileTable<K,V> implements IFileTable<K,V> {
    private Map<K,V> dict;

    public FileTable()
    {
        this.dict=new HashMap<>();
    }
    @Override
    public void add(K key,V val)
    {
        this.dict.put(key,val);
    }
    @Override
    public void remove(K key)
    {
        this.dict.remove(key);
    }
    @Override
    public boolean contains(K key)
    {
        return this.dict.containsKey(key);
    }
    @Override
    public V get(K key)
    {
        return this.dict.get(key);
    }

    @Override
    public Iterable<K> getAll() {
        return this.dict.keySet();
    }

    @Override
    public Iterable<V> getValues() {
        return this.dict.values();
    }

    @Override
    public Collection<V> GetAllValues() {
        return this.dict.values();
    }

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        for(Map.Entry<K,V>m:dict.entrySet())
            buff.append("key:"+m.getKey()+",filename:"+m.getValue()+"\n");
        return buff.toString();
    }
}
