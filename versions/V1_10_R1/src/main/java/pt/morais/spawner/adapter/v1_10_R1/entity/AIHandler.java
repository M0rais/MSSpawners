package pt.morais.spawner.adapter.v1_10_R1.entity;


import com.google.common.collect.Sets;
import net.minecraft.server.v1_10_R1.EntityCreature;
import net.minecraft.server.v1_10_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_10_R1.PathfinderGoalSelector;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import java.lang.reflect.Field;

public class AIHandler implements pt.morais.spawner.adapter.mob.AIHandler {
    @Override
    public void removeAI(Entity entity) {
        LivingEntity livingEntity = (LivingEntity) entity;
        EntityCreature c = (EntityCreature) ((CraftEntity) livingEntity).getHandle();
        try {
            Field bField = PathfinderGoalSelector.class.getDeclaredField("b");
            bField.setAccessible(true);
            Field cField = PathfinderGoalSelector.class.getDeclaredField("c");
            cField.setAccessible(true);
            bField.set(c.goalSelector, Sets.newLinkedHashSet());
            bField.set(c.targetSelector, Sets.newLinkedHashSet());
            cField.set(c.goalSelector, Sets.newLinkedHashSet());
            cField.set(c.targetSelector, Sets.newLinkedHashSet());
            c.goalSelector.a(0, new PathfinderGoalFloat(c));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}