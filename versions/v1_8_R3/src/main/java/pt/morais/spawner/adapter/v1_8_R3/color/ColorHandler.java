package pt.morais.spawner.adapter.v1_8_R3.color;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class ColorHandler implements pt.morais.spawner.adapter.color.ColorHandler {
    @Override
    public String apply(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }


}