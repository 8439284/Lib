package org.ajls.lib.advanced.hashMap;

import org.ajls.lib.advanced.IntegerA;

public class TimesD {
    int time;
    IntegerA count;
    public TimesD(int time, int count) {
        this.time = time;
        this.count = new IntegerA(count);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCount() {
        return count.getInt();
    }

    public int increment() {
        return count.increment();
    }
}
