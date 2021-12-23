package pt.morais.spawner.adapter.v1_16_R3.color;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorHandler implements pt.morais.spawner.adapter.color.ColorHandler {

    public static final Pattern HEX_PATTERN = Pattern.compile("#[a-fA-F0-9]{6}");

    public String apply(String s) {
        Matcher matcher = HEX_PATTERN.matcher(s);
        while (matcher.find()) {
            String color = s.substring(matcher.start(), matcher.end());
            s = s.replace(color, ChatColor.of(color) + "");
            matcher = HEX_PATTERN.matcher(s);
        }
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}