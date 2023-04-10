package org.goldfrosch.plugin;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.goldfrosch.plugin.command.Command;

import static org.goldfrosch.plugin.constants.GlobalVariable.CMD_PREFIX;
import static org.goldfrosch.plugin.util.LogUtil.consoleLog;

@Getter
@Setter
public final class RabbitTurtle_Ryuemei extends JavaPlugin {
    public static RabbitTurtle_Ryuemei plugin;

    private PluginDescriptionFile pdfFile = this.getDescription();
    private String pfName = pdfFile.getName() + " v" + pdfFile.getVersion();
    public static boolean gameStatus = false;

    @Override
    public void onEnable() {

        Command cmd = new Command(this, CMD_PREFIX);
        getCommand(CMD_PREFIX).setExecutor(cmd);
        getCommand(CMD_PREFIX).setTabCompleter(cmd);

        consoleLog(pfName + "이 활성화 되었습니다");
    }

    @Override
    public void onDisable() {
        consoleLog(pfName + "이 비활성화 되었습니다");
        super.onDisable();
    }
}
