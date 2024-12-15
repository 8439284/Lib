package org.ajls.lib.advanced;

import java.util.HashMap;

public class HashMapIntegers<I, K> extends HashMap<I, HashMapInteger<K>> {
    public Integer get(I index, K key) {
        return super.get(index).get(key);
    }
}
