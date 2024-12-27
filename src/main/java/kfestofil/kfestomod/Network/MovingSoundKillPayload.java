package kfestofil.kfestomod.Network;

import kfestofil.kfestomod.Kfestomod;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.Uuids;
import java.util.UUID;

public record MovingSoundKillPayload(UUID playerID, Identifier soundID) implements CustomPayload {
    public static final CustomPayload.Id<MovingSoundKillPayload> ID = new CustomPayload.Id<>(Kfestomod.id("moving_sound_kill_packet"));
    public static final PacketCodec<RegistryByteBuf, MovingSoundKillPayload> CODEC = PacketCodec.tuple(
            Uuids.PACKET_CODEC, MovingSoundKillPayload::playerID,
            Identifier.PACKET_CODEC, MovingSoundKillPayload::soundID,
            MovingSoundKillPayload::new);


    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
