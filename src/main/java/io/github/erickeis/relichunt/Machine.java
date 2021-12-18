package io.github.erickeis.relichunt;

import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Machine {
    private RelicHunt plugin;
    private BukkitTask machineTask;
    private HashMap<UUID, BukkitTask> players = new HashMap<>();
    private float percentComplete = 0;

    public Machine(RelicHunt plugin) {
        this.plugin = plugin;
        startMachineTask();
    }

    // change this logic to add progress in the addPlayer runnable and account for multiple players
    public void startMachineTask() {
        machineTask = new BukkitRunnable() {
            @Override
            public void run() {
                if (players.size() > 0) {
                    percentComplete += 0.5;
                }
            }
        }.runTaskTimer(plugin, 20L, 20L);
    }

    public void addPlayer(PlayerInteractEvent event) {
        if (!players.containsKey(event.getPlayer().getUniqueId())) {
            players.put(event.getPlayer().getUniqueId(), new BukkitRunnable() {
                @Override
                public void run() {
                    if ((int) event.getPlayer().getLocation().getX() == event.getClickedBlock().getX() &&
                            (int) event.getPlayer().getLocation().getZ() == event.getClickedBlock().getZ()) {
                        plugin.getLogger().info(event.getClickedBlock().getLocation().getBlock().getType().toString());
                        event.getPlayer().sendMessage("Machine is " + percentComplete + " complete");
                    }
                    else {
                        this.cancel();
                        players.remove(event.getPlayer().getUniqueId());
                        plugin.getLogger().info("Task cancelled for " + event.getPlayer().getDisplayName());
                    }
                }
            }.runTaskTimer(plugin, 20L, 20L));
        }
    }
}
