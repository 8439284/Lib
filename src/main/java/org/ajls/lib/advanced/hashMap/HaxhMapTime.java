package org.ajls.lib.advanced.hashMap;

import org.ajls.lib.advanced.HaxhMap;
import org.ajls.lib.references.Time;

import java.util.HashSet;

public class HaxhMapTime<K> extends HaxhMap<K, Integer> {
    public void update(K key, int expireTime) {
        HashSet<Integer> values = getValues(key);
//        for (Integer value : values) {
//            if (value < Time.getTime() - expireTime) {
//                values.remove(value);
//            }
//        }
        values.removeIf(value -> value < Time.getTime() - expireTime);
    }

    public boolean put(K key) {
        return super.put(key, Time.getTime());
    }
}
