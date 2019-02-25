using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7.Model.ADT
{
    public class DictionaryC<K, V> : IDictionary<K, V>
    {
        private Dictionary<K, V> dict = new Dictionary<K, V>();

        public DictionaryC()
        {
            this.dict = new Dictionary<K, V>();
        }

        public void AddValue(K key, V value)
        {
            this.dict.Add(key, value);
        }
        public bool exists(K key)
        {
            return dict.ContainsKey(key);
        }

        public V getValue(K key)
        {
            return dict[key];
        }


        public void setValue(K key, V value)
        {
            dict[key] = value;
        }

        public void updateValue(K key, V value)
        {
            dict[key] = value;
        }


        public IEnumerator GetEnumerator()
        {
            return dict.GetEnumerator();
        }
        public override string ToString()
        {
            StringBuilder buff = new StringBuilder();
            foreach (KeyValuePair<K, V> pair in this.dict)
            {
                buff.Append(pair.Key);
                buff.Append("->");
                buff.Append(pair.Value);
                buff.Append("\n");
            }
            buff.Append("\n");
            return buff.ToString();
        }

    }
}
