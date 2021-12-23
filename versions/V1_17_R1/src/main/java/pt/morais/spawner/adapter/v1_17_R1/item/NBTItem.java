package pt.morais.spawner.adapter.v1_17_R1.item;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;

public class NBTItem extends pt.morais.spawner.adapter.item.NBTItem {

    public NBTItem(org.bukkit.inventory.ItemStack item) {
        super(item);
    }

    @Override
    public pt.morais.spawner.adapter.item.NBTItem saveValue(String key, String value) {
        ItemStack nmsItemStack = CraftItemStack.asNMSCopy(getItem());
        CompoundTag compound = nmsItemStack.hasTag() ? nmsItemStack.getTag() : new CompoundTag();
        assert compound != null;
        compound.putString(key, value);
        nmsItemStack.setTag(compound);
        setItem(CraftItemStack.asBukkitCopy(nmsItemStack));
        return this;
    }

    @Override
    public String getValue(String key) {
        ItemStack nmsItemStack = CraftItemStack.asNMSCopy(getItem());
        CompoundTag compound = nmsItemStack.hasTag() ? nmsItemStack.getTag() : new CompoundTag();
        assert compound != null;
        return compound.contains(key) ? compound.getString(key) : ".";
    }

}