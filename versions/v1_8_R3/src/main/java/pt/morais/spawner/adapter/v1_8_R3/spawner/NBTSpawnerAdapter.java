package pt.morais.spawner.adapter.v1_8_R3.spawner;

import org.bukkit.block.BlockState;
import pt.morais.spawner.adapter.spawner.NBTSpawner;

public class NBTSpawnerAdapter extends pt.morais.spawner.adapter.spawner.NBTSpawnerAdapter {

    @Override
    public NBTSpawner getNBTSpawner(BlockState blockState, boolean defaultParams) {
        return new pt.morais.spawner.adapter.v1_8_R3.spawner.NBTSpawner(blockState, defaultParams);
    }

    @Override
    public NBTSpawner getNBTSpawner(BlockState blockState) {
        return new pt.morais.spawner.adapter.v1_8_R3.spawner.NBTSpawner(blockState, false);
    }
}