package pt.morais.spawner.adapter.color;

import lombok.Getter;
import lombok.Setter;

/**
 * Class that handles the ColorHandler version
 */
public abstract class ColorAdapter {

    @Getter
    private final ColorHandler colorHandler;

    @Getter
    @Setter
    private static ColorAdapter instance;

    /**
     * Primary constructor
     * @param colorHandler Target ColorHandler
     */
    public ColorAdapter(ColorHandler colorHandler) {
        this.colorHandler = colorHandler;
    }

}
