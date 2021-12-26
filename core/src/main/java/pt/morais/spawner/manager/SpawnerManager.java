package pt.morais.spawner.manager;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.metadata.FixedMetadataValue;
import pt.morais.spawner.MSSpawners;
import pt.morais.spawner.dto.MobInfoDto;
import pt.morais.spawner.model.ConfigModel;
import pt.morais.spawner.model.util.ItemBuilder;
import pt.morais.spawner.util.Placeholder;

/**
 * This class is the spawner manager, it handles everything related to them
 */
public class SpawnerManager {

    private final MSSpawners plugin;
    private final ConfigModel spawnersModel;
    private final MobManager mobManager;

    /**
     * Primary and unique constructor, handles the dependencies
     *
     * @param plugin MSSpawners
     */
    public SpawnerManager(MSSpawners plugin) {
        this.plugin = plugin;
        this.spawnersModel = plugin.getConfigLoader().getSpawners();
        this.mobManager = plugin.getMobManager();
    }

    /**
     * Set the spawn type metadata into the block
     *
     * @param item  ItemInHand
     * @param block Block placed
     */
    public void setSpawnType(ItemStack item, Block block) {
        BlockStateMeta blockStateMeta = (BlockStateMeta) item.getItemMeta();
        CreatureSpawner creatureSpawner = (CreatureSpawner) blockStateMeta.getBlockState();
        block.setMetadata("type", new FixedMetadataValue(plugin, creatureSpawner.getSpawnedType().name()));
    }

    /**
     * Returns an ItemStack of a mob spawner with the entity type inside
     *
     * @param entityType Target entity
     * @return ItemStack
     */
    public ItemStack getSpawnerCage(EntityType entityType) {
        ItemStack spawner = XMaterial.matchXMaterial("MOB_SPAWNER").get().parseItem();
        BlockStateMeta blockStateMeta = (BlockStateMeta) spawner.getItemMeta();
        CreatureSpawner creatureSpawner = (CreatureSpawner) blockStateMeta.getBlockState();
        creatureSpawner.setSpawnedType(entityType);
        blockStateMeta.setBlockState(creatureSpawner);
        spawner.setItemMeta(blockStateMeta);
        return spawner;
    }

    /**
     * This method gets the spawner item
     * @param type Mob type
     * @param amount Spawner amount
     * @param owner First owner
     * @param breakName Broke name
     * @param speed Speed level
     * @param drops Drops level
     * @return Spawner
     */
    public ItemStack getSpawner(EntityType type, int amount, String owner, String breakName, int speed, int drops) {
        MobInfoDto mobInfoDto = mobManager.getMobInfo(type);
        Placeholder[] placeholders = new Placeholder[]{
                new Placeholder("%type%", ChatColor.stripColor(mobInfoDto.getName())), //Return type name without color
                new Placeholder("%mob%", mobInfoDto.getName()), //Return type name with color
                new Placeholder("%owner%", owner), //Return first owner
                new Placeholder("%break%", breakName), //Return who broke
                new Placeholder("%speed%", speed), //Return speed level
                new Placeholder("%drops%", drops) //Return drops level
        };
        return new ItemBuilder(getSpawnerCage(type))
                .name(getSpawnerConfig().getString("spawner-item.name"), placeholders)
                .lore(getSpawnerConfig().getStringList("spawner-item.lore"), placeholders)
                .amount(amount)
                .addNBTTag("speed", speed)
                .addNBTTag("drops", drops)
                .getItem();
    }

    /**
     * This method gets the spawner item
     * @param type Mob type
     * @param amount Spawner amount
     * @param owner First owner
     * @return Spawner
     */
    public ItemStack getSpawner(EntityType type, int amount, String owner) {
        return getSpawner(type, amount, owner, owner, 1, 1);
    }

    /**
     * This method give us the spawner config
     *
     * @return Spawner config
     */
    public FileConfiguration getSpawnerConfig() {
        return spawnersModel.getConfiguration();
    }

}