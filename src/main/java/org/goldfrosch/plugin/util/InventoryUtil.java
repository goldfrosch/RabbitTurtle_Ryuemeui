package org.goldfrosch.plugin.util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryUtil {
    public static boolean hasItemInInventory(Player player, ItemStack itemStack) {
        ItemStack[] inventoryContents = player.getInventory().getContents();
        for (ItemStack item : inventoryContents) {
            if (item != null && item.isSimilar(itemStack)) {
                return true;
            }
        }
        return false;
    }
}
