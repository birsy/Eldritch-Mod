package birsy.eldritch.core.registry;

import birsy.eldritch.core.RlyehianMod;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class RlyehianItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RlyehianMod.MOD_ID);

	//public static final RegistryObject<Item> EELSKIN_PLATE = createItem("eelskin_plate", () -> new Item(new Item.Properties().group(GoblinsMod.CASTLE_MOD)));

	public static <I extends Item> RegistryObject<I> createItem(String name, Supplier<? extends I> item) {
		return ITEMS.register(name, item);
	}
}
