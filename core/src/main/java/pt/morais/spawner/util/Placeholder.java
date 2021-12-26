package pt.morais.spawner.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Class to handle placeholders
 */
@Getter
@AllArgsConstructor
public class Placeholder {

    private final String key;
    private final Object value;

    /**
     * This method changes the key by the value
     * @param s Text
     * @return Text with placeholders
     */
    public String apply(String s) {
        return s.replace(key, value.toString());
    }

}