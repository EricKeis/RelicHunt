package io.github.erickeis.relichunt.commands.admin.map;

import io.github.erickeis.relichunt.RelicHunt;
import io.github.erickeis.relichunt.commands.BaseCmd;

public class CreateCmd extends BaseCmd {
    private RelicHunt plugin;

    public CreateCmd(RelicHunt plugin, String parent) {
        super(plugin, "create", 1);
        aliases = new String[]{"cr", "c"};
    }

    @Override
    public boolean run() {
        sender.sendMessage("You ran the create command");
        return true;
    }
}
