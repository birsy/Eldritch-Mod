package birsy.eldritch.core.registry;

import birsy.eldritch.core.RlyehianMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RlyehianEntities
{
	public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, RlyehianMod.MOD_ID);

	//Entity Types

	/**
	public static final RegistryObject<EntityType<SchnozEntity>> SCHNOZ = ENTITY_TYPES.register("schnoz",
			() -> EntityType.Builder.create(SchnozEntity::new, EntityClassification.CREATURE)
					.size(1.25f, 1.625f)
					.build(new ResourceLocation(GoblinsMod.MOD_ID, "schnoz").toString()));



	public static final RegistryObject<EntityType<CobuntoEntity>> COBUNTO = ENTITY_TYPES.register("cobunto",
			() -> EntityType.Builder.create(CobuntoEntity::new, EntityClassification.MONSTER)
					.size(2.5f, 3.75f)
					.build(new ResourceLocation(GoblinsMod.MOD_ID, "cobunto").toString()));


	public static final RegistryObject<EntityType<SanctumiteEntity>> SANCTUMITE = ENTITY_TYPES.register("sanctumite",
			() -> EntityType.Builder.create(SanctumiteEntity::new, EntityClassification.MONSTER)
					.size(1.0f, 1.25f)
					.build(new ResourceLocation(GoblinsMod.MOD_ID, "sanctumite").toString()));


	public static final RegistryObject<EntityType<GoblinEntity>> GOBLIN = ENTITY_TYPES.register("goblin",
			() -> EntityType.Builder.create(GoblinEntity::new, EntityClassification.MONSTER)
					.size(1.0625f, 2.125f)
					.build(new ResourceLocation(GoblinsMod.MOD_ID, "goblin").toString()));

	public static final RegistryObject<EntityType<HobgoblinEntity>> HOBGOBLIN = ENTITY_TYPES.register("hobgoblin",
			() -> EntityType.Builder.create(HobgoblinEntity::new, EntityClassification.MONSTER)
			.size(1.5f, 3.75f)
			.build(new ResourceLocation(GoblinsMod.MOD_ID, "hobgoblin").toString()));

	public static final RegistryObject<EntityType<GhoulEntity>> GHOUL = ENTITY_TYPES.register("ghoul",
			() -> EntityType.Builder.create(GhoulEntity::new, EntityClassification.MONSTER)
					.size(0.8f, 2.4f)
					.build(new ResourceLocation(GoblinsMod.MOD_ID, "ghoul").toString()));




	public static void setup()
	{
		GlobalEntityTypeAttributes.put(RlyehianEntities.SCHNOZ.get(), SchnozEntity.setCustomAttributes().create());


		GlobalEntityTypeAttributes.put(RlyehianEntities.COBUNTO.get(), HobgoblinEntity.setCustomAttributes().create());

		GlobalEntityTypeAttributes.put(RlyehianEntities.SANCTUMITE.get(), SanctumiteEntity.setCustomAttributes().create());

		GlobalEntityTypeAttributes.put(RlyehianEntities.GOBLIN.get(), GoblinEntity.setCustomAttributes().create());
		GlobalEntityTypeAttributes.put(RlyehianEntities.HOBGOBLIN.get(), HobgoblinEntity.setCustomAttributes().create());

		GlobalEntityTypeAttributes.put(RlyehianEntities.GHOUL.get(), GhoulEntity.setCustomAttributes().create());

		GlobalEntityTypeAttributes.put(RlyehianEntities.CORRUPTED_KING.get(), CorruptedKingEntity.setCustomAttributes().create());

		GlobalEntityTypeAttributes.put(RlyehianEntities.NEW_WITHER_SKULL.get(), NewWitherSkullEntity.setCustomAttributes().create());
	}

	public static void clientSetup() {
		RenderingRegistry.registerEntityRenderingHandler(RlyehianEntities.SCHNOZ.get(), SchnozRenderer::new);


		RenderingRegistry.registerEntityRenderingHandler(RlyehianEntities.COBUNTO.get(), CobuntoRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(RlyehianEntities.SANCTUMITE.get(), SanctumiteRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(RlyehianEntities.GOBLIN.get(), GoblinRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(RlyehianEntities.HOBGOBLIN.get(), HobgoblinRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(RlyehianEntities.GHOUL.get(), GhoulRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(RlyehianEntities.CORRUPTED_KING.get(), CorruptedKingRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(RlyehianEntities.NEW_WITHER_SKULL.get(), WitherSkullRenderer::new);
	}
	 */
}
