package org.ajls.lib.utils;

import java.math.BigDecimal;

public class MathU {
//    public static double round(double value, int places) {
//        if (places < 0) throw new IllegalArgumentException();
//        BigDecimal bd = new BigDecimal(value);
//        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
//        return bd.doubleValue();
//    }

    public static boolean overlaps(double xMin1, double xMax1, double xMin2, double xMax2) {
        return xMin1 <= xMax2 && xMin2 <= xMax1;
    }
    public static boolean overlaps(double xMin1, double yMin1, double zMin1, double xMax1, double yMax1, double zMax1, double xMin2, double yMin2, double zMin2, double xMax2, double yMax2, double zMax2) {
        return overlaps(xMin1, xMax1, xMin2, xMax2) && overlaps(yMin1, yMax1, yMin2, yMax2) && overlaps(zMin1, zMax1, zMin2, zMax2);
    }
}
