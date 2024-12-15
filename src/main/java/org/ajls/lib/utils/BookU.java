package org.ajls.lib.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class BookU {
    public static ItemStack setPage(ItemStack itemStack, int page, String content) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta instanceof BookMeta) {
            BookMeta bookMeta = (BookMeta) itemMeta;
//            Component component = Component.text(content);
//            bookMeta.page(page, component);
            while (bookMeta.getPageCount() < page) {
                bookMeta.addPage(""); // Add blank pages until the desired page exists
            }
            bookMeta.setPage(page, content);
            itemStack.setItemMeta(bookMeta);
        }
        return itemStack;

    }
}
