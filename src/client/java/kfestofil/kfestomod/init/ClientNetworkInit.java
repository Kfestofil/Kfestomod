package kfestofil.kfestomod.init;

import kfestofil.kfestomod.Network.MovingSoundPayload;
import kfestofil.kfestomod.SoundPlayer.ClientMovingSoundPlayer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class ClientNetworkInit {
    public static void init() {
        ClientPlayNetworking.registerGlobalReceiver(MovingSoundPayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                ClientMovingSoundPlayer.playMovingSound(payload.playerID(), payload.soundID());
            });
        });
    }
}
