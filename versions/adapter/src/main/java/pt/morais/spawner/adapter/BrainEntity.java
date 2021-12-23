package pt.morais.spawner.adapter;

import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.Arrays;
import java.util.Optional;

public enum BrainEntity {

    PIGLIN,
    PIGLIN_BRUTE,
    ZOMBIFIED_PIGLIN;

    public static boolean isPresent(EntityType type) {
        return Arrays.stream(values()).anyMatch(brainEntity -> brainEntity.name().equals(type.name()));
    }

}