package pt.morais.spawner.adapter.mob;

import org.bukkit.entity.Entity;

/**
 * This class handles AI related stuff
 */
public interface AIHandler {

    /**
     * This method removes the entity AI (Make the entity dumb)
     * @param entity Target entity
     */
    void removeAI(Entity entity);

}