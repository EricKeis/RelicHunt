package io.github.erickeis.relichunt;

import io.github.erickeis.relichunt.utils.Coordinate;
import io.github.erickeis.relichunt.utils.FileUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

public class GameMap {
    private RelicHunt plugin;
    private ArrayList<Machine> machines = new ArrayList<>();
    private FileConfiguration gameMapConfig;
    private File configFile;
    private String mapName;

    public GameMap(RelicHunt plugin, String mapName) {
        this.plugin = plugin;
        this.mapName = mapName;

        loadConfig();
        machines.add(new Machine(plugin, new Coordinate("22:97:-17")));
    }

    public ArrayList<Machine> getMachines() {
        return machines;
    }
    
    public void addMachine(Machine machine) {
        machines.add(machine);
    }

    private void loadConfig() {
        File mapConfigDir = new File(plugin.getDataFolder(), "data/mapConfigs");

        if (FileUtils.createDirectory(mapConfigDir)) {
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
