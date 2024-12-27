package kfestofil.kfestomod.data.provider;

import kfestofil.kfestomod.init.EntityInit;
import kfestofil.kfestomod.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class KfestomodEntityTypeTagsProvider extends FabricTagProvider.EntityTypeTagProvider{
    public KfestomodEntityTypeTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(EntityTypeTags.ARROWS)
                .add(EntityInit.ARROW404);
    }
}
