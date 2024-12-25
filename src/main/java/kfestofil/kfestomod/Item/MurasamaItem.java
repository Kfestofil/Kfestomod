package kfestofil.kfestomod.Item;

import kfestofil.kfestomod.Kfestomod;
import kfestofil.kfestomod.init.EffectInit;
import kfestofil.kfestomod.list.KfestomodToolMaterials;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class MurasamaItem extends SwordItem {
    //all the commented code in this class is my hopes and dreams right there

    private static final int MAX_CHARGE_TIME = 60; // Max charge time in ticks (3 seconds)


    public MurasamaItem(Settings settings) {
        super(KfestomodToolMaterials.MURASAMA, 11, -2.4f, settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (user.hasStatusEffect(EffectInit.JETSTREAMNESS)) {
            return ActionResult.FAIL;
        }
        user.setCurrentHand(hand);
        return ActionResult.PASS;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.addStatusEffect(new StatusEffectInstance(EffectInit.JETSTREAMNESS, 200, 0)); // Speed II for 10 seconds
        return stack;
//        Kfestomod.LOGGER.info("Finish using1");
//        setChargeTime(stack, 0); // Reset charge time
//        int chargeTime = getChargeTime(stack);
//
//        if (chargeTime >= MAX_CHARGE_TIME) {
//            if (!world.isClient()) {
//                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 1)); // Speed II for 10 seconds
//                setChargeTime(stack, 0); // Reset charge time
//            }
//        }
//        Kfestomod.LOGGER.info("Finish using2");
    }
  /*  @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient()) {
            setChargeTime(stack, 0); // Reset charge time
        }
        return false;
    }*/


    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (world.isClient())
        {
            double vx = world.random.nextDouble() - 0.5;
            double vy = world.random.nextDouble() - 0.5;
            double vz = world.random.nextDouble() - 0.5;
            world.addParticle(ParticleTypes.FLAME, user.getX(), user.getY()+1, user.getZ(), vx, vy, vz);
        }
        if (user.hasStatusEffect(EffectInit.JETSTREAMNESS)) {

        }
//        int chargeTime = getChargeTime(stack);
//        chargeTime++;
//        setChargeTime(stack, chargeTime);
//
//        if (chargeTime >= MAX_CHARGE_TIME) {
//            Kfestomod.LOGGER.info("Apply Effect1");
//            if (!world.isClient()) {
//                user.stopUsingItem();
//                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 1)); // Speed II for 10 seconds
//                setChargeTime(stack, 0); // Reset charge time
//            }
//            Kfestomod.LOGGER.info("Apply Effect2");
//        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return MAX_CHARGE_TIME;
    }

   /* // Get charge time using the component system
    private int getChargeTime(ItemStack stack) {
        NbtComponent customDataComponent = stack.getComponents().get(DataComponentTypes.CUSTOM_DATA);
        if (customDataComponent instanceof NbtComponent) {
            NbtCompound nbt = customDataComponent.copyNbt();
            return nbt.getInt("charge_time");
        }
        else {
            return 0;
        }
    }

    // Set charge time using the component system
    private void setChargeTime(ItemStack stack, int chargeTime) {
        NbtCompound nbt = new NbtCompound();
        nbt.putInt("charge_time", chargeTime);
        NbtComponent component = NbtComponent.of(nbt);
        stack.set(DataComponentTypes.CUSTOM_DATA, component);
    }*/
}
