package pt.morais.spawner.adapter.v1_16_R3.item;

import org.bukkit.inventory.ItemStack;
import pt.morais.spawner.adapter.item.NBTItem;

public class NBTItemAdapter extends pt.morais.spawner.adapter.item.NBTItemAdapter {
    @Override
    public NBTItem getNBTItem(ItemStack item) {
        return new pt.morais.spawner.adapter.v1_16_R3.item.NBTItem(item);
    }
}
