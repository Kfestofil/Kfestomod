package kfestofil.kfestomod.Helper;

import kfestofil.kfestomod.Kfestomod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.Timer;
import java.util.TimerTask;

public class SegmentedSoundHandler {
    private static final int SEGMENT_COUNT = 145; // Total sound segments
    private static final String SOUND_PREFIX = "totikfr_"; // Prefix for sound files
    private static Timer timer;
    private static int currentSegment = 0;

    public static void playSegmentedSound(LivingEntity player) {
        // If a sound is already playing, stop it before starting again
        if (timer != null) {
            timer.cancel();
        }

        // Reset current segment
        currentSegment = 0;

        // Create a new timer for the segmented sound playback
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // If all segments have been played, stop the timer
                if (currentSegment >= SEGMENT_COUNT) {
                    timer.cancel();
                    return;
                }

                // Create the sound identifier for the current segment
                Identifier soundId = Kfestomod.id( SOUND_PREFIX + String.format("%03d", currentSegment));
                SoundEvent soundEvent = SoundEvent.of(soundId);

                // Play the current segment at the player's position
                player.getWorld().playSound(
                        null, // null source means the sound is played to everyone around the player
                        player.getBlockPos(), // Player's position
                        soundEvent,
                        SoundCategory.MUSIC, // Sound category
                        1.0f, // Volume
                        1.0f  // Pitch
                );

                // Move to the next segment
                currentSegment++;
            }
        }, 0, 1000); // Delay of 0 milliseconds, then repeat every 1000 milliseconds (1 second)
    }

    public static void stopSegmentedSound() {
        // Stop any ongoing sound playback
        if (timer != null) {
            timer.cancel();
        }
    }
}
