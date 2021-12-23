package pt.morais.spawner.adapter.v1_16_R3.entity;

import com.google.common.collect.Sets;
import net.minecraft.server.v1_16_R3.EntityCreature;
import net.minecraft.server.v1_16_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_16_R3.PathfinderGoalSelector;
import org.bukkit.attribute.Attribute;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pt.morais.spawner.adapter.BrainEntity;

import java.lang.reflect.Field;
import java.util.Optional;

public class AIHandler implements pt.morais.spawner.adapter.mob.AIHandler {
    @Override
    public void removeAI(Entity entity) {
        if (BrainEntity.isPresent(entity.getType())) {
            Mob mob = (Mob) entity;
            mob.setAware(false);
            return;
        }

        LivingEntity livingEntity = (LivingEntity) entity;
        EntityCreature c = (EntityCreature) ((CraftEntity) livingEntity).getHandle();
        try {
            Field bField = PathfinderGoalSelector.class.getDeclaredField("d");
            bField.setAccessible(true);
            bField.set(c.goalSelector, Sets.newLinkedHashSet());
            bField.set(c.targetSelector, Sets.newLinkedHashSet());
            c.goalSelector.a(0, new PathfinderGoalFloat(c));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}