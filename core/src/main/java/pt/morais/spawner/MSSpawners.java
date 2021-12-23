package pt.morais.spawner;

import com.cryptomorin.xseries.XMaterial;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import pt.morais.spawner.adapter.mob.AIHandlerAdapter;
import pt.morais.spawner.adapter.spawner.NBTSpawner;
import pt.morais.spawner.adapter.spawner.NBTSpawnerAdapter;
import pt.morais.spawner.loader.ConfigLoader;
import pt.morais.spawner.loader.VersionLoader;

@Getter
public class MSSpawners extends JavaPlugin implements Listener {

    private ConfigLoader configLoader;
    @Setter
    private static EntityType type;

    @Override
    public void onEnable() {
        this.configLoader = new ConfigLoader(this);
        new VersionLoader(this);
        getServer().getPluginManager().registerEvents(this, this);
    }

    public EntityType getSpawnType(ItemStack item) {
        BlockStateMeta blockStateMeta = (BlockStateMeta) item.getItemMeta();
        CreatureSpawner creatureSpawner = (CreatureSpawner) blockStateMeta.getBlockState();
        return creatureSpawner.getSpawnedType();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().getInventory().clear();

        ItemStack spawner = XMaterial.matchXMaterial("MOB_SPAWNER").get().parseItem();
        BlockStateMeta blockStateMeta = (BlockStateMeta) spawner.getItemMeta();
        CreatureSpawner creatureSpawner = (CreatureSpawner) blockStateMeta.getBlockState();
        creatureSpawner.setSpawnedType(type);
        blockStateMeta.setBlockState(creatureSpawner);
        spawner.setItemMeta(blockStateMeta);

        event.getPlayer().getInventory().addItem(spawner, new ItemStack(Material.DIAMOND_SWORD), XMaterial.matchXMaterial("WATCH").get().parseItem());
    }

    /**
     *  Test event
     *
     * @param event
     */
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() != XMaterial.matchXMaterial("MOB_SPAWNER").get().parseMaterial()) return;
        event.getBlock().setMetadata("type", new FixedMetadataValue(this, getSpawnType(event.getItemInHand())));
        NBTSpawner nbtSpawner = NBTSpawnerAdapter.getInstance().getNBTSpawner(event.getBlock().getState(), true);
        System.out.println(nbtSpawner);
        nbtSpawner.setString("a", "b");
        nbtSpawner.setInteger("b", 1);
        nbtSpawner.setDouble("c", 2.0);
        nbtSpawner.setNBTList("d", "e", "f", "g");
        System.out.println(nbtSpawner);
        System.out.println("string = " + nbtSpawner.getString("a"));
        System.out.println("int = " + nbtSpawner.getInteger("b"));
        System.out.println("double = " + nbtSpawner.getDouble("c"));
        System.out.println("list = " + nbtSpawner.getAllListValues("d"));
        nbtSpawner.changeSpawnRate(3, 5);
        System.out.println(nbtSpawner);
    }

    @EventHandler
    public void onSpawn(SpawnerSpawnEvent event) {
        AIHandlerAdapter.getInstance().getAiHandler().removeAI(event.getEntity());
    }

    @EventHandler
    public void o(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (event.getItem().getType() == Material.DIAMOND_SWORD) {
            if (event.getPlayer().getGameMode() == GameMode.SURVIVAL) event.getPlayer().setGameMode(GameMode.CREATIVE);
            else event.getPlayer().setGameMode(GameMode.SURVIVAL);
        }
        if (event.getItem().getType() == XMaterial.matchXMaterial("WATCH").get().parseMaterial()) {
            event.getPlayer().getWorld().setTime(13000);
        }
    }

}