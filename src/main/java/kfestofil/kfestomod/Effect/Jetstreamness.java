package kfestofil.kfestomod.Effect;

import kfestofil.kfestomod.Helper.SegmentedSoundHandler;
import kfestofil.kfestomod.Network.MovingSoundPayload;
import kfestofil.kfestomod.init.SoundInit;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;


public class Jetstreamness extends StatusEffect {
    public Jetstreamness(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if(entity.getWorld() instanceof ServerWorld && entity.getServer() instanceof MinecraftServer) {
            for (ServerPlayerEntity player : PlayerLookup.all(entity.getServer())) {
                ServerPlayNetworking.send(player, new MovingSoundPayload(entity.getUuid(), SoundInit.TOTIKFR.id()));
            }
        }
        super.onApplied(entity, amplifier);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
