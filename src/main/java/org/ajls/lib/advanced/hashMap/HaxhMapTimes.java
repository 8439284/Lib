package org.ajls.lib.advanced.hashMap;

import org.ajls.lib.advanced.HaxhMap;
import org.ajls.lib.references.Time;

import java.util.HashSet;

public class HaxhMapTimes<K> extends HaxhMap<K, TimesD> {
    public int update(K key, int expireTime) {
        HashSet<TimesD> values = getValues(key, true);
        int count = 0;
        HashSet<TimesD> valuesClone = (HashSet<TimesD>) values.clone();
        for (TimesD times : valuesClone) {
            if (times.getTime() <= Time.getTime() - expireTime) {
                count += times.getCount();
//                values.remove(times);
                super.remove(key, times);
            }
        }

        return count;
//        values.removeIf(value -> value.getTime() < Time.getTime() - expireTime);
    }

    public int put(K key) {
        boolean contains = false;
        HashSet<TimesD> values = getValues(key, true);
        for (TimesD times : values) {
            if (times.getTime() == Time.getTime()) {
//                contains = true;
                return times.increment();
//                break;
            }
        }
        super.put(key, new TimesD(Time.getTime(), 1));
        return 0;
        //        return super.put(key, Time.getTime());

    }

    public int updateAndPut(K key, int expireTime) {
        update(key, expireTime);
        return put(key);
    }

    public int count(K key) {
        int count = 0;
        for (TimesD times : getValues(key, true)) {
            count += times.getCount();
        }
        return count;
    }
}
