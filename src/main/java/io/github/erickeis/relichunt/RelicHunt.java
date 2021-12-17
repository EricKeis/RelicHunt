package io.github.erickeis.relichunt;

import io.github.erickeis.relichunt.listeners.PlayerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;

public class RelicHunt extends JavaPlugin {
    @Override
    public void onEnable() {
        intiializeConfig();

        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
    }

    @Override 
    public void onDisable() {
        super.onDisable();
    }

    private void intiializeConfig() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        getConfig();
        getLogger().info("Config Updated and Loaded");
    }
}
