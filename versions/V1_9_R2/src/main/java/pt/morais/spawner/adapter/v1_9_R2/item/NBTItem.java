package pt.morais.spawner.adapter.v1_9_R2.item;

import net.minecraft.server.v1_9_R2.ItemStack;
import net.minecraft.server.v1_9_R2.NBTTagCompound;
import org.bukkit.craftbukkit.v1_9_R2.inventory.CraftItemStack;

public class NBTItem extends pt.morais.spawner.adapter.item.NBTItem {

    public NBTItem(org.bukkit.inventory.ItemStack item) {
        super(item);
    }

    @Override
    public pt.morais.spawner.adapter.item.NBTItem saveValue(String key, String value) {
        ItemStack nmsItemStack = CraftItemStack.asNMSCopy(getItem());
        NBTTagCompound compound = nmsItemStack.hasTag() ? nmsItemStack.getTag() : new NBTTagCompound();
        compound.setString(key, value);
        nmsItemStack.setTag(compound);
        setItem(CraftItemStack.asBukkitCopy(nmsItemStack));
        return this;
    }

    @Override
    public String getValue(String key) {
        ItemStack nmsItemStack = CraftItemStack.asNMSCopy(getItem());
        NBTTagCompound compound = nmsItemStack.hasTag() ? nmsItemStack.getTag() : new NBTTagCompound();
        return compound.hasKey(key) ? compound.getString(key) : ".";
    }

}