package kfestofil.kfestomod.SoundPlayer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClientMovingSoundPlayer {
    private static final List<CustomPlayerSoundInstance> soundInstances = new ArrayList<>();

    public static void playMovingSound(UUID playerID, Identifier soundID) {
        MinecraftClient client = MinecraftClient.getInstance();
        CustomPlayerSoundInstance soundInstance = new CustomPlayerSoundInstance(soundID, SoundCategory.PLAYERS, playerID,
                false, 1f);
        soundInstances.add(soundInstance);
        client.getSoundManager().play(soundInstance);
    }
    public static void killMovingSound(UUID playerID, Identifier soundID) {
        for (CustomPlayerSoundInstance soundInstance : soundInstances) {
            if (soundInstance.getPlayerID().equals(playerID) && soundInstance.getId().equals(soundID)) {
                soundInstance.kill();
            }
        }
    }
}
