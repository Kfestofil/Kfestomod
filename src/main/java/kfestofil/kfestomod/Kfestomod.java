package kfestofil.kfestomod;

import kfestofil.kfestomod.init.*;
import kfestofil.kfestomod.init.worldgen.BiomeModificationInit;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kfestomod implements ModInitializer {
	public static final String MOD_ID = "kfestomod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Kfestomod is initializing...");
		ItemInit.init();
		BlockInit.init();
		ItemGroupInit.init();
		BiomeModificationInit.init();
		EffectInit.init();
		SoundInit.init();
		NetworkInit.init();
		EntityInit.init();

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.addAfter(Items.RAW_GOLD, ItemInit.RAW_DILDIUM);
			entries.addAfter(Items.GOLD_INGOT, ItemInit.DINGOT);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
			entries.addAfter(Items.MILK_BUCKET, ItemInit.PISSJAR);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
			entries.addAfter(Items.DEEPSLATE_DIAMOND_ORE, BlockInit.DILDORE);
			entries.addAfter(BlockInit.DILDORE, BlockInit.DEEPSLATE_DILDORE);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
			entries.addAfter(Items.DIAMOND_BLOCK, BlockInit.DILDIUM_BLOCK);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
			entries.addBefore(Items.FISHING_ROD, ItemInit.KFESTOSTICK);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
			entries.addAfter(Items.NETHERITE_SWORD, ItemInit.MURASAMA);
			entries.addAfter(Items.ARROW, ItemInit.ARROW404);
		});

		LOGGER.info("Kfestomod initialized!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}