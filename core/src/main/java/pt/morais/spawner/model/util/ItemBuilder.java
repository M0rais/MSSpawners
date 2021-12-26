package pt.morais.spawner.model.util;

import com.cryptomorin.xseries.XMaterial;
import lombok.Getter;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pt.morais.spawner.adapter.item.NBTItem;
import pt.morais.spawner.adapter.item.NBTItemAdapter;
import pt.morais.spawner.exception.UnknownItemException;
import pt.morais.spawner.util.ColorUtil;
import pt.morais.spawner.util.Placeholder;

import java.util.List;
import java.util.Optional;

/**
 * This class is an easy way to create ItemStacks with custom attributes, flags, names, etc.
 */
@Getter
public class ItemBuilder {

    private ItemStack item;

    /**
     * Primary constructor
     * @param item Target Item
     */
    public ItemBuilder(ItemStack item) {
        this.item = item;
    }

    /**
     * Secondary constructor
     * @param material Material String
     */
    public ItemBuilder(String material) {
        Optional<XMaterial> xMaterial = XMaterial.matchXMaterial(material);
        if (!xMaterial.isPresent()) throw new UnknownItemException(material);
        this.item = xMaterial.get().parseItem();
    }

    /**
     * This method defines the amount
     * @param amount Item amount
     * @return ItemBuilder
     */
    public ItemBuilder amount(int amount) {
        item.setAmount(amount);
        return this;
    }

    /**
     * This method sets a name to the item
     * @param s Name
     * @param placeholders Placeholders for the name
     * @return ItemBuilder
     */
    public ItemBuilder name(String s, Placeholder... placeholders) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtil.apply(s, placeholders));
        item.setItemMeta(meta);
        return this;
    }

    /**
     * This method sets a lore to the item
     * @param list Lore
     * @param placeholders Placeholders for the lore
     * @return ItemBuilder
     */
    public ItemBuilder lore(List<String> list, Placeholder... placeholders) {
        ItemMeta meta = item.getItemMeta();
        meta.setLore(ColorUtil.apply(list, placeholders));
        item.setItemMeta(meta);
        return this;
    }

    /**
     * This method removes every attribute
     * @return ItemBuilder
     */
    public ItemBuilder hideAttributes() {
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.values());
        item.setItemMeta(meta);
        return this;
    }

    /**
     * This method removes every attribute
     * @param b Remove
     * @return ItemBuilder
     */
    public ItemBuilder hideAttributes(boolean b) {
        return b ? hideAttributes() : this;
    }

    /**
     * This method add flags to the item
     * @param flags Flags
     * @return ItemBuilder
     */
    public ItemBuilder addFlags(ItemFlag... flags) {
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(flags);
        item.setItemMeta(meta);
        return this;
    }

    /**
     * This method remove flags from the item
     * @param flags Flags
     * @return ItemBuilder
     */
    public ItemBuilder removeFlags(ItemFlag... flags) {
        ItemMeta meta = item.getItemMeta();
        meta.removeItemFlags(flags);
        item.setItemMeta(meta);
        return this;
    }

    /**
     * This method adds a string nbt tag to the item
     * @param key Nbt tag key
     * @param value Nbt tag value
     * @return ItemBuilder
     */
    public ItemBuilder addNBTTag(String key, String value) {
        NBTItem nbtItem = NBTItemAdapter.getInstance().getNBTItem(item);
        nbtItem.saveValue(key, value);
        this.item = nbtItem.getItem();
        return this;
    }

    /**
     * This method adds a int nbt tag to the item
     * @param key Nbt tag key
     * @param value Nbt tag value
     * @return ItemBuilder
     */
    public ItemBuilder addNBTTag(String key, int value) {
        NBTItem nbtItem = NBTItemAdapter.getInstance().getNBTItem(item);
        nbtItem.saveValue(key, value);
        this.item = nbtItem.getItem();
        return this;
    }

    /**
     * Returns a string from the nbt key
     * @param key Nbt tag key
     * @return String
     */
    public String getNBTTag(String key) {
        return NBTItemAdapter.getInstance().getNBTItem(item).getValue(key);
    }

    /**
     * Returns a int from the nbt key
     * @param key Nbt tag key
     * @return String
     */
    public int getIntNBTTag(String key) {
        return NBTItemAdapter.getInstance().getNBTItem(item).getIntValue(key);
    }

}