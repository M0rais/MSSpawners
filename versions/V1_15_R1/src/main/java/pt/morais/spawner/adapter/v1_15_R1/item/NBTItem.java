package pt.morais.spawner.adapter.v1_15_R1.item;

import net.minecraft.server.v1_15_R1.ItemStack;
import net.minecraft.server.v1_15_R1.NBTTagCompound;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;

public class NBTItem extends pt.morais.spawner.adapter.item.NBTItem {

    public NBTItem(org.bukkit.inventory.ItemStack item) {
        super(item);
    }

    @Override
    public pt.morais.spawner.adapter.item.NBTItem saveValue(String key, String value) {
        ItemStack nmsItemStack = CraftItemStack.asNMSCopy(getItem());
        NBTTagCompound compound = nmsItemStack.hasTag() ? nmsItemStack.getTag() : new NBTTagCompound();
        assert compound != null;
        compound.setString(key, value);
        nmsItemStack.setTag(compound);
        setItem(CraftItemStack.asBukkitCopy(nmsItemStack));
        return this;
    }

    @Override
    public String getValue(String key) {
        ItemStack nmsItemStack = CraftItemStack.asNMSCopy(getItem());
        NBTTagCompound compound = nmsItemStack.hasTag() ? nmsItemStack.getTag() : new NBTTagCompound();
        assert compound != null;
        return compound.hasKey(key) ? compound.getString(key) : ".";
    }

}