package io.github.erickeis.relichunt;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

public class GameMap {
    private RelicHunt plugin;
    private HashMap<Integer, Machine> machines = new HashMap<>();
    private FileConfiguration gameMapConfig;
    private File configFile;
    private String mapName;

    public GameMap(RelicHunt plugin, String mapName) {
        this.plugin = plugin;
        this.mapName = mapName;

        loadConfig();
        machines.put(0, new Machine(plugin));
    }

    public HashMap<Integer, Machine> getMachines() {
        return machines;
    }
    
    public void addMachine(Machine machine) {
        machines.put(0, machine);
    }

    private void loadConfig() {
        File mapConfigDir = new File(plugin.getDataFolder(), "data/mapConfigs");

        if (createConfigDirectory(mapConfigDir)) {
            configFile = new File(mapConfigDir, mapName + ".yml");
            gameMapConfig = YamlConfiguration.loadConfiguration(configFile);
            copyDefaultConfigOptions();
        }
    }

    private void copyDefaultConfigOptions() {
        Reader defaultFileStream =
                new InputStreamReader(JavaPlugin.getPlugin(RelicHunt.class).getResource("gameMap.yml"));
        YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(defaultFileStream);
        gameMapConfig.options().copyDefaults(true);
        gameMapConfig.setDefaults(defaultConfig);
        saveConfig();
        try {
            defaultFileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean createConfigDirectory(File mapConfigDir) {
        if (!mapConfigDir.exists() && !mapConfigDir.mkdirs()) {
            plugin.getLogger().info("Cannot create maps directory. Config could not be saved!");
            return false;
        }
        return true;
    }

    public FileConfiguration getConfig() {
        return gameMapConfig;
    }

    public void saveConfig() {
        try {
            gameMapConfig.save(configFile.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
