package pt.morais.spawner.adapter.mob;

import lombok.Getter;
import lombok.Setter;

public abstract class AIHandlerAdapter {

    @Getter
    private final AIHandler aiHandler;

    @Getter @Setter
    private static AIHandlerAdapter instance;

    public AIHandlerAdapter(AIHandler aiHandler) {
        this.aiHandler = aiHandler;
    }

}