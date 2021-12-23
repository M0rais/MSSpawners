package pt.morais.spawner.adapter.v1_8_R3.spawner;

import com.google.common.collect.Lists;
import net.minecraft.server.v1_8_R3.*;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;

import java.util.List;

public class NBTSpawner extends pt.morais.spawner.adapter.spawner.NBTSpawner {

    public NBTSpawner(BlockState blockState, boolean defaultParams) {
        super(blockState, defaultParams);
    }

    @Override
    public void setup() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTagCompound);
        this.compound = nbtTagCompound;
    }

    @Override
    public void removeCompound(String name) {
        MobSpawnerAbstract mobSpawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        NBTTagCompound nbtTag = new NBTTagCompound();
        mobSpawnerAbstract.b(nbtTag);

        nbtTag.remove(name);
        mobSpawnerAbstract.a(nbtTag);
    }

    @Override
    public Object getTileEntityMobSpawner() {
        Location location = blockState.getLocation();
        BlockPosition blockPos = new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        return ((CraftWorld) location.getWorld()).getHandle().getTileEntity(blockPos);
    }

    @Override
    public Object getAbstractMobSpawner() {
        return ((TileEntityMobSpawner) getTileEntityMobSpawner()).getSpawner();
    }

    @Override
    public int getInteger(String key) {
        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);
        return ((NBTTagCompound) getPotentialsCompound()).getCompound("Properties").getInt(key);
    }

    @Override
    public double getDouble(String key) {
        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);
        return ((NBTTagCompound) getPotentialsCompound()).getCompound("Properties").getDouble(key);
    }

    @Override
    public String getString(String key) {
        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);
        return ((NBTTagCompound) getPotentialsCompound()).getCompound("Properties").getString(key);
    }

    @Override
    public boolean containsKey(String list, String key) {
        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);
        NBTTagCompound compound = (NBTTagCompound) getPotentialsCompound();

        for (int i = 0; i < compound.getCompound("Properties").getList(list, 10).size(); i++) {
            if (StringUtils.substringBetween(compound.getCompound("Properties").getList(list, 10).getString(i), "\"").equals(key))
                return true;
        }
        return false;
    }

    @Override
    public void addListValue(String key, String value) {
        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);

        NBTTagList nbtTagList = ((NBTTagCompound) getPotentialsCompound()).getCompound("Properties").getList(key, 10);
        NBTTagCompound memberTag = new NBTTagCompound();
        memberTag.setString(value, value);
        nbtTagList.add(memberTag);

        spawnerAbstract.a(nbtTag);
        ((TileEntityMobSpawner) getTileEntityMobSpawner()).update();
    }

    @Override
    public void removeListValue(String listName, String key) {
        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);

        NBTTagList nbtTagList = ((NBTTagCompound) getPotentialsCompound()).getCompound("Properties").getList(listName, 10);

        for (int i = 0; i < nbtTagList.size(); i++) {
            if (StringUtils.substringBetween(nbtTagList.getString(i), "\"").equals(key)) {
                nbtTagList.a(i);
            }
        }

        spawnerAbstract.a(nbtTag);
        ((TileEntityMobSpawner) getTileEntityMobSpawner()).update();
    }

    @Override
    public boolean hasKey(String listName, String key) {
        List<String> list = Lists.newArrayList();
        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);
        NBTTagCompound compound = (NBTTagCompound) getPotentialsCompound();
        for (int i = 0; i < compound.getCompound("Properties").getList(listName, 10).size(); i++) {
            String value = compound.getCompound("Properties").getList(listName, 10).getString(i);

            if (StringUtils.substringBetween(value, "\"").equals(key)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public List<String> getAllListValues(String listName) {
        List<String> list = Lists.newArrayList();
        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);
        NBTTagCompound compound = (NBTTagCompound) getPotentialsCompound();
        for (int i = 0; i < compound.getCompound("Properties").getList(listName, 10).size(); i++) {
            String value = compound.getCompound("Properties").getList(listName, 10).getString(i);
            if (value == null) {
                continue;
            }

            list.add(StringUtils.substringBetween(value, "\""));
        }
        return list;
    }

    @Override
    public int getListSize(String listName) {
        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);
        NBTTagCompound compound = (NBTTagCompound) getPotentialsCompound();
        if (compound.getCompound("Properties").hasKey("Members")) {
            return compound.getCompound("Properties").getList(listName, 10).size();
        } else {
            return 0;
        }
    }

    @Override
    public pt.morais.spawner.adapter.spawner.NBTSpawner setNBTList(String key, String... values) {
        NBTTagList nbtTagList = new NBTTagList();
        for (String value : values) {
            NBTTagCompound valueTag = new NBTTagCompound();
            valueTag.setString(value, value);
            nbtTagList.add(valueTag);
        }

        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);

        nbtTag.getCompound("SpawnData").set(key, nbtTagList);
        ((NBTTagCompound) getPotentialsCompound()).getCompound("Properties").set(key, nbtTagList);

        spawnerAbstract.a(nbtTag);
        ((TileEntityMobSpawner) getTileEntityMobSpawner()).update();
        return this;
    }

    @Override
    public pt.morais.spawner.adapter.spawner.NBTSpawner setInteger(String key, int value) {
        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);
        ((NBTTagCompound) getPotentialsCompound()).getCompound("Properties").setInt(key, value);
        spawnerAbstract.a(nbtTag);
        ((TileEntityMobSpawner) getTileEntityMobSpawner()).update();
        return this;
    }

    @Override
    public pt.morais.spawner.adapter.spawner.NBTSpawner setDouble(String key, double value) {
        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);
        ((NBTTagCompound) getPotentialsCompound()).getCompound("Properties").setDouble(key, value);
        spawnerAbstract.a(nbtTag);
        ((TileEntityMobSpawner) getTileEntityMobSpawner()).update();
        return this;
    }

    @Override
    public pt.morais.spawner.adapter.spawner.NBTSpawner setString(String key, String value) {
        NBTTagCompound nbtTag = new NBTTagCompound();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        spawnerAbstract.b(nbtTag);
        ((NBTTagCompound) getPotentialsCompound()).getCompound("Properties").setString(key, value);
        spawnerAbstract.a(nbtTag);
        ((TileEntityMobSpawner) getTileEntityMobSpawner()).update();
        return this;
    }

    @Override
    public NBTSpawner changeSpawnRate(short min, short max) {
        TileEntityMobSpawner tileSpawner = (TileEntityMobSpawner) getTileEntityMobSpawner();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();
        NBTTagCompound compound = (NBTTagCompound) getCompound();
        spawnerAbstract.b(compound);
        compound.setShort("MaxSpawnDelay", max);
        compound.setShort("MinSpawnDelay", min);
        tileSpawner.update();
        spawnerAbstract.a(compound);
        return this;
    }

    @Override
    public Object getPotentialsCompound() {
        return ((NBTTagList) getList("SpawnPotentials")).get(0);
    }

    @Override
    public boolean existsKey(String key) {
        return ((NBTTagCompound) getPotentialsCompound()).getCompound("Properties").hasKey(key);
    }

    @Override
    public Object getList(String listName) {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        ((MobSpawnerAbstract) getAbstractMobSpawner()).b(nbtTagCompound);
        return nbtTagCompound.getList(listName, 10);
    }

    @Override
    public void removeKey(String key) {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        ((MobSpawnerAbstract) getAbstractMobSpawner()).b(nbtTagCompound);
        nbtTagCompound.remove(key);
        ((MobSpawnerAbstract) getAbstractMobSpawner()).a(nbtTagCompound);
        ((TileEntityMobSpawner) getTileEntityMobSpawner()).update();
    }

    @Override
    public void setupDefaultParameters() {
        TileEntityMobSpawner tileSpawner = (TileEntityMobSpawner) getTileEntityMobSpawner();
        MobSpawnerAbstract spawnerAbstract = (MobSpawnerAbstract) getAbstractMobSpawner();

        NBTTagCompound compound = (NBTTagCompound) getCompound();
        spawnerAbstract.b(compound);

        NBTTagCompound entity = new NBTTagCompound();
        String id = "minecraft:" + blockState.getMetadata("type").get(0).asString().toLowerCase();
        entity.setString("id", id);

        NBTTagCompound spawnPotentials = new NBTTagCompound();
        spawnPotentials.set("Entity", entity);
        spawnPotentials.setInt("Weight", 1);

        compound.set("SpawnPotentials", spawnPotentials);

        compound.setShort("SpawnCount", (short) 1);
        compound.setShort("Delay", (short) 200);
        compound.setShort("MaxSpawnDelay", (short) 800);
        compound.setShort("MinSpawnDelay", (short) 200);
        compound.setShort("SpawnRange", (short) 4);
        compound.setShort("MaxNearbyEntities", (short) 6);
        compound.setShort("RequiredPlayerRange", (short) 16);

        NBTTagCompound dataId = new NBTTagCompound();
        dataId.setString("id", id);

        compound.set("SpawnData", dataId);
        tileSpawner.update();

        spawnerAbstract.a(compound);
    }

    @Override
    public void verifyVersion() {
        MobSpawnerAbstract a;
    }

}