package pt.morais.spawner.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class returns mob information
 */
@AllArgsConstructor
@Getter
public class MobInfoDto {

    private final String name, stack, tier;

}
