package kfestofil.kfestomod.init;

import kfestofil.kfestomod.Network.Arrow404Payload;
import kfestofil.kfestomod.Network.MovingSoundKillPayload;
import kfestofil.kfestomod.Network.MovingSoundPayload;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;

public class NetworkInit {
        public static void init() {
                PayloadTypeRegistry.playS2C().register(MovingSoundPayload.ID, MovingSoundPayload.CODEC);
                PayloadTypeRegistry.playS2C().register(MovingSoundKillPayload.ID, MovingSoundKillPayload.CODEC);
                PayloadTypeRegistry.playS2C().register(Arrow404Payload.ID, Arrow404Payload.CODEC);
        }
}
