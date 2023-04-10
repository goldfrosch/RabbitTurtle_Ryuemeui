package org.goldfrosch.plugin.constants;

import org.bukkit.boss.BossBar;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GlobalVariable {
    public final static String CMD_PREFIX = "game";

    public static Map<UUID, UserRank> userRankMap = new HashMap<>();

    public static Map<UUID, BossBar> bossBars = new HashMap<>(); // 플레이어 별 BossBar 관리

    public static Map<UUID, BukkitTask> timerTasks = new HashMap<>(); // 플레이어 별 Timer 관리
    
    public static Map<UUID, Boolean> livingStatus = new HashMap<>(); // 플레이어 별 생존 유무
}
