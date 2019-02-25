package Model.ADT;
import java.util.*;
public class CDictionary<K,V> implements IDictionary<K,V> {
    private Map<K,V> map;
    public CDictionary(){this.map=new HashMap<>();}

    @Override
    public void add(K key, V value) {
        this.map.put(key,value);
    }

    @Override
    public boolean check(K key) {
        return this.map.containsKey(key);
    }

    @Override
    public V LookUp(K key) {
        return this.map.get(key);
    }

    @Override
    public void update(K key, V value) {
        this.map.put(key,value);
    }

    @Override
    public V get(K key) {
        return this.map.get(key);
    }

    @Override
    public Iterable<K> getAll() {
        return this.map.keySet();
    }

    @Override
    public List<V> getValues() {
        List<V> lista = new ArrayList<>();
        for(Map.Entry<K,V>d:map.entrySet())
        {
            lista.add(d.getValue());
        }
        return lista;
    }

    @Override
    public IDictionary<K, V> copy() {
        IDictionary<K,V> aux = new CDictionary<>();
        for(Map.Entry<K,V>m:this.map.entrySet())
        {
            aux.add(m.getKey(),m.getValue());
        }
        return aux;
    }

    @Override
    public String toString(){
        StringBuffer buff = new StringBuffer();
        for(Map.Entry<K,V>m:map.entrySet())
            buff.append("key:"+m.getKey()+",value:"+m.getValue()+"\n");
        return buff.toString();
    }
}
