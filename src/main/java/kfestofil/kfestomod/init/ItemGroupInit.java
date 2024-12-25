package kfestofil.kfestomod.init;

import kfestofil.kfestomod.Kfestomod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;

import java.util.Optional;

public class ItemGroupInit {
    public static final Text KFESTOMOD_TITLE = Text.translatable("itemGroup." + Kfestomod.MOD_ID + ".kfestomod");
    public static final ItemGroup KFESTOMOD = register("kfestomod", FabricItemGroup.builder()
            .displayName(KFESTOMOD_TITLE)
            .icon(ItemInit.KFESTOSTICK::getDefaultStack)
            .entries((displayContext, entries) -> Registries.ITEM.getIds()
                    .stream()
                    .filter(key -> key.getNamespace().equals(Kfestomod.MOD_ID))
                    .map(Registries.ITEM::getOptionalValue)
                    .map(Optional::orElseThrow)
                    .forEach(entries::add))
            .build());

    public static <T extends ItemGroup> T register(String name, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, Kfestomod.id(name), itemGroup);
    }

    public static void init() {}
}
