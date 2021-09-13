package birsy.eldritch.core.registry;

import birsy.eldritch.core.RlyehianMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class RlyehianInventoryTabs {
    public static final ItemGroup RLYEHIAN = new ItemGroup(RlyehianMod.MOD_ID)
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(Items.ENDER_EYE);
        }
    };
}
