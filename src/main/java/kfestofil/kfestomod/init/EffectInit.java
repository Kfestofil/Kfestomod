package kfestofil.kfestomod.init;

import kfestofil.kfestomod.Effect.Jetstreamness;
import kfestofil.kfestomod.Kfestomod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class EffectInit {
    public static final RegistryEntry<StatusEffect> JETSTREAMNESS = register("jetstreamness", new Jetstreamness(StatusEffectCategory.BENEFICIAL, 0xFF0000)
            .addAttributeModifier(EntityAttributes.MOVEMENT_SPEED, Kfestomod.id("jetstreamness"), 0.7f,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(EntityAttributes.ATTACK_SPEED, Kfestomod.id("jetstreamness"), 0.7f,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static RegistryEntry<StatusEffect> register(String name, StatusEffect effect) {
        Identifier id = Kfestomod.id(name);
        return Registry.registerReference(Registries.STATUS_EFFECT, id, effect);
    }

    public static void init() {}
}
