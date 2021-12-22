package io.github.erickeis.relichunt;

import io.github.erickeis.relichunt.commands.RelicHuntCommand;
import io.github.erickeis.relichunt.listeners.PlayerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public class RelicHunt extends JavaPlugin {
    private GameMap gameMap;

    @Override
    public void onEnable() {
        initializeConfig();

        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
        getCommand("relichunt").setExecutor(new RelicHuntCommand());

        gameMap = new GameMap(this, "CoolMap");
    }

    @Override 
    public void onDisable() {
        super.onDisable();
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    private void initializeConfig() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        getConfig();
        getLogger().info("Config Updated and Loaded");
    }
}
