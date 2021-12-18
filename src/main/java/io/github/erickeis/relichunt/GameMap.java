package io.github.erickeis.relichunt;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private RelicHunt plugin;
    private HashMap<Integer, Machine> machines = new HashMap<>();

    public GameMap(RelicHunt plugin) {
        this.plugin = plugin;
        machines.put(0, new Machine(plugin));
    }

    public HashMap<Integer, Machine> getMachines() {
        return machines;
    }
    
    public void addMachine(Machine machine) {
        machines.put(0, machine);
    }
}
