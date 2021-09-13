package birsy.eldritch.core;

import birsy.eldritch.core.registry.RlyehianBlocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RlyehianMod.MOD_ID)
public class RlyehianMod
{
    public static final String MOD_ID = "rlyehian";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public RlyehianMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RlyehianBlocks.BLOCKS.register(modEventBus);
        RlyehianBlocks.ITEMS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
}
