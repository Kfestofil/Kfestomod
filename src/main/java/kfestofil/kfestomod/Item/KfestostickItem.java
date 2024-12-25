package kfestofil.kfestomod.Item;

import kfestofil.kfestomod.init.ItemInit;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.EntityEffectParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.command.ParticleCommand;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class KfestostickItem extends Item {

    public KfestostickItem(Settings settings) {
        super(settings);
    }

    /**
     * Trigger breeding behavior when right-clicked on an animal.
     */

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        // Check if the entity is an animal
        if (user.getWorld().isClient()) {
            return ActionResult.PASS;
        }
        if (entity instanceof AnimalEntity animal) {
            // Only trigger if the animal is not already in love
            if (animal.getBreedingAge() == 0) {
               /* animal.lovePlayer(user); // Trigger the breeding state
                stack.damage(1, user); // Damage the item
                return ActionResult.SUCCESS; // Action succeeded*/
                animal.lovePlayer(user);
                animal.resetLoveTicks();
                ServerWorld world  = (ServerWorld) user.getWorld();
                AnimalEntity child = (AnimalEntity) animal.createChild(world, animal);
                if (child != null) {
                    child.setBaby(true); // Set the child as a baby

                    // Set the child's position
                    child.setPosition((animal.getX() + user.getX())/ 2.0d, Math.max(animal.getY(), user.getY()),
                            (animal.getZ() + user.getZ())/ 2.0d);

                    // Spawn the child
                    world.spawnEntity(child);

                    world.spawnParticles(ParticleTypes.HEART, user.getX(), user.getY() + 1, user.getZ(),
                            7, 0.5, 0.25, 0.5, 0.1);

                    animal.setBreedingAge(20 * 300); // Set breeding cooldown

                    // Consume item durability or count
                    stack.damage(1, user);

                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.FAIL; // Failed (either not an animal or already in love)
    }
}
