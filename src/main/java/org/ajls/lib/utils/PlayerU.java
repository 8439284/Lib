package org.ajls.lib.utils;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class PlayerU {
    public static int getPlayerEPF(Player player) {
//        player.getInventory().getArmorContents();
        EntityEquipment entityEquipment = player.getEquipment();
        ItemStack helmet = entityEquipment.getHelmet();
        ItemStack chestplate = entityEquipment.getChestplate();
        ItemStack leggings = entityEquipment.getLeggings();
        ItemStack boots = entityEquipment.getBoots();
        ItemStack[] equipments = {helmet, chestplate, leggings, boots};
        int EPF = 0;
        for (int i = 0; i < equipments.length; i++) {
            ItemStack equipment = equipments[i];
            if (equipment == null) continue;
            EPF += ItemStackU.getEnchantmentLevel(equipment, Enchantment.PROTECTION);
        }
//        EPF *= 4;
        return EPF;
    }

    public static void addHealth(LivingEntity entity, double health) {
        double absorptionPlayer = entity.getAbsorptionAmount();
        double healthPlayer = entity.getHealth();
        if (health < 0 ) {  //damage
            Bukkit.getServer().getPluginManager().callEvent(new EntityDamageEvent(entity, EntityDamageEvent.DamageCause.CUSTOM, -health));
            if (absorptionPlayer >= -health) { // absorption able to absorb damage
                absorptionPlayer += health;
                health = 0;
            }
            else {  // absorption not able to absorb damage
                health += absorptionPlayer; // damage remove absorption amount
                absorptionPlayer = 0;
//                healthPlayer += health; // damage to player's health
            }
        }
        entity.setAbsorptionAmount(absorptionPlayer);
        healthPlayer += health;  // damage to player's health
//        else { // healing
//            healthPlayer += health;
//        }
//        healthPlayer = healthPlayer + health;
        if (0 < healthPlayer && healthPlayer < entity.getMaxHealth()) {
            entity.setHealth(healthPlayer);
//            EntityRegainHealthEvent entityRegainHealthEvent = new EntityRegainHealthEvent(entity, health, EntityRegainHealthEvent.RegainReason.CUSTOM);
//            Bukkit.getServer().getPluginManager().callEvent(entityRegainHealthEvent);
        }
        else if (healthPlayer <= 0) {
            if (entity instanceof Player) {
                Player player = (Player) entity;
//                playerDeathEvent(player);
            }
            else {
                entity.setHealth(0);
            }
        }
        else {
            entity.setHealth(entity.getMaxHealth());
        }
    }
}
