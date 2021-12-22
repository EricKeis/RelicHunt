package io.github.erickeis.relichunt.Config;

import io.github.erickeis.relichunt.RelicHunt;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class GameMapConfig {
    private FileConfiguration gameMapConfig;

    public GameMapConfig(RelicHunt plugin) {
    }

    public static void copyDefaults(File mapConfig) {
        YamlConfiguration newConfig = YamlConfiguration.loadConfiguration(mapConfig);
        Reader defaultFileStream =
                new InputStreamReader(JavaPlugin.getPlugin(RelicHunt.class).getResource("gameMap.yml"));
        YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(defaultFileStream);
        newConfig.options().copyDefaults(true);
        newConfig.setDefaults(defaultConfig);
        try {
            newConfig.save(mapConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    TODO:
    - copydefaults method
    - get config method
     */
}
