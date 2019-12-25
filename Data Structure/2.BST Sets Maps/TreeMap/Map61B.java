package Sets_Maps_BST;

import java.util.Iterator;
import java.util.Set;

public interface Map61B<K, V> extends Iterable<K> {
    // Removes all of the mappings from the map.
    void clear();

    // Returns true if this map contains mapping for the specified key.
    boolean containsKey(K key);

    // Returns the value to which the specified key is mapped,
    // or null if this map contains no mapping for the key.
    V get(K key);

    // Returns the number of key-value mappings in this map.
    int size();

    // Associates the specified value with specified key in this map.
    void put(K key, V value);

    // Returns a set view of the keys contained in this map.
    Set<K> keySet();

    // Removes the mapping for the specified key from this map if present.
    V remove(K key);

    // Removes the entry for the specified key only if it is currently mapped to
    // the specified value.
    V remove(K key, V value);

    // Returns an iterator.
    Iterator<K> iterator();

}
