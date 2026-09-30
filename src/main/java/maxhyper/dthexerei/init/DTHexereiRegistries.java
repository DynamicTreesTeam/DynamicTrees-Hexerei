package maxhyper.dthexerei.init;

import com.dtteam.dynamictrees.api.worldgen.FeatureCanceller;
import com.dtteam.dynamictrees.event.RegistryEvent;
import com.dtteam.dynamictrees.worldgen.featurecancellation.TreeFeatureCanceller;
import maxhyper.dthexerei.DynamicTreesHexerei;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = DynamicTreesHexerei.MOD_ID)
public class DTHexereiRegistries {

    /**
     * Cancels Hexerei's tree configured features (hexerei:willow_tree, hexerei:mahogany_tree,
     * hexerei:witch_hazel_tree), which all use {@link NoneFeatureConfiguration}. The namespace
     * filter ("hexerei") applied by the datapack feature_cancellers.json ensures only features
     * registered in the hexerei namespace are cancelled.
     */
    public static final FeatureCanceller HEXEREI_TREE_CANCELLER =
            new TreeFeatureCanceller<>(DynamicTreesHexerei.location("hexerei_tree"), NoneFeatureConfiguration.class);

    @SubscribeEvent
    public static void onFeatureCancellerRegistry(final RegistryEvent<FeatureCanceller> event) {
        if (event.isEntryOfType(FeatureCanceller.class)) {
            event.getRegistry().registerAll(HEXEREI_TREE_CANCELLER);
        }
    }
}