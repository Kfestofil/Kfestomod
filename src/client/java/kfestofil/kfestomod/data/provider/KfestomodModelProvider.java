package kfestofil.kfestomod.data.provider;

import kfestofil.kfestomod.init.BlockInit;
import kfestofil.kfestomod.init.ItemInit;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class KfestomodModelProvider extends FabricModelProvider {
    public KfestomodModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.DILDORE);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.DEEPSLATE_DILDORE);
        blockStateModelGenerator.registerSimpleCubeAll(BlockInit.DILDIUM_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ItemInit.KFESTOSTICK, Models.HANDHELD);
        itemModelGenerator.register(ItemInit.DINGOT, Models.GENERATED);
        itemModelGenerator.register(ItemInit.PISSJAR, Models.GENERATED);
        itemModelGenerator.register(ItemInit.RAW_DILDIUM, Models.GENERATED);
    }
}
