package org.goldfrosch.plugin.util;

import org.bukkit.entity.Player;
import org.goldfrosch.plugin.constants.UserRank;
import org.goldfrosch.plugin.data.GameItem;

import static org.goldfrosch.plugin.constants.GlobalVariable.userRankMap;

public class PlayLogicUtil {
    public static boolean checkPlayerIsRabbit(Player player) {
        return UserRank.RABBIT.equals(userRankMap.get(player.getUniqueId()));
    }
    public static boolean checkRabbitHasLiver(Player player) {
        if (checkPlayerIsRabbit(player)) {
            return InventoryUtil.hasItemInInventory(player, GameItem.Liver());
        }
        // 없을 경우에 대한 로직이기에 다른 타입은 모두 간이 있는 true 로 반환시켜버림.
        return true;
    }

    public static void dropRabbitLiver(Player player) {
        player.getInventory().remove(GameItem.Liver());
        player.getWorld().dropItem(player.getLocation(), GameItem.Liver());
    }
    public static void giveRabbitLiver(Player player) {
        if (checkPlayerIsRabbit(player)) {
            player.getInventory().addItem(GameItem.Liver());
        }
    }
}
