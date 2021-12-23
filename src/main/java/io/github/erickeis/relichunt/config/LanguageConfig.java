package io.github.erickeis.relichunt.config;

import io.github.erickeis.relichunt.RelicHunt;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class LanguageConfig {
    private RelicHunt plugin;
    private FileConfiguration lang;
    private File langFile;

    public LanguageConfig(RelicHunt plugin) {
        this.plugin = plugin;

        langFile = new File(plugin.getDataFolder(), "messages.yml");
        lang = YamlConfiguration.loadConfiguration(langFile);
        copyDefaultConfigOptions();
    }

    private void copyDefaultConfigOptions() {
        Reader defaultFileStream =
                new InputStreamReader(plugin.getResource("messages.yml"));
        YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(defaultFileStream);
        lang.options().copyDefaults(true);
        lang.setDefaults(defaultConfig);
        saveConfig();
        try {
            defaultFileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveConfig() {
        try {
            lang.save(langFile.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        return lang;
    }

    public String get(String key) {
        return lang.getString(key);
    }
}
