package kfestofil.kfestomod.Network;

import kfestofil.kfestomod.Kfestomod;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.Uuids;
import java.util.UUID;

public record MovingSoundPayload(UUID playerID, Identifier soundID) implements CustomPayload {
    public static final CustomPayload.Id<MovingSoundPayload> ID = new CustomPayload.Id<>(Kfestomod.id("moving_sound_packet"));
    public static final PacketCodec<RegistryByteBuf, MovingSoundPayload> CODEC = PacketCodec.tuple(
            Uuids.PACKET_CODEC, MovingSoundPayload::playerID,
            Identifier.PACKET_CODEC, MovingSoundPayload::soundID,
            MovingSoundPayload::new);


    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
