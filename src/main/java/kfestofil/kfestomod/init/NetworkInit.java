package kfestofil.kfestomod.init;

import kfestofil.kfestomod.Network.MovingSoundPayload;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class NetworkInit {
        public static void init() {
                PayloadTypeRegistry.playS2C().register(MovingSoundPayload.ID, MovingSoundPayload.CODEC);
        }
}
