package org.goldfrosch.plugin.data;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class GameItem {
    public static ItemStack Liver() {
        ItemStack item = new ItemStack(Material.MUSIC_DISC_PIGSTEP);
        ItemMeta itemMeta = item.getItemMeta();

        List<String> lore = List.of("간의 주인: 토끼");
        assert itemMeta != null;
        itemMeta.setLore(lore);

        item.setItemMeta(itemMeta);
        return item;
    }
}
