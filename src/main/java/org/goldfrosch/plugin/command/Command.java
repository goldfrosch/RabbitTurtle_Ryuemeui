package org.goldfrosch.plugin.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.goldfrosch.plugin.RabbitTurtle_Ryuemei;
import org.goldfrosch.plugin.constants.UserRank;
import org.goldfrosch.plugin.data.GameItem;
import org.goldfrosch.plugin.util.PlayLogicUtil;

import java.util.List;
import java.util.Objects;

import static org.goldfrosch.plugin.constants.GlobalVariable.CMD_PREFIX;
import static org.goldfrosch.plugin.constants.GlobalVariable.userRankMap;

public class Command extends AbstractCommand {
    private final String prefix = Objects.requireNonNull(plugin.getConfig().getString("message.prefix")).replace("&", "§");

    public Command(RabbitTurtle_Ryuemei plugin, String Command) {
        super(plugin, Command);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (label.equalsIgnoreCase(CMD_PREFIX)) {
                if (args.length == 0) {
                    this.noCommand(player);
                } else {
                    switch (args[0]) {
                        case "start" -> {
                            RabbitTurtle_Ryuemei.gameStatus = true;
                            plugin.getServer().getOnlinePlayers().forEach(user -> {
                                PlayLogicUtil.giveRabbitLiver(player);
                            });
                        }
                        case "stop" -> {
                            RabbitTurtle_Ryuemei.gameStatus = false;
                        }
                        case "setrank" -> {
                            if(RabbitTurtle_Ryuemei.gameStatus) {
                                player.sendMessage(this.defaultCommandMessage("게임이 이미 시작되어 더이상 직업을 변경할 수 없습니다."));
                            }
                            userRankMap.put(player.getUniqueId(), UserRank.of(args[1]));
                        }
                        case "liver" -> player.getInventory().addItem(GameItem.Liver());
                        default -> this.noCommand(player);
                    }
                }
            }
        }
        return false;
    }


    public void noCommand(Player player) {
        player.sendMessage(this.defaultCommandMessage("명령어 없는데 허접임?"));
    }

    public String defaultCommandMessage(String msg) {
        return prefix + msg;
    }
}
