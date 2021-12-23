package pt.morais.spawner.adapter.v1_18_R1.entity;

import com.google.common.collect.Sets;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import org.bukkit.craftbukkit.v1_18_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import java.lang.reflect.Field;

public class AIHandler implements pt.morais.spawner.adapter.mob.AIHandler {
    @Override
    public void removeAI(Entity entity) {
        LivingEntity livingEntity = (LivingEntity) entity;
        PathfinderMob c = (PathfinderMob) ((CraftEntity) livingEntity).getHandle();
        try {
            Field bField = GoalSelector.class.getDeclaredField("availableGoals");
            bField.setAccessible(true);
            bField.set(c.goalSelector, Sets.newLinkedHashSet());
            bField.set(c.targetSelector, Sets.newLinkedHashSet());
            c.goalSelector.addGoal(0, new FloatGoal(c));
            c.targetSelector.addGoal(0, new FloatGoal(c));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}