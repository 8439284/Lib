package org.ajls.lib.advanced.hashMap;

import java.util.HashMap;
import java.util.Objects;

public class HashMapDouble<K> extends HashMap<K, Double> {
    Double defaultValue = 0.0;

    @Override
    public Double get(Object key) {
        if (!super.containsKey(key)) { return defaultValue; }
        return super.get(key);
    }

    @Override
    public boolean containsKey(Object key) {
        Double value = get(key);
        return value != null;
    }

//    @Override
//    public Double remove(Object key) {
//        if
//        Double value = super.remove(key);
//
//    }

    @Override
    public Double put(K key, Double value) {
        if (Objects.equals(value, defaultValue)) {
            if (!super.containsKey(key)) { //avoid put return null
                return defaultValue;
            }
            return super.remove(key);
        }
        else {
            if (!super.containsKey(key)) { //avoid put return null
                super.put(key, value);
                return defaultValue;
            }
            return super.put(key, value);
        }
    }

    public Double getDiffAndPut(K key, Double value) {
        Double oldValue = put(key, value);
        if (oldValue == null) return null;
        return value - oldValue;
    }

}
