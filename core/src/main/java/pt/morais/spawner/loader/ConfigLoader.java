package pt.morais.spawner.loader;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import pt.morais.spawner.MSSpawners;
import pt.morais.spawner.model.ConfigModel;

/**
 * This class loads all the configuration stuff
 */
@Getter
public class ConfigLoader {

    private final MSSpawners plugin;
    private final ConfigModel settings,
            spawners,
    mobs;

    /**
     * Primary and unique constructor, loads every configuration
     *
     * @param plugin MSSpawners
     */
    public ConfigLoader(MSSpawners plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        this.settings = new ConfigModel(plugin, "settings.yml");
        this.spawners = new ConfigModel(plugin, "spawner.yml");
        this.mobs = new ConfigModel(plugin, "mob.yml");
    }

    /**
     * This method reloads all the configs
     */
    public void reloadAllConfig() {
        plugin.reloadConfig();
        settings.reloadConfig();
        spawners.reloadConfig();
        mobs.reloadConfig();
    }

    /**
     * Returns the main configuration (config.yml)
     *
     * @return FileConfiguration
     */
    public FileConfiguration getConfig() {
        return plugin.getConfig();
    }

}