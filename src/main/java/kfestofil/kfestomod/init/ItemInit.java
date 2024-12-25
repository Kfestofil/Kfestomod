package kfestofil.kfestomod.init;

import kfestofil.kfestomod.Item.KfestostickItem;
import kfestofil.kfestomod.Item.MurasamaItem;
import kfestofil.kfestomod.Kfestomod;
import kfestofil.kfestomod.list.FoodList;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;

public class ItemInit {

    // Item declarations
    public static final Item PISSJAR = register("piss_jar",
            new Item(createSettings("piss_jar").food(FoodList.PISSJAR_FOOD_COMPONENT, FoodList.PISSJAR_CONSUMABLE_COMPONENT)));
    public static final Item RAW_DILDIUM = register("raw_dildium", new Item(createSettings("raw_dildium")));
    public static final Item DINGOT = register("dingot", new Item(createSettings("dingot")));

    public static final Item KFESTOSTICK = register("kfesto_stick", new KfestostickItem(createSettings("kfesto_stick", new Item.Settings()
            .maxDamage(500)
            .maxCount(1)
            .repairable(ItemInit.DINGOT))));

    public static final MurasamaItem MURASAMA = register("murasama", new MurasamaItem(createSettings("murasama", new MurasamaItem.Settings()
            .maxCount(1)
            .fireproof())));

    /**
     * Registers an item with the given name and instance.
     */
    public static <T extends Item> T register(String name, T item) {
        Identifier id = Kfestomod.id(name);
        return Registry.register(Registries.ITEM, id, item);
    }

    /**
     * Registers a BlockItem with specific settings.
     */
    public static BlockItem registerBlockItem(String name, Block block, BlockItem.Settings settings) {
        Identifier id = Kfestomod.id(name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        settings.useBlockPrefixedTranslationKey().registryKey(key);
        return Registry.register(Registries.ITEM, key, new BlockItem(block, settings));
    }
    /**
     * Creates default item settings with the appropriate registry key.
     */
    public static Item.Settings createSettings(String name) {
        Identifier id = Kfestomod.id(name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        return new Item.Settings().registryKey(key);
    }

    public static Item.Settings createSettings(String name, Item.Settings settings) {
        Identifier id = Kfestomod.id(name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        return settings.registryKey(key);
    }

    /**
     * Initializes all items.
     */
    public static void init() {}
}
