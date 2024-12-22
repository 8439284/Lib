package org.ajls.lib.advanced;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HaxhMap<K, V> {
    HashMap<K, HashSet<V>> hashMap;
    public HaxhMap() {
        hashMap = new HashMap<>();
    }

    public boolean put(K key, V value) {
        HashSet<V> hashSet = new HashSet<>();
        if (hashMap.containsKey(key)) {
            hashSet = hashMap.get(key);
        }
        boolean contains = hashSet.add(value);
        hashMap.put(key, hashSet);
        return contains;
    }

    public HashSet<V> getValues(K key) {
        return hashMap.get(key);
    }

    public HashSet<K> getKeys(V value) {
        HashSet<K> keys = new HashSet<>();
        for (K key : hashMap.keySet()) {
            HashSet<V> hashSet = hashMap.get(key);
            if (hashSet.contains(value)) {
                keys.add(key);
            }
        }
        if (keys.isEmpty()) {
            return null;
        }
        return keys;
    }

    public HashSet<V> removeValues(K key) {
        return hashMap.remove(key);
    }

    public HashSet<K> removeKeys(V value) {
        HashSet<K> keys = new HashSet<>();
        for (K key : hashMap.keySet()) {
            HashSet<V> hashSet = hashMap.get(key);
            if (hashSet.contains(value)) {
                keys.add(key);
                hashSet.remove(value);
                if (hashSet.isEmpty()) {
                    hashMap.remove(key);
                }
            }
        }
        if (keys.isEmpty()) {
            return null;
        }
        return keys;
    }

    public Set<K> keySet() {
        return hashMap.keySet();
    }

    public boolean remove(K key, V value) {
        HashSet<V> hashSet = hashMap.get(key);
        boolean removed = hashSet.remove(value);
        if (hashSet.isEmpty()) {
            hashMap.remove(key);
        }
        else {
            hashMap.put(key, hashSet);
        }
        return removed;
    }




}
