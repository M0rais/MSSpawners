package pt.morais.spawner.adapter.item;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

/**
 * This is an adapter for the NBTItem version
 */
public abstract class NBTItemAdapter {

    /**
     * Returns an instance of this adapter depending on the version
     */
    @Getter @Setter
    private static NBTItemAdapter instance;

    /**
     * Returns a NBTItem from an item
     * @param item Item to be modified
     * @return NBTItem
     */
    public abstract NBTItem getNBTItem(ItemStack item);

}