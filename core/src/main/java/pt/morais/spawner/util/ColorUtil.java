package pt.morais.spawner.util;

import pt.morais.spawner.adapter.color.ColorAdapter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class uses the ColorAdapter to format text or list of text
 */
public class ColorUtil {

    /**
     * Apply color format to string
     * @param s Text
     * @return Text formatted
     */
    public static String apply(String s, Placeholder... placeholders) {
        for (Placeholder placeholder : placeholders) s = placeholder.apply(s);
        return ColorAdapter.getInstance().getColorHandler().apply(s);
    }

    /**
     * Apply color format to list
     * @param list List of text
     * @return List of text formatted
     */
    public static List<String> apply(List<String> list, Placeholder... placeholders) {
        return list.stream().map(s -> apply(s, placeholders)).collect(Collectors.toList());
    }

}