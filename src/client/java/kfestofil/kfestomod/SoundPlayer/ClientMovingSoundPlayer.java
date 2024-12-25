package kfestofil.kfestomod.SoundPlayer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.UUID;

public class ClientMovingSoundPlayer {
    public static void playMovingSound(UUID playerID, Identifier soundID) {
        MinecraftClient client = MinecraftClient.getInstance();
        World world = client.world;
        client.getSoundManager().play(new CustomPlayerSoundInstance(soundID, SoundCategory.PLAYERS, playerID,
                false, 1f));
    }
}
