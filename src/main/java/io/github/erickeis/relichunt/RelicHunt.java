package io.github.erickeis.relichunt;

import io.github.erickeis.relichunt.commands.RelicHuntCommand;
import io.github.erickeis.relichunt.config.LanguageConfig;
import io.github.erickeis.relichunt.listeners.PlayerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class RelicHunt extends JavaPlugin {
    private GameMap gameMap;
    private LanguageConfig lang;
    private Map<String, GameMap> arenas = new HashMap<>();

    @Override
    public void onEnable() {
        initializeConfig();

        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
        getCommand("relichunt").setExecutor(new RelicHuntCommand());

        gameMap = new GameMap(this, "CoolMap");
        lang = new LanguageConfig(this);
    }

    @Override 
    public void onDisable() {
        super.onDisable();
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public LanguageConfig getLang() {
        return lang;
    }

    private void initializeConfig() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        getConfig();
        getLogger().info("Config Updated and Loaded");
    }
}
