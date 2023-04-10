package org.goldfrosch.plugin.util;

import org.goldfrosch.plugin.RabbitTurtle_Ryuemei;

public class LogUtil {
    public static void consoleLog(final String msg) {
        RabbitTurtle_Ryuemei.getPlugin(RabbitTurtle_Ryuemei.class).getLogger().info(msg);
    }
}
