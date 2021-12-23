package pt.morais.spawner.loader;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import pt.morais.spawner.MSSpawners;
import pt.morais.spawner.model.ConfigModel;

@Getter
public class ConfigLoader {

    private final MSSpawners plugin;
    private final ConfigModel settings;

    public ConfigLoader(MSSpawners plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        this.settings = new ConfigModel(plugin, "settings.yml");
    }

    public void reloadAllConfig() {
        plugin.reloadConfig();
        settings.reloadConfig();
    }

    public FileConfiguration getConfig() {
        return plugin.getConfig();
    }

}