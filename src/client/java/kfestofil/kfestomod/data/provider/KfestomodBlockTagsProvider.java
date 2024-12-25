package kfestofil.kfestomod.data.provider;

import kfestofil.kfestomod.init.BlockInit;
import kfestofil.kfestomod.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class KfestomodBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public KfestomodBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockInit.DILDORE)
                .add(BlockInit.DEEPSLATE_DILDORE)
                .add(BlockInit.DILDIUM_BLOCK);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(BlockInit.DILDORE)
                .add(BlockInit.DEEPSLATE_DILDORE)
                .add(BlockInit.DILDIUM_BLOCK);
    }
}
