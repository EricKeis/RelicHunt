package io.github.erickeis.relichunt.commands;

import io.github.erickeis.relichunt.RelicHunt;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class BaseCmd {
    protected RelicHunt plugin;
    protected CommandSender sender;
    protected String[] args;
    protected String[] alias;
    protected String cmdName;
    protected int argLength = 0;
    protected boolean forcePlayer = true;
    protected String parent;
    protected int maxArgs = -1;

    public BaseCmd(RelicHunt plugin) {
        this.plugin = plugin;
    }

    public void processCmd(CommandSender sender, String[] args) {
        this.sender = sender;
        this.args = args;

        if (forcePlayer) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('%', plugin.getLang().get("error" +
                        ".must-be-player")));
                return;
            }
        }

        if (!sender.hasPermission("sw." + parent + "." + cmdName)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getLang().get("error.cmd-no-permission")));
        } else {
            run();
        }
    }

    public abstract boolean run();
}

/*
TODO:
    - check for arg length
    - check response from run method
    - output proper messaging for errors in these
 */
