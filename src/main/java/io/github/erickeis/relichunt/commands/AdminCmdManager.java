package io.github.erickeis.relichunt.commands;

import io.github.erickeis.relichunt.RelicHunt;
import io.github.erickeis.relichunt.commands.admin.map.CreateCmd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminCmdManager implements CommandExecutor {
    private List<BaseCmd> commands = new ArrayList<>();
    private String parentCmd = "rhadmin";

    public AdminCmdManager(RelicHunt plugin) {
        commands.add(new CreateCmd(plugin, parentCmd));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0 || getCommand(args[0]) == null) {
            sender.sendMessage("This is the base admin command");
        } else getCommand(args[0]).processCmd(sender, Arrays.copyOfRange(args, 1, args.length));
        return true;
    }

    public BaseCmd getCommand(String s) {
        for (BaseCmd cmd: commands) {
            if (cmd.getCmdName().equalsIgnoreCase(s)) {
                return cmd;
            }
            for (String alias: cmd.getAliases()) {
                if (alias.equalsIgnoreCase(s)) {
                    return cmd;
                }
            }
        }
        return null;
    }
}
