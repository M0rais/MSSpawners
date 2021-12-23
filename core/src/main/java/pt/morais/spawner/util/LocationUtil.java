package pt.morais.spawner.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationUtil {

    public static String apply(Location location) {
        return location.getWorld().toString() + ":" + location.getX() + ":" + location.getY() + ":" + location.getZ();
    }

    public static Location apply(String location) {
        String[] split = location.split(":");
        return new Location(Bukkit.getWorld(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]));
    }


}
