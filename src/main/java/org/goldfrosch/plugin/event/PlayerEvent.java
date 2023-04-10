package org.goldfrosch.plugin.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.goldfrosch.plugin.constants.UserRank;
import org.goldfrosch.plugin.util.BossBarUtil;
import org.goldfrosch.plugin.util.PlayLogicUtil;

import java.util.Optional;

import static org.goldfrosch.plugin.constants.GlobalVariable.userRankMap;

public class PlayerEvent implements Listener {
    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player player && event.getDamager() instanceof Player damager) {
            Optional<UserRank> userRank = Optional.ofNullable(userRankMap.get(player.getUniqueId()));
            Optional<UserRank> damagerRank = Optional.ofNullable(userRankMap.get(damager.getUniqueId()));
            if (userRank.isPresent() && damagerRank.isPresent() &&
                    UserRank.RABBIT.equals(userRank.get()) && UserRank.TURTLE.equals(damagerRank.get())) {
                if (PlayLogicUtil.checkPlayerIsRabbit(player)) {
                    PlayLogicUtil.dropRabbitLiver(player);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        // 플레이어가 아이템을 던진 경우의 이벤트 처리
        Player player = event.getPlayer();
        if (PlayLogicUtil.checkRabbitHasLiver(player)) {
            BossBarUtil.startTimer(player);
        } else {
            BossBarUtil.cancelTimer(player);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (PlayLogicUtil.checkRabbitHasLiver(player)) {
            BossBarUtil.startTimer(player);
        } else {
            BossBarUtil.cancelTimer(player);
        }
    }
}
