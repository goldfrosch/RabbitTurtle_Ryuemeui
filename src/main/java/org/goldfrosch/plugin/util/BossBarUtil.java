package org.goldfrosch.plugin.util;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.goldfrosch.plugin.RabbitTurtle_Ryuemei;

import java.util.UUID;

import static org.goldfrosch.plugin.constants.GlobalVariable.*;

public class BossBarUtil {
    public static void startTimer(Player player) {
        UUID playerId = player.getUniqueId();
        BossBar bossBar = Bukkit.createBossBar("남은 생존 시간", BarColor.BLUE, BarStyle.SOLID);
        bossBar.setProgress(1.0);
        bossBar.setVisible(true);
        bossBar.addPlayer(player);
        bossBars.put(playerId, bossBar);

        timerTasks.put(player.getUniqueId(), new BukkitRunnable() {
            int time = 10 * 60;
            final int maxTime = time;

            @Override
            public void run() {
                time--;

                double progress = (double) time / maxTime;
                for (Player player : Bukkit.getOnlinePlayers()) {
                    UUID playerId = player.getUniqueId();
                    BossBar bossBar = bossBars.get(playerId);
                    if (bossBar != null) {
                        bossBar.setProgress(progress);
                    }
                }

                if (time <= 0) {
                    livingStatus.put(player.getUniqueId(), false);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
                            99999999, 1, false, false));
                    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1, 1);
                    cancel();
                }
            }
        }.runTaskTimer(RabbitTurtle_Ryuemei.plugin, 0, 20));
    }

    public static void cancelTimer(Player player) {
        if (timerTasks.get(player.getUniqueId()) != null) {
            timerTasks.get(player.getUniqueId()).cancel();
            timerTasks.remove(player.getUniqueId());
        }

        if (bossBars.get(player.getUniqueId()) != null) {
            bossBars.get(player.getUniqueId()).removeAll();
            bossBars.remove(player.getUniqueId());
        }
    }
}
