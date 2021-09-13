package birsy.eldritch.core.registry;

import birsy.eldritch.core.RlyehianMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RlyehianBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, RlyehianMod.MOD_ID);

    public static final RegistryObject<Biome> SCARRED_CLIFFS = BIOMES.register("scarred_cliffs", BiomeMaker::theVoidBiome);
    public static final RegistryObject<Biome> SCARRED_CLIFFS_SHORE = BIOMES.register("scarred_cliffs_shore", BiomeMaker::theVoidBiome);
    public static final RegistryObject<Biome> GOBLIN_BASIN = BIOMES.register("goblin_basin", BiomeMaker::theVoidBiome);

    public static void registerBiomes() {
        registerBiome("scarred_cliffs", SCARRED_CLIFFS.get(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBiome("scarred_cliffs_shore", SCARRED_CLIFFS_SHORE.get(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBiome("goblin_basin", GOBLIN_BASIN.get(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
    }

    public static void registerBiome(String name, Biome biome, BiomeManager.BiomeType type, BiomeDictionary.Type... types) {
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(RlyehianMod.MOD_ID, name)), 5));
    }
}
