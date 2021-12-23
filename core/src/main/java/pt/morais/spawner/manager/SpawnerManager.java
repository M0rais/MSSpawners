package pt.morais.spawner.manager;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.metadata.FixedMetadataValue;
import pt.morais.spawner.MSSpawners;

/**
 * This class is the spawner manager, it handles everything related to them
 */
public class SpawnerManager {

    private final MSSpawners plugin;

    /**
     * Primary and unique constructor, handles the dependencies
     * @param plugin MSSpawners
     */
    public SpawnerManager(MSSpawners plugin) {
        this.plugin = plugin;
    }

    /**
     * Set the spawn type metadata into the block
     * @param item ItemInHand
     * @param block Block placed
     */
    public void setSpawnType(ItemStack item, Block block) {
        BlockStateMeta blockStateMeta = (BlockStateMeta) item.getItemMeta();
        CreatureSpawner creatureSpawner = (CreatureSpawner) blockStateMeta.getBlockState();
        block.setMetadata("type", new FixedMetadataValue(plugin, creatureSpawner.getSpawnedType().name()));
    }

    /**
     * Returns an ItemStack of a mob spawner with the entity type inside
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

}