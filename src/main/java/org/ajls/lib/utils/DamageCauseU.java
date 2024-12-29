package org.ajls.lib.utils;

import org.bukkit.event.entity.EntityDamageEvent;

public class DamageCauseU {
    public static boolean isArmorNotReducible(EntityDamageEvent.DamageCause damageCause) {
        return (damageCause == EntityDamageEvent.DamageCause.FALL ||
                damageCause == EntityDamageEvent.DamageCause.FIRE_TICK ||
                damageCause == EntityDamageEvent.DamageCause.DROWNING ||
                damageCause == EntityDamageEvent.DamageCause.MAGIC ||
                damageCause == EntityDamageEvent.DamageCause.FLY_INTO_WALL ||
                damageCause == EntityDamageEvent.DamageCause.FREEZE ||
//                damageCause == EntityDamageEvent.DamageCause.CUSTOM ||
                damageCause == EntityDamageEvent.DamageCause.SUFFOCATION ||
                damageCause == EntityDamageEvent.DamageCause.SONIC_BOOM ||
                damageCause == EntityDamageEvent.DamageCause.STARVATION ||
                damageCause == EntityDamageEvent.DamageCause.VOID ||
                damageCause == EntityDamageEvent.DamageCause.KILL ||
                damageCause == EntityDamageEvent.DamageCause.WITHER ||
                damageCause == EntityDamageEvent.DamageCause.DRAGON_BREATH ||
                damageCause == EntityDamageEvent.DamageCause.POISON);  // || damageCause == EntityDamageEvent.DamageCause.FIRE
        }
}
