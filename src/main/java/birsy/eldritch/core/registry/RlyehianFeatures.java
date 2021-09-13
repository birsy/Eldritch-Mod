package birsy.eldritch.core.registry;

import birsy.eldritch.core.RlyehianMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraft.world.gen.feature.ColumnConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RlyehianFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, RlyehianMod.MOD_ID);

    //public static final RegistryObject<Feature<ColumnConfig>> CRAGROCK = FEATURES.register("cragrock", () -> new CragrockFeature(ColumnConfig.CODEC));
}
