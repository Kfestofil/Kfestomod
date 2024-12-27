package kfestofil.kfestomod.init;

import kfestofil.kfestomod.Network.Arrow404Payload;
import kfestofil.kfestomod.Network.MovingSoundKillPayload;
import kfestofil.kfestomod.Network.MovingSoundPayload;
import kfestofil.kfestomod.SoundPlayer.ClientMovingSoundPlayer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.FabricScreenHandlerFactory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DisconnectedScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ClientNetworkInit {
    public static void init() {
        ClientPlayNetworking.registerGlobalReceiver(MovingSoundPayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                ClientMovingSoundPlayer.playMovingSound(payload.playerID(), payload.soundID());
            });
        });
        ClientPlayNetworking.registerGlobalReceiver(MovingSoundKillPayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                ClientMovingSoundPlayer.killMovingSound(payload.playerID(), payload.soundID());
            });
        });
        ClientPlayNetworking.registerGlobalReceiver(Arrow404Payload.ID, (payload, context) -> {
            context.client().execute(() -> {
                MinecraftClient client = MinecraftClient.getInstance();
                client.world.disconnect();
                client.disconnect();
                Text reason = Text.literal("Connection lost").formatted(Formatting.WHITE);
                Text message = Text.literal("java.lang.NullPointerException: Couldn't find a PlayerEntity object with the \"name\" field value matching \"" + client.getGameProfile().getName() + "\"").formatted(Formatting.RED);
                Screen parentScreen = new MultiplayerScreen(new TitleScreen());
                client.setScreen(new DisconnectedScreen(parentScreen, reason, message));
                //client.setScreen(new TitleScreen());
            });
        });
    }
}
