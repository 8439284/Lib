package org.ajls.lib.advanced;

import java.util.HashMap;
import java.util.Objects;

public class HashMapInteger<K> extends HashMap<K, Integer> {
    int upperBound = Integer.MAX_VALUE;
    int lowerBound = 0;
    Integer defaultValue = 0;
    public HashMapInteger() {
        this.upperBound = Integer.MAX_VALUE;
    }
    public HashMapInteger(int upperBound) {
        this.upperBound = upperBound;
        this.lowerBound = 0;
    }
    public HashMapInteger(int upperBound, int lowerBound) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }
    public HashMapInteger(int upperBound, int lowerBound, Integer defaultValue) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean containsKey(Object key) {
//        if (!super.containsKey(key)) { return true; }
//        else {
//            if ()
//        }
//        return super.containsKey(key);
        Integer value = get(key);
        return value != null;
    }
    @Override
    public Integer get(Object key) {
        if (!super.containsKey(key)) { return defaultValue; }
        return super.get(key);
//        Integer value = super.get(key);
//        if (value == null) {
//            return 0;
//        }
//        return value;
    }



    @Override
    public Integer put(K key, Integer value) {
        if (Objects.equals(value, defaultValue)) {
            return super.remove(key);
        }
        else {
            return super.put(key, value);
        }
    }

    @Override
    public Integer remove(Object key) {
        return put((K) key, null);
    }

    public int increment(K key) {
        Integer value = get(key);
//        if (value >= upperBound) {
//            put(key, lowerBound);
////            return lowerBound;
//        }
        put(key, get(key) + 1);
        return value;
    }

    public int increment(K key, int max) {
        Integer value = get(key);
        if (value < max) {
            return increment(key);
        }
        return value;
    }

    public int decrement(K key) {
        Integer value = get(key);
//        if (value <= lowerBound) {
//            put(key, upperBound);
////            return upperBound;
//        }
        put(key, value-1);
        return value;
    }

    public int pageUp(K key) {
        Integer value = get(key);
        if (value >= upperBound) {
            put(key, lowerBound);
            return upperBound;
        }
        return increment(key);
    }

    public int getUpperBound() {
        return upperBound;
    }
}
