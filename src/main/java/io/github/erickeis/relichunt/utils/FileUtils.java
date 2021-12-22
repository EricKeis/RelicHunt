package io.github.erickeis.relichunt.utils;

import io.github.erickeis.relichunt.RelicHunt;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class FileUtils {
    public static boolean createDirectory(File dir) {
        if (!dir.exists() && !dir.mkdirs()) {
            JavaPlugin.getPlugin(RelicHunt.class).getLogger().log(Level.SEVERE,"Cannot create directory.");
            return false;
        }
        return true;
    }
}
