package kfestofil.kfestomod.Network;

import kfestofil.kfestomod.Kfestomod;
import net.minecraft.enchantment.provider.ByCostEnchantmentProvider;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;

public record Arrow404Payload(Boolean b) implements CustomPayload {
    public static final CustomPayload.Id<Arrow404Payload> ID = new CustomPayload.Id<>(Kfestomod.id("arrow_404_packet"));
    public static final PacketCodec<RegistryByteBuf, Arrow404Payload> CODEC = PacketCodec.tuple(PacketCodecs.BOOLEAN, Arrow404Payload::b, Arrow404Payload::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
