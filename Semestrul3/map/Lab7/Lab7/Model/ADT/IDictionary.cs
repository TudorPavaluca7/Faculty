using System;
using System.Collections;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7.Model.ADT
{
    public interface IDictionary<K, V> : IEnumerable
    {
        void AddValue(K key, V value);
        bool exists(K key);
        V getValue(K key);
        void setValue(K key, V value);
        void updateValue(K key, V value);
    }
}
