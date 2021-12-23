package pt.morais.spawner.loader;

import org.bukkit.Bukkit;
import pt.morais.spawner.adapter.color.ColorAdapter;
import pt.morais.spawner.adapter.item.NBTItemAdapter;
import pt.morais.spawner.adapter.mob.AIHandlerAdapter;
import pt.morais.spawner.adapter.spawner.NBTSpawnerAdapter;
import pt.morais.spawner.adapter.v1_8_R3.spawner.NBTSpawner;

/**
 * This class handles the version for the adapters
 */
public class VersionLoader {

    /**
     * Primary and unique constructor, handles the versions
     */
    public VersionLoader() {
        String version = Bukkit.getVersion().split("MC: ")[1];
        ColorAdapter.setInstance(new pt.morais.spawner.adapter.v1_8_R3.color.ColorAdapter());
        if (version.startsWith("1.8")) {
            new NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_8_R3.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_8_R3.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_8_R3.entity.AIHandlerAdapter());
            return;
        }
        if (version.startsWith("1.9")) {
            new pt.morais.spawner.adapter.v1_9_R2.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_9_R2.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_9_R2.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_9_R2.entity.AIHandlerAdapter());
            return;
        }
        if (version.startsWith("1.10")) {
            new pt.morais.spawner.adapter.v1_10_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_10_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_10_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_10_R1.entity.AIHandlerAdapter());
            return;
        }
        if (version.startsWith("1.11")) {
            new pt.morais.spawner.adapter.v1_11_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_11_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_11_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_11_R1.entity.AIHandlerAdapter());
            return;
        }
        if (version.startsWith("1.12")) {
            new pt.morais.spawner.adapter.v1_12_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_12_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_12_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_12_R1.entity.AIHandlerAdapter());
            return;
        }
        if (version.startsWith("1.13")) {
            new pt.morais.spawner.adapter.v1_13_R2.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_13_R2.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_13_R2.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_13_R2.entity.AIHandlerAdapter());
            return;
        }
        if (version.startsWith("1.14")) {
            new pt.morais.spawner.adapter.v1_14_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_14_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_14_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_14_R1.entity.AIHandlerAdapter());
            return;
        }
        if (version.startsWith("1.15")) {
            new pt.morais.spawner.adapter.v1_15_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_15_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_15_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_15_R1.entity.AIHandlerAdapter());
            return;
        }
        ColorAdapter.setInstance(new pt.morais.spawner.adapter.v1_16_R3.color.ColorAdapter());
        if (version.startsWith("1.16")) {
            new pt.morais.spawner.adapter.v1_16_R3.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_16_R3.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_16_R3.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_16_R3.entity.AIHandlerAdapter());
            return;
        }
        if (version.startsWith("1.17")) {
            new pt.morais.spawner.adapter.v1_17_R1.spawner.NBTSpawner(null, false);
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_17_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_17_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_17_R1.entity.AIHandlerAdapter());
            return;
        }
        try {
            NBTSpawnerAdapter.setInstance(new pt.morais.spawner.adapter.v1_18_R1.spawner.NBTSpawnerAdapter());
            NBTItemAdapter.setInstance(new pt.morais.spawner.adapter.v1_18_R1.item.NBTItemAdapter());
            AIHandlerAdapter.setInstance(new pt.morais.spawner.adapter.v1_18_R1.entity.AIHandlerAdapter());
        } catch (NoClassDefFoundError ignored) {
        }
    }

}