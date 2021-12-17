package io.github.erickeis.relichunt;

import io.github.erickeis.relichunt.listeners.PlayerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;

public class RelicHunt extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
