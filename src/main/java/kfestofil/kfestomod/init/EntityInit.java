package kfestofil.kfestomod.init;

import kfestofil.kfestomod.Entity.Arrow404Entity;
import kfestofil.kfestomod.Kfestomod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class EntityInit {
    public static final EntityType<Arrow404Entity> ARROW404 = register("arrow404",
            EntityType.Builder.<Arrow404Entity>create(Arrow404Entity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.5F, 0.5F)
                    .eyeHeight(0.13F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(20));

    public static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> type) {
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Kfestomod.id(name));
        return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
    }

    public static void init() {
    }
}
