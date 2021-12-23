package pt.morais.spawner.model;

import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import pt.morais.spawner.MSSpawners;

import java.io.File;
import java.io.IOException;

/**
 * This class handles creation of custom configs
 */
@Getter
public class ConfigModel {

    private final String name;
    private final FileConfiguration configuration;
    private final File file;

    public ConfigModel(MSSpawners plugin, String name) {
        this.name = name;
        file = new File(plugin.getDataFolder(), name);

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            plugin.saveResource(name, false);
        }

        configuration = new YamlConfiguration();

        try {
            configuration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

    /**
     * Saves the current config
     */
    public void saveConfig() {
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reloads the config
     */
    public void reloadConfig() {
        try {
            configuration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save and reload config
     */
    public void saveAndReload() {
        saveConfig();
        reloadConfig();
    }

}