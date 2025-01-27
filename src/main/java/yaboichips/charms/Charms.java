package yaboichips.charms;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import yaboichips.charms.client.gui.AdvancedContainerScreen;
import yaboichips.charms.client.gui.CharmContainerScreen;
import yaboichips.charms.client.gui.UltamiteContainerScreen;
import yaboichips.charms.core.CharmContainerTypes;
import yaboichips.charms.core.CharmItems;
import yaboichips.charms.core.CharmTileEntityTypes;
import yaboichips.charms.util.CharmsConfig;
import yaboichips.charms.util.CuriosModCheck;
import yaboichips.charms.util.events.CharmProperties;

import static yaboichips.charms.core.CharmBlocks.BLOCKS;
import static yaboichips.charms.core.CharmItems.CREATIVE_MODE_TABS;
import static yaboichips.charms.core.CharmItems.ITEMS;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Charms.MOD_ID)
public class Charms {

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "charms";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public Charms() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(new CharmProperties());
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        CharmContainerTypes.MENUS.register(modEventBus);
        CharmTileEntityTypes.BLOCK_ENTITY.register(modEventBus);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::enqueueIMC);
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CharmsConfig.getConfigSpec(), "charms.toml");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
    private void clientSetup(FMLClientSetupEvent e) {
        LOGGER.debug("Charms: Client Setup event starting...");
        MenuScreens.register(CharmContainerTypes.CHARM_CONTAINER.get(), CharmContainerScreen::new);
        MenuScreens.register(CharmContainerTypes.ULTIMATE_CHARM_CONTAINER.get(), UltamiteContainerScreen::new);
        MenuScreens.register(CharmContainerTypes.ADVANCED_CHARM_CONTAINER.get(), AdvancedContainerScreen::new);

    }
    private void enqueueIMC(final InterModEnqueueEvent e) {
        {
            InterModComms.sendTo("charms", "helloworld", () -> {
                LOGGER.info("Hello world from Charms");
                return "Hello world";
            });
            if (CuriosModCheck.CURIOS.isLoaded()) {
                InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("charm").size(CharmsConfig.getInstance().charmSlots()).build());
            }
        }
    }
}
