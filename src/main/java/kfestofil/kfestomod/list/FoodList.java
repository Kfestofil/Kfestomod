package kfestofil.kfestomod.list;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.SoundEvents;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class FoodList {
    public static final FoodComponent PISSJAR_FOOD_COMPONENT = new FoodComponent.Builder()
            .nutrition(-20)
            .saturationModifier(0.0f)
            .alwaysEdible()
            .build();
    public static final ConsumableComponent PISSJAR_CONSUMABLE_COMPONENT = ConsumableComponents.drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 30, 0), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 30, 5), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 20 * 30, 0), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 30, 1), 1.0f))
            .build();

}

