package pt.morais.spawner.adapter.spawner;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.BlockState;

/**
 * Class that changes the nbt tags inside an item
 */
public abstract class NBTSpawnerAdapter {

    /**
     * Returns an instance of this adapter depending on the version
     */
    @Getter @Setter
    private static NBTSpawnerAdapter instance;

    /**
     * Returns a NBTSpawner from a blockState and defaultParams
     * @param blockState BlockState
     * @param defaultParams Override spawner information to default
     * @return NBTSpawner
     */
    public abstract NBTSpawner getNBTSpawner(BlockState blockState, boolean defaultParams);

    /**
     * Returns a NBTSpawner from a blockState and automatically says that defaultParams is false
     * @param blockState BlockState
     * @return NBTSpawner
     */
    public abstract NBTSpawner getNBTSpawner(BlockState blockState);

}