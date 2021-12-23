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

    public VersionLoader() {
        try {
            new NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_8_R3.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_8_R3.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_8_R3.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("ZOMBIE"));
            return;
        } catch (NoClassDefFoundError ignored) {
        }
        try {
            new pt.morais.spawner.adapter.v1_9_R2.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_9_R2.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_9_R2.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_9_R2.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("ZOMBIE"));
            return;
        } catch (NoClassDefFoundError ignored) {
        }
        try {
            new pt.morais.spawner.adapter.v1_10_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_10_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_10_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_10_R1.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("ZOMBIE"));
            return;
        } catch (NoClassDefFoundError ignored) {
        }
        try {
            new pt.morais.spawner.adapter.v1_11_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_11_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_11_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_11_R1.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("ZOMBIE"));
            return;
        } catch (NoClassDefFoundError ignored) {
        }
        try {
            new pt.morais.spawner.adapter.v1_12_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_12_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_12_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_12_R1.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("ZOMBIE"));
            return;
        } catch (NoClassDefFoundError ignored) {
        }
        try {
            new pt.morais.spawner.adapter.v1_13_R2.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_13_R2.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_13_R2.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_13_R2.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("EVOKER"));
            return;
        } catch (NoClassDefFoundError ignored) {
        }
        try {
            new pt.morais.spawner.adapter.v1_14_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_14_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_14_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_14_R1.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("EVOKER"));
            return;
        } catch (NoClassDefFoundError ignored) {
        }
        try {
            new pt.morais.spawner.adapter.v1_15_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_15_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_15_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_15_R1.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("EVOKER"));
            return;
        } catch (NoClassDefFoundError ignored) {
        }
        try {
            new pt.morais.spawner.adapter.v1_16_R3.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_16_R3.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_16_R3.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_16_R3.entity.AIHandlerAdapter());
            MSSpawners.setType(EntityType.valueOf("PIGLIN"));
            return;
        } catch (NoClassDefFoundError ignored) {
        }
        //Stopped working because of new nms
        String version = Bukkit.getVersion().split("MC: ")[1];
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
            MSSpawners.setType(EntityType.valueOf("VINDICATOR"));
        } catch (NoClassDefFoundError ignored) {
        }
    }

}