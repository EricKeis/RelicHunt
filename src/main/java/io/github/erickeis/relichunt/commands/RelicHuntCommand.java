package io.github.erickeis.relichunt.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RelicHuntCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("relichunt") && sender instanceof Player) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis is a message"));
            return false;
        }
        return false;
    }
}
