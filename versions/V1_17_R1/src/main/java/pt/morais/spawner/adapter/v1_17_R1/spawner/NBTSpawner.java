package pt.morais.spawner.adapter.v1_17_R1.spawner;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;

import java.util.List;
import java.util.Objects;

public class NBTSpawner extends pt.morais.spawner.adapter.spawner.NBTSpawner {

    private Level world;
    private BlockPos blockPosition;

    public NBTSpawner(BlockState blockState, boolean defaultParams) {
        super(blockState, defaultParams);
        if (blockState == null) {
            verifyVersion();
            return;
        }
        Location location = blockState.getLocation();
        this.world = ((CraftWorld) blockState.getWorld()).getHandle();
        this.blockPosition = new BlockPos(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Override
    public void setup() {
        CompoundTag nbtTagCompound = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTagCompound);
        this.compound = nbtTagCompound;
    }

    @Override
    public void removeCompound(String name) {
        BaseSpawner mobSpawnerAbstract = getAbstractMobSpawner();
        CompoundTag nbtTag = new CompoundTag();
        mobSpawnerAbstract.save(world, blockPosition, nbtTag);
        nbtTag.remove(name);
        mobSpawnerAbstract.load(world, blockPosition, nbtTag);
    }

    @Override
    public BlockEntity getTileEntityMobSpawner() {
        Location location = blockState.getLocation();
        BlockPos blockPos = new BlockPos(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        return ((CraftWorld) location.getWorld()).getHandle().getBlockEntity(blockPos);
    }

    @Override
    public BaseSpawner getAbstractMobSpawner() {
        return ((SpawnerBlockEntity) getTileEntityMobSpawner()).getSpawner();
    }

    @Override
    public int getInteger(String key) {
        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);
        return getPotentialsCompound().getCompound("Entity").getInt(key);
    }

    @Override
    public double getDouble(String key) {
        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);
        return getPotentialsCompound().getCompound("Entity").getDouble(key);
    }

    @Override
    public String getString(String key) {
        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);
        return getPotentialsCompound().getCompound("Entity").getString(key);
    }

    @Override
    public boolean containsKey(String list, String key) {
        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);
        CompoundTag compound = getPotentialsCompound();

        for (int i = 0; i < compound.getCompound("Entity").getList(list, 10).size(); i++) {
            if (StringUtils.substringBetween(compound.getCompound("Entity").getList(list, 10).getString(i), "\"").equals(key))
                return true;
        }
        return false;
    }

    @Override
    public void addListValue(String key, String value) {
        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);

        ListTag nbtTagList = getPotentialsCompound().getCompound("Entity").getList(key, 10);
        CompoundTag memberTag = new CompoundTag();
        memberTag.putString(value, value);
        nbtTagList.add(memberTag);

        spawnerAbstract.load(world, blockPosition, nbtTag);
        getTileEntityMobSpawner().setChanged();
    }

    @Override
    public void removeListValue(String listName, String key) {
        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);

        ListTag nbtTagList = getPotentialsCompound().getCompound("Entity").getList(listName, 10);

        for (int i = 0; i < nbtTagList.size(); i++) {
            if (StringUtils.substringBetween(nbtTagList.getString(i), "\"").equals(key)) {
                nbtTagList.remove(i);
            }
        }

        spawnerAbstract.load(world, blockPosition, nbtTag);
        getTileEntityMobSpawner().setChanged();
    }

    @Override
    public boolean hasKey(String listName, String key) {
        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);
        CompoundTag compound = getPotentialsCompound();
        for (int i = 0; i < compound.getCompound("Entity").getList(listName, 10).size(); i++) {
            String value = compound.getCompound("Entity").getList(listName, 10).getString(i);
            if (StringUtils.substringBetween(value, "\"").equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> getAllListValues(String listName) {
        List<String> list = Lists.newArrayList();
        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);
        CompoundTag compound = getPotentialsCompound();
        for (int i = 0; i < compound.getCompound("Entity").getList(listName, 10).size(); i++) {
            String value = compound.getCompound("Entity").getList(listName, 10).getString(i);
            if (value == null) {
                continue;
            }

            list.add(StringUtils.substringBetween(value, "\""));
        }
        return list;
    }

    @Override
    public int getListSize(String listName) {
        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);
        CompoundTag compound = getPotentialsCompound();
        if (compound.getCompound("Entity").contains("Members")) {
            return compound.getCompound("Entity").getList(listName, 10).size();
        } else {
            return 0;
        }
    }

    @Override
    public pt.morais.spawner.adapter.spawner.NBTSpawner setNBTList(String key, String... values) {
        ListTag nbtTagList = new ListTag();
        for (String value : values) {
            CompoundTag valueTag = new CompoundTag();
            valueTag.putString(value, value);
            nbtTagList.add(valueTag);
        }

        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);

        nbtTag.getCompound("SpawnData").put(key, nbtTagList);
        getPotentialsCompound().getCompound("Entity").put(key, nbtTagList);

        spawnerAbstract.load(world, blockPosition, nbtTag);
        getTileEntityMobSpawner().setChanged();
        return this;
    }

    @Override
    public pt.morais.spawner.adapter.spawner.NBTSpawner setInteger(String key, int value) {
        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);
        getPotentialsCompound().getCompound("Entity").putInt(key, value);
        spawnerAbstract.load(world, blockPosition, nbtTag);
        getTileEntityMobSpawner().setChanged();
        return this;
    }

    @Override
    public pt.morais.spawner.adapter.spawner.NBTSpawner setDouble(String key, double value) {
        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);
        getPotentialsCompound().getCompound("Entity").putDouble(key, value);
        spawnerAbstract.load(world, blockPosition, nbtTag);
        getTileEntityMobSpawner().setChanged();
        return this;
    }

    @Override
    public pt.morais.spawner.adapter.spawner.NBTSpawner setString(String key, String value) {
        CompoundTag nbtTag = new CompoundTag();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        spawnerAbstract.save(world, blockPosition, nbtTag);
        getPotentialsCompound().getCompound("Entity").putString(key, value);
        spawnerAbstract.load(world, blockPosition, nbtTag);
        getTileEntityMobSpawner().setChanged();
        return this;
    }

    @Override
    public NBTSpawner changeSpawnRate(short min, short max) {
        BlockEntity tileSpawner = getTileEntityMobSpawner();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();
        CompoundTag compound = (CompoundTag) getCompound();
        spawnerAbstract.save(world, blockPosition, compound);
        compound.putShort("MaxSpawnDelay", max);
        compound.putShort("MinSpawnDelay", min);
        tileSpawner.setChanged();
        spawnerAbstract.load(world, blockPosition, compound);
        return this;
    }

    @Override
    public CompoundTag getPotentialsCompound() {
        return (CompoundTag) ((ListTag) getList("SpawnPotentials")).get(0);
    }

    @Override
    public boolean existsKey(String key) {
        return getPotentialsCompound().getCompound("Entity").contains(key);
    }

    @Override
    public Object getList(String listName) {
        CompoundTag nbtTagCompound = new CompoundTag();
        (getAbstractMobSpawner()).save(world, blockPosition, nbtTagCompound);
        return nbtTagCompound.getList(listName, 10);
    }

    @Override
    public void removeKey(String key) {
        CompoundTag nbtTagCompound = new CompoundTag();
        (getAbstractMobSpawner()).load(world, blockPosition, nbtTagCompound);
        nbtTagCompound.remove(key);
        (getAbstractMobSpawner()).save(world, blockPosition, nbtTagCompound);
        getTileEntityMobSpawner().setChanged();
    }

    @Override
    public void setupDefaultParameters() {
        BlockEntity tileSpawner = getTileEntityMobSpawner();
        BaseSpawner spawnerAbstract = getAbstractMobSpawner();

        CompoundTag compound = (CompoundTag) getCompound();
        spawnerAbstract.save(world, blockPosition, compound);

        CompoundTag entity = new CompoundTag();
        String id = "minecraft:" + blockState.getMetadata("type").get(0).asString().toLowerCase();
        entity.putString("id", id);

        CompoundTag spawnPotentials = new CompoundTag();
        spawnPotentials.put("Entity", entity);
        spawnPotentials.putInt("Weight", 1);

        compound.put("SpawnPotentials", spawnPotentials);

        compound.putShort("SpawnCount", (short) 1);
        compound.putShort("Delay", (short) 200);
        compound.putShort("MaxSpawnDelay", (short) 800);
        compound.putShort("MinSpawnDelay", (short) 200);
        compound.putShort("SpawnRange", (short) 4);
        compound.putShort("MaxNearbyEntities", (short) 6);
        compound.putShort("RequiredPlayerRange", (short) 16);

        CompoundTag dataId = new CompoundTag();
        dataId.putString("id", id);

        compound.put("SpawnData", dataId);
        tileSpawner.setChanged();

        spawnerAbstract.load(world, blockPosition, compound);
    }

    @Override
    public void verifyVersion() {

    }

}