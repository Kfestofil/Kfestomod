package kfestofil.kfestomod;

import kfestofil.kfestomod.data.generator.KfestomodWorldGenerator;
import kfestofil.kfestomod.data.provider.*;
import kfestofil.kfestomod.init.worldgen.ConfiguredFeatureInit;
import kfestofil.kfestomod.init.worldgen.PlacedFeatureInit;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class KfestomodDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(KfestomodModelProvider::new);
		pack.addProvider(KfestomodBlockTagsProvider::new);
		pack.addProvider(KfestomodItemTagsProvider::new);
		pack.addProvider(KfestomodWorldGenerator::new);
		pack.addProvider(KfestomodRecipeProvider::new);
		pack.addProvider(KfestomodEntityTypeTagsProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatureInit::boostrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatureInit::bootstrap);
	}
}
