package kfestofil.kfestomod.init.worldgen;

import kfestofil.kfestomod.Kfestomod;
import kfestofil.kfestomod.init.BlockInit;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ConfiguredFeatureInit {
    public static final RegistryKey<ConfiguredFeature<?, ?>> OVERWORLD_DILDORE_KEY = registerKey("overworld_dildore");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneOreReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateOreReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> OverworldDildoreTargets = List.of(
                OreFeatureConfig.createTarget(stoneOreReplaceables, BlockInit.DILDORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateOreReplaceables, BlockInit.DEEPSLATE_DILDORE.getDefaultState()));

        register(context, OVERWORLD_DILDORE_KEY, Feature.ORE, new OreFeatureConfig(OverworldDildoreTargets, 4 , 0.5f));
    }

    private static RegistryKey<ConfiguredFeature<?,?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Kfestomod.id(name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                   F feature, FC featureConfig) {
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }
}
