package org.ajls.lib.utils;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class BlockU {
    public static boolean isAdjacent(Location location1, Location location2) {
        if (location1 == null || location2 == null) return false;
        double x1 = location1.getX();
        double y1 = location1.getY();
        double z1 = location1.getZ();
        double x2 = location2.getX();
        double y2 = location2.getY();
        double z2 = location2.getZ();
        boolean isAdjacent;
        if (x1 == x2) {
            if (y1 == y2) {
                if (z1 + 1 == z2) return true;
                if (z1 - 1 == z2) return true;
            }
            else if (y1 + 1 == y2 || y1 - 1 == y2) {
                if (z1 == z2) return true;
            }
        }
        else if (x1 + 1 == x2 || x1 - 1 == x2) {
            if (y1 == y2) {
                if (z1 == z2) return true;
            }
        }
        return false;
    }

    public static boolean isAdjacent(Block block1, Block block2) {
        if (block1 == null || block2 == null) return false;
        return isAdjacent(block1.getLocation(), block2.getLocation());
    }
}
