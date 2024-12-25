package kfestofil.kfestomod.data.provider;

import kfestofil.kfestomod.init.BlockInit;
import kfestofil.kfestomod.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class KfestomodRecipeProvider extends FabricRecipeProvider {
    public KfestomodRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {  // to generate smelting recipes do not use exporter anymore
                List<ItemConvertible> dildores = List.of(BlockInit.DILDORE, BlockInit.DEEPSLATE_DILDORE, ItemInit.RAW_DILDIUM);

                offerSmelting(dildores, RecipeCategory.MISC, ItemInit.DINGOT, 0.25f, 200, "dingot");
                offerBlasting(dildores, RecipeCategory.MISC, ItemInit.DINGOT, 0.25f, 100, "dingot");

                createShaped(RecipeCategory.TOOLS, ItemInit.KFESTOSTICK)
                        .input('S', Items.STICK)
                        .input('D', ItemInit.DINGOT)
                        .pattern("D")
                        .pattern("D")
                        .pattern("S")
                        .criterion(hasItem(ItemInit.DINGOT), conditionsFromItem(ItemInit.DINGOT))
                        .criterion((hasItem(Items.STICK)), conditionsFromItem(Items.STICK))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, BlockInit.DILDIUM_BLOCK)
                        .input(ItemInit.DINGOT, 9)
                        .criterion(hasItem(ItemInit.DINGOT), conditionsFromItem(ItemInit.DINGOT))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ItemInit.DINGOT, 9)
                        .input(BlockInit.DILDIUM_BLOCK)
                        .criterion(hasItem(BlockInit.DILDIUM_BLOCK), conditionsFromItem(BlockInit.DILDIUM_BLOCK))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Recipe Generator";
    }
}
