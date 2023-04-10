package org.goldfrosch.plugin.command;

import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.goldfrosch.plugin.RabbitTurtle_Ryuemei;

import java.util.List;

public abstract class AbstractCommand implements TabExecutor {
    protected RabbitTurtle_Ryuemei plugin;

    public AbstractCommand(RabbitTurtle_Ryuemei plugin, String Command) {
        this.plugin = plugin;
    }

    public abstract List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args);
    public abstract boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args);
}
