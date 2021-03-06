package io.github.erickeis.relichunt.commands;

import io.github.erickeis.relichunt.RelicHunt;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class BaseCmd {
    protected RelicHunt plugin;
    protected CommandSender sender;
    protected String[] args;
    protected String[] aliases;
    protected String cmdName;
    protected int argLength = 0;
    protected boolean forcePlayer = true;
    protected String parent;
    protected String permission;
    protected int maxArgs = -1;

    public BaseCmd(RelicHunt plugin, String cmdName, int argLength) {
        this.plugin = plugin;
        this.cmdName = cmdName;
        this.argLength = argLength;
        permission = "rh" + parent + "." + cmdName;
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

        if (hasPermission(permission)) {
            run();
        }
    }

    public String getCmdName() {
        return cmdName;
    }

    public String[] getAliases() {
        return aliases;
    }

    protected boolean hasPermission(String s) {
        if (!sender.hasPermission("rh" + parent + "." + cmdName)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getLang().get("error.cmd-no-permission")));
            return false;
        }
        return true;
    }

    public abstract boolean run();
}

/*
TODO:
    - check for arg length
    - check response from run method
    - output proper messaging for errors in these
 */
