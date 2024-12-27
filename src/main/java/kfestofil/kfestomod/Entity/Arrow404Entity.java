package kfestofil.kfestomod.Entity;

import kfestofil.kfestomod.Network.Arrow404Payload;
import kfestofil.kfestomod.init.EntityInit;
import kfestofil.kfestomod.init.ItemInit;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.DisconnectionInfo;
import net.minecraft.particle.EntityEffectParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Arrow404Entity extends PersistentProjectileEntity {

    public Arrow404Entity(EntityType<? extends Arrow404Entity> entityType, World world) {
        super(entityType, world);
    }

    public Arrow404Entity(World world, double x, double y, double z, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(EntityInit.ARROW404, x, y, z, world, stack, shotFrom);
    }

    public Arrow404Entity(World world, LivingEntity owner, ItemStack stack, @Nullable ItemStack shotFrom) {
        super(EntityInit.ARROW404, owner, world, stack, shotFrom);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity target = entityHitResult.getEntity();
        World world = target.getWorld();
        if (target instanceof ServerPlayerEntity)
        {
            DamageSource damageSource = this.getDamageSources().arrow(this, this);
            target.damage((ServerWorld) world, damageSource, 0.0f);
            ServerPlayNetworking.send((ServerPlayerEntity) target, new Arrow404Payload(true));
        }
        else
        {
            if (world instanceof ServerWorld)
            {
                DamageSource damageSource = this.getDamageSources().arrow(this, this);
                target.damage((ServerWorld) world, damageSource, 0.0f);
                target.discard();
//                target.setPos(target.getX(), world.getBottomY() - 50, target.getZ());
//                target.remove(RemovalReason.KILLED);
//                target.kill((ServerWorld) world);
            }
        }
        this.discard();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            if (this.isInGround()) {
                if (this.inGroundTime % 5 == 0) {
                    //this.spawnParticles(1);
                }
            } else {
                //this.spawnParticles(2);
            }
        } else if (this.isInGround() && this.inGroundTime != 0 && this.inGroundTime >= 600) {
            this.getWorld().sendEntityStatus(this, (byte)0);
        }
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ItemInit.ARROW404);
    }
}
