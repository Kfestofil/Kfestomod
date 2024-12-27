package kfestofil.kfestomod;

import kfestofil.kfestomod.SoundPlayer.ClientMovingSoundPlayer;
import kfestofil.kfestomod.init.ClientEntityInit;
import kfestofil.kfestomod.init.ClientNetworkInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class KfestomodClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ClientNetworkInit.init();
		ClientEntityInit.init();
	}
}