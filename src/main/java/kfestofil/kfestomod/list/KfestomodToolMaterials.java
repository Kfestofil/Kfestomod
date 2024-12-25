package kfestofil.kfestomod.list;

import kfestofil.kfestomod.Kfestomod;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

public class KfestomodToolMaterials {  // Not using for now
    public static final ToolMaterial DILDIUM = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2500,
        8.0f, 3.0f, 10, TagKey.of(RegistryKeys.ITEM, Kfestomod.id("dildore")));
    public static final ToolMaterial MURASAMA = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 5000,
            10.0f, 0.0f, 15, ItemTags.NETHERITE_TOOL_MATERIALS);
}
