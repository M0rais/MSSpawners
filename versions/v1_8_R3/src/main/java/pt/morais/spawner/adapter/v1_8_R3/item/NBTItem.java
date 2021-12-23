package pt.morais.spawner.adapter.v1_8_R3.item;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class NBTItem extends pt.morais.spawner.adapter.item.NBTItem {

    public NBTItem(ItemStack item) {
        super(item);
    }


    @Override
    public pt.morais.spawner.adapter.item.NBTItem saveValue(String key, String value) {
        net.minecraft.server.v1_8_R3.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(getItem());
        NBTTagCompound compound = nmsItemStack.hasTag() ? nmsItemStack.getTag() : new NBTTagCompound();
        compound.setString(key, value);
        nmsItemStack.setTag(compound);
        setItem(CraftItemStack.asBukkitCopy(nmsItemStack));
        return this;
    }

    @Override
    public String getValue(String key) {
        net.minecraft.server.v1_8_R3.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(getItem());
        NBTTagCompound compound = nmsItemStack.hasTag() ? nmsItemStack.getTag() : new NBTTagCompound();
        return compound.hasKey(key) ? compound.getString(key) : ".";
    }

}
