package birsy.eldritch.core.registry;

import birsy.eldritch.core.RlyehianMod;
import net.minecraft.world.gen.surfacebuilders.MountainSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RlyehianSurfaceBuilders {
    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, RlyehianMod.MOD_ID);

    public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> SEABED = SURFACE_BUILDERS.register("scarred_cliffs_builder", () -> new MountainSurfaceBuilder(SurfaceBuilderConfig.CODEC));
}
