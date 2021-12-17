package io.github.erickeis.relichunt.listeners;

import io.github.erickeis.relichunt.RelicHunt;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerInteractListener implements Listener {
    private RelicHunt plugin;

    public PlayerInteractListener(RelicHunt plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.PHYSICAL)) {
            Material material = event.getClickedBlock().getLocation().getBlock().getType();
            if (material.equals(Material.STONE_PRESSURE_PLATE)) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if ((int) event.getPlayer().getLocation().getX() == event.getClickedBlock().getX() &&
                                (int) event.getPlayer().getLocation().getZ() == event.getClickedBlock().getZ()) {
                            plugin.getLogger().info(material.toString());
                        }
                        else {
                            this.cancel();
                            plugin.getLogger().info("Task cancelled for " + event.getPlayer().getDisplayName());
                        }
                    }
                }.runTaskTimerAsynchronously(plugin, 20L, 20L);
            }
        }
    }
}
