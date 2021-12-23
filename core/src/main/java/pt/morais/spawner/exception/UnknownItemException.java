package pt.morais.spawner.exception;

/**
 * This class is an exception for material miss format
 */
public class UnknownItemException extends RuntimeException{

    /**
     * Primary and unique constructor, handles the default message.
     * @param material Material String
     */
    public UnknownItemException(String material) {
        super("Item of '" + material + "' wasn't found, please make sure you're using a material name from the newest version (e.g: STONE or 1:0)." +
                " It's also recommended not to use magic numbers.");
    }

}