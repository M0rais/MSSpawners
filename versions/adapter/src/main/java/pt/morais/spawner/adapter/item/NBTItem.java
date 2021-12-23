package pt.morais.spawner.adapter.item;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

/**
 * Class that changes the nbt tags inside an item
 */
public abstract class NBTItem {

    @Getter
    @Setter
    private ItemStack item;

    /**
     * Primary constructor
     * @param item Item to be edited
     */
    public NBTItem(ItemStack item) {
        this.item = item.clone();
    }

    /**
     * Save a value to the nbtitem
     * @param key Nbt tag key
     * @param value Nbt tag value
     * @return NBTItem
     */
    public abstract NBTItem saveValue(String key, String value);

    /**
     * Returns a string from a key
     * @param key Nbt tag key
     * @return Value
     */
    public abstract String getValue(String key);

}
