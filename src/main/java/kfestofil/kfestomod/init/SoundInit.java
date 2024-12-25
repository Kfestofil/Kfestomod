package kfestofil.kfestomod.init;

import kfestofil.kfestomod.Kfestomod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.stream.IntStream;

public class SoundInit {
    public static final SoundEvent TOTIKFR = register("totikfr"); // Register the jetstream sound

//    private static final int JETSTREAM_SEGMENTS = 145;
//    private static final String SOUND_PREFIX = "totikfr_";
//
//    // Register all sound segments dynamically
//    public static void registerSoundSegments() {
//        // Loop through the segment count and register each sound
//        IntStream.range(0, JETSTREAM_SEGMENTS).forEach(i -> {
//            String soundName = SOUND_PREFIX + String.format("%03d", i); // Generate the filename (e.g., output000, output001, etc.)
//            register(soundName);
//        });
//    }

    public static SoundEvent register(String name) {
        Identifier id = Kfestomod.id(name); // Create the Identifier for the sound
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id)); // Register the sound event
    }

    public static void init() {
        //registerSoundSegments(); // Call the method to register all sound segments
    }
}
