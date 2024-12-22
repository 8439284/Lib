package org.ajls.lib.advanced;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackA extends ItemStack {
    public ItemStackA addLore(String lore) {
        ItemMeta meta = getItemMeta();
        List<String> loresList = new ArrayList<>();
        if (meta.getLore() != null) {
            loresList = meta.getLore();
        }
        loresList.add(lore);
        meta.setLore(loresList);
        setItemMeta(meta);
        return this;
    }
}
