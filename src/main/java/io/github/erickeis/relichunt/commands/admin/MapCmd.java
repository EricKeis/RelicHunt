package io.github.erickeis.relichunt.commands.admin;

import io.github.erickeis.relichunt.RelicHunt;
import io.github.erickeis.relichunt.commands.BaseCmd;

public class MapCmd extends BaseCmd {
    private RelicHunt plugin;

    public MapCmd(RelicHunt plugin, String parent) {
        super(plugin, "map", 1);
        aliases = new String[]{"m"};
        this.parent = parent;
    }

    @Override
    public boolean run() {
        if (args.length == 0) {
            sender.sendMessage("This is a base command");
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "create":
                createCmd();
        }
        return true;
    }

    private void createCmd() {
        if (hasPermission(permission + ".create") && args.length == 1) {
            sender.sendMessage("This is from the map create command");
        }
    }
}
