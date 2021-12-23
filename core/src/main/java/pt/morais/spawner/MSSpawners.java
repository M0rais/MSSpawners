package pt.morais.spawner;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pt.morais.spawner.exception.UnknownItemException;
import pt.morais.spawner.loader.ConfigLoader;
import pt.morais.spawner.loader.VersionLoader;
import pt.morais.spawner.util.ColorUtil;

@Getter
public class MSSpawners extends JavaPlugin {

    private ConfigLoader configLoader;

    @Override
    public void onEnable() {
        this.configLoader = new ConfigLoader(this);
        new VersionLoader();
    }

}