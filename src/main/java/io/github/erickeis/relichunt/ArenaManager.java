package io.github.erickeis.relichunt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArenaManager {
    private RelicHunt plugin;

    private Map<String, GameMap> enabledMaps = new HashMap<>();
    private GameMap activeArena;

    public ArenaManager(RelicHunt plugin) {
        this.plugin = plugin;
    }


}
