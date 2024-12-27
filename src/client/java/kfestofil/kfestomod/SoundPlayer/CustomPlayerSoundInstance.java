package kfestofil.kfestomod.SoundPlayer;

import net.minecraft.client.sound.MovingSoundInstance; import net.minecraft.client.sound.SoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import java.util.UUID;

public class CustomPlayerSoundInstance extends MovingSoundInstance {
    private final PlayerEntity player;
    private final UUID playerID;
    private final Identifier soundId;


    public CustomPlayerSoundInstance(Identifier SoundId, SoundCategory category, UUID playerID,  Boolean _repeat, float _volume) {
        super(SoundEvent.of(SoundId), category, SoundInstance.createRandom());
        this.player = MinecraftClient.getInstance().world.getPlayerByUuid(playerID);
        this.playerID = playerID;
        this.soundId = SoundId;
        if (this.player == null) {
            this.setDone();
            return;
        }
        this.repeat = _repeat;
        this.repeatDelay = 0;
        this.volume = _volume; // Set a constant volume level
        this.x = player.getX();
        this.y = player.getY();
        this.z = player.getZ();
    }

    public UUID getPlayerID() {
        return playerID;
    }

    public Identifier getSoundId() {
        return soundId;
    }

    public void kill() {
        this.setDone();
    }

    @Override
    public boolean canPlay() {
        return !this.player.isSilent();
    }

    @Override
    public boolean shouldAlwaysPlay() {
        return true;
    }

    @Override
    public void tick() {
        if (this.player.isRemoved()) {
            this.setDone();
        } else {
            this.x = player.getX();
            this.y = player.getY();
            this.z = player.getZ();

            // Ensure the volume stays constant
            this.volume = 1.0F;

            // For some reason the sounds gets quiter if you jump so I added this.
            if (this.player.isOnGround()) {
                // Adjust sound position to the player’s current position
                this.x = player.getX();
                this.y = player.getY();
                this.z = player.getZ();
            }
        }
    }
}