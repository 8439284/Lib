package org.ajls.lib.overhaul;

import org.ajls.lib.advanced.HashMapInteger;
import org.ajls.lib.advanced.hashMap.HashMapDouble;
import org.ajls.lib.advanced.hashMap.HaxhMapTimes;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.UUID;

public class CombatO implements Listener {
    static HashMapInteger<UUID> player_lastAttackedTimeStamp = new HashMapInteger<>();
//    static HashMapDouble<UUID>
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onEntityDamagedByEntity(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        UUID entityUUID = entity.getUniqueId();
        double finalDamage = event.getFinalDamage();
//        player_lastAttackedTimeStamp.putMaxTime(entityUUID, 10);
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            if (!player_lastAttackedTimeStamp.biggerOrEqualToTime(entityUUID)) {
                player_lastAttackedTimeStamp.putMaxTime(entityUUID, 10);
                livingEntity.setMaximumNoDamageTicks(1);
            }
            else {
 //               event.setCancelled(true); // damage by the difference value but not cause knockback by resetting the MaxNoDamageTick or just use addhealth(remember to consider absorptions
//                livingEntity.setNoDamageTicks(0);
                if (finalDamage - livingEntity.getLastDamage() > 0) {
//                    event.setFinalDamage(finalDamage - livingEntity.getLastDamage());
                }
            }
        }

    }

}
