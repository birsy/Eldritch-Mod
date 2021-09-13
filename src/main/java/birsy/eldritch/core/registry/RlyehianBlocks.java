package birsy.eldritch.core.registry;

import birsy.eldritch.common.blocks.ChiseledSeabedBlock;
import birsy.eldritch.common.blocks.RottingBlock;
import birsy.eldritch.core.RlyehianMod;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class RlyehianBlocks
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RlyehianMod.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RlyehianMod.MOD_ID);
	
	// Blocks

	/**
	 * SEABED
	 * The Eternal Sea has no real stone foundations - yet the moss and death settles at the bottom, forming a stone of sorts.
	 */
	private static final AbstractBlock.Properties seabedProperties = AbstractBlock.Properties
			.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN)
			.requiresCorrectToolForDrops()
			.strength(5.0F, 6.0F)
			.sound(SoundType.CORAL_BLOCK);

	public static final RegistryObject<Block> SEABED = createBlock("seabed", () -> new Block(seabedProperties), RlyehianInventoryTabs.RLYEHIAN);
	public static final RegistryObject<Block> SEABED_SLAB = createBlock("seabed_slab", () -> new SlabBlock(seabedProperties), RlyehianInventoryTabs.RLYEHIAN);
	public static final RegistryObject<Block> SEABED_STAIRS = createBlock("seabed_stairs", () -> new StairsBlock(() -> SEABED.get().defaultBlockState(), seabedProperties), RlyehianInventoryTabs.RLYEHIAN);
	public static final RegistryObject<Block> SEABED_WALL = createBlock("seabed_wall", () -> new WallBlock(seabedProperties), RlyehianInventoryTabs.RLYEHIAN);

	public static final RegistryObject<Block> ROTTEN_POLISHED_SEABED = createBlock("rotten_polished_seabed", () -> new RottingBlock(seabedProperties, SEABED.get().defaultBlockState(), 2), RlyehianInventoryTabs.RLYEHIAN);
	public static final RegistryObject<Block> POLISHED_SEABED = createBlock("polished_seabed", () -> new RottingBlock(seabedProperties, ROTTEN_POLISHED_SEABED.get().defaultBlockState(), 1.35F), RlyehianInventoryTabs.RLYEHIAN);
	public static final RegistryObject<Block> POLISHED_SEABED_SLAB = createBlock("polished_seabed_slab", () -> new SlabBlock(seabedProperties), RlyehianInventoryTabs.RLYEHIAN);
	public static final RegistryObject<Block> POLISHED_SEABED_STAIRS = createBlock("polished_seabed_stairs", () -> new StairsBlock(() -> POLISHED_SEABED.get().defaultBlockState(), seabedProperties), RlyehianInventoryTabs.RLYEHIAN);
	public static final RegistryObject<Block> POLISHED_SEABED_WALL = createBlock("polished_seabed_wall", () -> new WallBlock(seabedProperties), RlyehianInventoryTabs.RLYEHIAN);

	public static final RegistryObject<Block> ROTTEN_SEABED_BRICKS = createBlock("rotten_seabed_bricks", () -> new RottingBlock(seabedProperties, SEABED.get().defaultBlockState(), 2), RlyehianInventoryTabs.RLYEHIAN);
	public static final RegistryObject<Block> SEABED_BRICKS = createBlock("seabed_bricks", () -> new RottingBlock(seabedProperties, ROTTEN_SEABED_BRICKS.get().defaultBlockState(), 1.35F), RlyehianInventoryTabs.RLYEHIAN);
	public static final RegistryObject<Block> SEABED_BRICK_SLAB = createBlock("seabed_brick_slab", () -> new SlabBlock(seabedProperties), RlyehianInventoryTabs.RLYEHIAN);
	public static final RegistryObject<Block> SEABED_BRICK_STAIRS = createBlock("seabed_brick_stairs", () -> new StairsBlock(() -> SEABED_BRICKS.get().defaultBlockState(), seabedProperties), RlyehianInventoryTabs.RLYEHIAN);
	public static final RegistryObject<Block> SEABED_BRICK_WALL = createBlock("seabed_brick_wall", () -> new WallBlock(seabedProperties), RlyehianInventoryTabs.RLYEHIAN);
	
	public static final RegistryObject<Block> CHISELED_SEABED = createBlock("chiseled_seabed", () -> new ChiseledSeabedBlock(seabedProperties, SEABED.get().defaultBlockState()), RlyehianInventoryTabs.RLYEHIAN);

	public static <B extends Block> RegistryObject<B> createBlock(String name, final Supplier<? extends B> supplier, @Nullable ItemGroup group) {
		RegistryObject<B> block = BLOCKS.register(name, supplier);
		if (group != null) {
			ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(group)));
		}
		return block;
	}
}
