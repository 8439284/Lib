package org.ajls.lib.advanced;

public class HashMapMenu<K> extends HashMapInteger<K> {
    @Override
    public int increment(K key, int bound) {
        Integer value = get(key);
        if (value >= bound) {
            remove(key);
        }
        return increment(key);
    }
}
