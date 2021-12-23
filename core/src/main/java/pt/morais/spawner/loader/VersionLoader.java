package pt.morais.spawner.loader;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import pt.morais.spawner.MSSpawners;
import pt.morais.spawner.adapter.item.NBTItemAdapter;
import pt.morais.spawner.adapter.mob.AIHandlerAdapter;
import pt.morais.spawner.adapter.spawner.NBTSpawnerAdapter;
import pt.morais.spawner.adapter.v1_8_R3.spawner.NBTSpawner;

public class VersionLoader {

    public VersionLoader(MSSpawners plugin) {
        String version = Bukkit.getVersion().split("MC: ")[1];
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            Bukkit.broadcastMessage(version);
        }, 20*3);
        if (version.startsWith("1.8")) {
            new NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_8_R3.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_8_R3.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_8_R3.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("ZOMBIE"));
            return;
        }
        if (version.startsWith("1.9")) {
            new pt.morais.spawner.adapter.v1_9_R2.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_9_R2.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_9_R2.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_9_R2.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("ZOMBIE"));
            return;
        }
        if (version.startsWith("1.10")) {
            new pt.morais.spawner.adapter.v1_10_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_10_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_10_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_10_R1.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("ZOMBIE"));
            return;
        }
        if (version.startsWith("1.11")) {
            new pt.morais.spawner.adapter.v1_11_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_11_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_11_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_11_R1.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("ZOMBIE"));
            return;
        }
        if (version.startsWith("1.12")) {
            new pt.morais.spawner.adapter.v1_12_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_12_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_12_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_12_R1.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("ZOMBIE"));
            return;
        }
        if (version.startsWith("1.13")) {
            new pt.morais.spawner.adapter.v1_13_R2.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_13_R2.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_13_R2.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_13_R2.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("EVOKER"));
            return;
        }
        if (version.startsWith("1.14")) {
            new pt.morais.spawner.adapter.v1_14_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_14_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_14_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_14_R1.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("EVOKER"));
            return;
        }
        if (version.startsWith("1.15")) {
            new pt.morais.spawner.adapter.v1_15_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_15_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_15_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_15_R1.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("EVOKER"));
            return;
        }
        if (version.startsWith("1.16")) {
            new pt.morais.spawner.adapter.v1_16_R3.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_16_R3.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_16_R3.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_16_R3.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("PIGLIN"));
            return;
        }
        if (version.startsWith("1.17")) {
            new pt.morais.spawner.adapter.v1_17_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_17_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_17_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_17_R1.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("SPIDER"));
            return;
        }
        try {
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_18_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_18_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_18_R1.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("PIGLIN"));
        } catch (NoClassDefFoundError ignored) {
        }
    }

}