package pt.morais.spawner.adapter.mob;

import lombok.Getter;
import lombok.Setter;

/**
 * Class that handles the AIHandler version
 */
public abstract class AIHandlerAdapter {

    @Getter
    private final AIHandler aiHandler;

    @Getter @Setter
    private static AIHandlerAdapter instance;

    /**
     * Primary constructor
     * @param aiHandler Target AIHandler
     */
    public AIHandlerAdapter(AIHandler aiHandler) {
        this.aiHandler = aiHandler;
    }

}