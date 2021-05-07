package Model.ADT;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class BarrierTable<K,V> implements IBarrierTable<K,V> {
    private Map<K,V> bt;
    public  BarrierTable()
    {
        this.bt=new HashMap<>();
    }
    @Override
    public void add(K key, V val) {
        this.bt.put(key,val);
    }

    @Override
    public boolean contains(K key) {
        return this.bt.containsKey(key);
    }

    @Override
    public V get(K key) {
        return this.bt.get(key);
    }

    @Override
    public Iterable<K> getAll() {
        return this.bt.keySet();
    }

    @Override
    public Iterable<V> getValues() {
        return this.bt.values();
    }

    @Override
    public void update(K key, V val) {
        this.bt.put(key,val);
    }

    @Override
    public void setContent(Map<K, V> m) {
        this.bt=m;
    }
    public Set<Map.Entry<K, V>> entrySet() {
        return bt.entrySet();
    }
    @Override
    public String toString()
    {
        StringBuffer buff = new StringBuffer();
        for(Map.Entry<K,V> h:this.bt.entrySet())
        {
            buff.append("key:"+h.getKey()+",value:"+h.getValue()+"\n");
        }
        buff.append("\n");
        return buff.toString();
    }
    @Override
    public Map<K,V> getMap(){return this.bt;}

}
