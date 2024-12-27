package kfestofil.kfestomod.data.provider;

import kfestofil.kfestomod.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class KfestomodItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public KfestomodItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ItemInit.KFESTOSTICK)
                .add(ItemInit.MURASAMA);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(ItemInit.MURASAMA);
        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(ItemInit.MURASAMA);
        getOrCreateTagBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .add(ItemInit.MURASAMA);
        getOrCreateTagBuilder(ItemTags.ARROWS)
                .add(ItemInit.ARROW404);
    }
}
