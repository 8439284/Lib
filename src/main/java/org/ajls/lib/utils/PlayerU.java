package org.ajls.lib.utils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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

    public static boolean isPlayerSameTeam(Player player1, Player player2) {
        String teamName1 = ScoreboardU.getPlayerTeamName(player1);
        String teamName2 = ScoreboardU.getPlayerTeamName(player2);
//        String teamName1 = getPlayerTeam(player1).getName();
//        String teamName2 = getPlayerTeam(player2).getName();
        if (player1 == player2) return true;
        if (teamName1 == null || teamName2 == null) return false;
        return teamName1.equals(teamName2);
    }

    public static boolean isPlayerSpectator(Player player) {
        return player.getGameMode().equals(GameMode.SPECTATOR);
    }

    public static boolean isPlayerDead(Player player) {
        return player.isDead();
    }

    public static boolean isPlayerUnplayable(Player player) {
        return isPlayerSpectator(player) || isPlayerDead(player);
    }

    public static boolean isPlayerPlayable(Player player) {
        return !isPlayerUnplayable(player);
    }

    public static boolean isPlayerPlayableEnemy(Player player1, Player player2) {
        return !isPlayerUnplayable(player1) && !isPlayerUnplayable(player2) && !isPlayerSameTeam(player1, player2);
    }

    public static boolean isPlayer2PlayableEnemy(Player player1, Player player2) {
        return !isPlayerUnplayable(player2) && !isPlayerSameTeam(player1, player2);
    }

    public static boolean isPlayerAttackableEnemy(Player player1, Player player2) {
        boolean result;
        result = !isPlayerSameTeam(player1, player2); //enemy
        if (!result) { //sameteam
            result = ScoreboardU.getPlayerTeam(player1).allowFriendlyFire();
        }
        return result;
    }

}
