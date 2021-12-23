package pt.morais.spawner.adapter.color;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class controls the colors from a string and list of strings
 */
public interface ColorHandler {

    /**
     * Apply color format to string
     * @param s Text
     * @return Text formatted
     */
    String apply(String s);

    /**
     * Apply color format to list
     * @param list List of text
     * @return List of text formatted
     */
    default List<String> apply(List<String> list) {
        return list.stream().map(this::apply).collect(Collectors.toList());
    }

}