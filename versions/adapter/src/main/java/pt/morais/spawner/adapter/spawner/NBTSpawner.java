package pt.morais.spawner.adapter.spawner;

import lombok.Getter;
import lombok.ToString;
import org.bukkit.block.BlockState;

import java.util.List;

/**
 * Class that changes nbt tags inside a spawner
 */
@ToString
public abstract class NBTSpawner {

    /**
     * NBTTag
     */
    @Getter
    public Object compound;

    /**
     * BlockState
     */
    @Getter
    public BlockState blockState;

    /**
     * Primary constructor
     *
     * @param blockState    block state
     * @param defaultParams default parameters
     */
    public NBTSpawner(BlockState blockState, boolean defaultParams) {

        if (blockState == null) {
            verifyVersion();
            return;
        }

        this.blockState = blockState;

        setup();

        if (defaultParams) {
            setupDefaultParameters();
        }
    }

    /**
     * Add default params
     */
    public abstract void setup();

    /**
     * Remove a NBTTagCompound from spawner
     *
     * @param name compound name
     */
    public abstract void removeCompound(String name);

    /**
     * This tag contains the TileEntityMobSpawner
     *
     * @return tileEntityMobSpawner
     */
    public abstract Object getTileEntityMobSpawner();

    /**
     * Get the MobAbstractSpawner, this will stores all custom tag.
     *
     * @return MobSpawnerAbstract
     */
    public abstract Object getAbstractMobSpawner();

    /**
     * Get an integer value from the spawner
     *
     * @param key NBTTag key
     * @return int
     */
    public abstract int getInteger(String key);

    /**
     * Get a double value from the spawner
     *
     * @param key NBTTag key
     * @return double
     */
    public abstract double getDouble(String key);

    /**
     * Get a String value from the spawner
     *
     * @param key NBTTag key
     * @return string
     */
    public abstract String getString(String key);

    /**
     * Verify if a list contains a key
     *
     * @param list NBTTag path
     * @param key  List path
     * @return boolean
     */
    public abstract boolean containsKey(String list, String key);

    /**
     * Add a value to a list
     *
     * @param key   NBTTag path
     * @param value List value
     */
    public abstract void addListValue(String key, String value);

    /**
     * Add a value to a list
     *
     * @param key NBTTag path
     * @param key List path
     */
    public abstract void removeListValue(String listName, String key);

    /**
     * Verify if a list contains a key
     *
     * @param listName NBTTag path
     * @param key      List path
     * @return boolean
     */
    public abstract boolean hasKey(String listName, String key);

    /**
     * Get all list values
     *
     * @param listName NBTTag path
     * @return list
     */
    public abstract List<String> getAllListValues(String listName);

    /**
     * Get list size
     *
     * @param listName NBTTag path
     * @return int
     */
    public abstract int getListSize(String listName);

    /**
     * Stores a custom NBTTag list
     *
     * @param key    NBTTag path
     * @param values values
     */
    public abstract NBTSpawner setNBTList(String key, String... values);


    /**
     * Stores a custom tag
     *
     * @param key   NBTTag path
     * @param value key value
     */
    public abstract NBTSpawner setInteger(String key, int value);

    /**
     * Stores a custom tag in SpawnData compound
     *
     * @param key   NBTTag path
     * @param value key value
     */
    public abstract NBTSpawner setDouble(String key, double value);

    /**
     * Stores a custom tag
     *
     * @param key   tag NBTTag path
     * @param value key value
     */
    public abstract NBTSpawner setString(String key, String value);

    /**
     * Updates the spawn speed
     * @param min Fastest spawn
     * @param max Slowest spawn
     * @return NBTSpawner
     */
    public abstract NBTSpawner changeSpawnRate(short min, short max);

    /**
     * Updates the spawn speed in seconds
     * @param min Fastest spawn
     * @param max Slowest spawn
     * @return NBTSpawner
     */
    public NBTSpawner changeSpawnRate(double min, double max) {
        return changeSpawnRate((short) (min * 20), (short) (max * 20));
    }

    /**
     * Get the compound who stores all custom tag.
     *
     * @return SpawnPotentials compound
     */
    public abstract Object getPotentialsCompound();

    /**
     * Check if a custom key exists
     *
     * @param key NBTTag path
     * @return bool
     */
    public abstract boolean existsKey(String key);

    /**
     * NBTTagList of a spawner NBT tag.
     *
     * @param listName NBTTag path
     * @return NBTTagList
     */
    public abstract Object getList(String listName);

    /**
     * Removes a NBTTag from the spawner
     *
     * @param key NBTTag path
     */
    public abstract void removeKey(String key);

    /**
     * Setup the spawner deafult parameters
     *
     * @see <a href="https://minecraft.gamepedia.com/Spawner">Spawner</a>
     */
    public abstract void setupDefaultParameters();

    /**
     * Verify version
     */
    public abstract void verifyVersion();

}