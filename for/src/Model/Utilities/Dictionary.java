package Model.Utilities;

import java.util.*;
import java.util.stream.Collectors;

import Exception.*;

public class Dictionary<K,V> implements IDictionary<K,V> {
    private Map<K,V> elements = new HashMap<>();

    @Override
    public void setValue(K key, V value){
        elements.put(key,value);
    }
    public void delete(K key){
        elements.remove(key);
    }
    public V getValue(K key){
        if(!exists(key))
            throw new VariableNotDefined("Variable is missing!");
        return elements.get(key);
    }
    public void clear(){
        this.elements.clear();
    }
    public List<V> getValues(){
        List<V> lst=new ArrayList<>();
        for(K key : this.getElements()){
            lst.add(this.getValue(key));
        }
        return lst;
    }
    public void setMap(Map<K,V> m){elements=m;}
    public boolean exists(K key){
        return elements.containsKey(key);
    }
    public Iterable<K> getElements(){
        return elements.keySet();
    }
    public List<K> getKeys(){
        List<K> l=new ArrayList<K>();
        for(K k:getElements()){
            l.add(k);
        }
        return l;
    }
    public Map<K,V> getMap(){return this.elements;}

    public IDictionary<K,V> copy(){
        IDictionary<K,V> t=new Dictionary<K,V>();
        for(Map.Entry<K,V> e : elements.entrySet()){
            t.setValue(e.getKey(),e.getValue());
        }
        return t;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<K,V> e : elements.entrySet()){
            sb.append("<").append(e.getKey()).append(", ").append(e.getValue()).append(">; ");
        }
        return sb.toString();
    }
}
