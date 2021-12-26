package pt.morais.spawner.manager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import pt.morais.spawner.dto.MobInfoDto;
import pt.morais.spawner.model.ConfigModel;
import pt.morais.spawner.util.ColorUtil;

import javax.swing.text.html.parser.Entity;

/**
 * This class is the mob manager, it handles everything related to them
 */
public class MobManager {

    private final ConfigModel mobsModel;

    public MobManager(ConfigModel mobsModel) {
        this.mobsModel = mobsModel;
    }

    /**
     * This method returns the mob information
     * @param type Mob type
     * @return MobInfoDto
     */
    public MobInfoDto getMobInfo(EntityType type) {
        String path = "custom-names." + type.name();
        if (!getMobConfig().contains(path)) path = "custom-names.not-found";
        return new MobInfoDto(ColorUtil.apply(getMobConfig().getString(path + ".name")),
                ColorUtil.apply(getMobConfig().getString(path + ".stack")),
                ColorUtil.apply(getMobConfig().getString(path + ".tier")));
    }
    //name stack tier

    /**
     * This method returns the mob config
     * @return FileConfiguration
     */
    public FileConfiguration getMobConfig() {
        return mobsModel.getConfiguration();
    }

}