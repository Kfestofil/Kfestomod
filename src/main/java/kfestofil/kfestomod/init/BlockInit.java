package kfestofil.kfestomod.init;

import kfestofil.kfestomod.Kfestomod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class BlockInit
{
    public static final Block DILDORE = registerWithItem("dildore", AbstractBlock.Settings.create()
            .strength(3.0f, 5.0f)
            .requiresTool());
    public static final Block DEEPSLATE_DILDORE = registerWithItem("deepslate_dildore", AbstractBlock.Settings.create()
            .strength(4.5f, 6.0f)
            .requiresTool());
    public static final Block DILDIUM_BLOCK = registerWithItem("dildium_block", AbstractBlock.Settings.create()
            .strength(5.0f, 6.0f)
            .requiresTool());

    public static Block register(String name, Block.Settings settings) {
        Identifier id = Kfestomod.id(name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        settings.registryKey(key);
        return Registry.register(Registries.BLOCK, key, new Block(settings));
    }

    public static Block registerWithItem(String name, Block.Settings Bsettings, BlockItem.Settings Isettings) {
        Block block = register(name, Bsettings);
        ItemInit.registerBlockItem(name, block, Isettings);
        return block;
    }

    public static Block registerWithItem(String name, Block.Settings Bsettings) {
        return registerWithItem(name, Bsettings, new Item.Settings());
    }

    public static AbstractBlock.Settings getDefaultSettings(RegistryKey<Block> key, Identifier id) {
        return AbstractBlock.Settings.create().registryKey(key);
    }

    public static void init() {}
}
