package birsy.eldritch.core.registry;

import birsy.eldritch.core.RlyehianMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class RlyehianTags {
    public static final ITag.INamedTag<Block> SEABED_BLOCKS = createBlockTag("seabed");
    public static final ITag.INamedTag<Block> ROTTEN_SEABED_BLOCKS = createBlockTag("rotten_seabed");

    public static ITag.INamedTag<Item> createItemTag(String tagLocation) {
        return ItemTags.createOptional(new ResourceLocation(RlyehianMod.MOD_ID, tagLocation));
    }

    public static ITag.INamedTag<Block> createBlockTag(String tagLocation) {
        return BlockTags.createOptional(new ResourceLocation(RlyehianMod.MOD_ID, tagLocation));
    }
}
