package org.ajls.lib.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlugManU {
    public static void reload(String pluginName, CommandSender sender) {
        CommandU.runCommand(sender, "plugman reload " + pluginName);
    }
}
