package org.ajls.lib.advanced;

public class IntegerA {
    int anInt;
    int upperBound = Integer.MAX_VALUE;
    int lowerBound = 0;
    int defaultValue = 0;
    boolean Nan = false;
    public IntegerA() {

    }
    public IntegerA(Integer anInt) {
        if (anInt == null) {
            this.anInt = 0;
            Nan = true;
        }
        this.anInt = anInt;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public Integer increment() {
        if (Nan) {
            return null;
        }
        int returnValue = anInt;
        anInt += 1;
        if (anInt > upperBound) {
            anInt = lowerBound;
        }
        return returnValue;
    }

    public boolean incremented() {
        if (Nan) {
            return false;
        }
        anInt += 1;
        if (anInt > upperBound) {
            anInt = lowerBound;
            return false;
        }
        return true;
    }

    public int getInt() {
        return anInt;
    }
}
