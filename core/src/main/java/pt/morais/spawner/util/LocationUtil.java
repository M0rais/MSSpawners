package pt.morais.spawner.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 * This class handles the location serializing and deserializing
 */
public class LocationUtil {

    /**
     * Turns location to a serialized string
     * @param location Target Location
     * @return Text Location
     */
    public static String apply(Location location) {
        return location.getWorld().toString() + ":" + location.getX() + ":" + location.getY() + ":" + location.getZ();
    }

    /**
     * Turns string to a deserialized location
     * @param location Target String
     * @return Location
     */
    public static Location apply(String location) {
        String[] split = location.split(":");
        return new Location(Bukkit.getWorld(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]));
    }


}
