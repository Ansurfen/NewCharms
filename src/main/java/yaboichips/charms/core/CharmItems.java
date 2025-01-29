package yaboichips.charms.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import yaboichips.charms.common.items.*;

import static yaboichips.charms.Charms.MOD_ID;

public class CharmItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);


    public static RegistryObject<Item> SATURATION_CHARM = ITEMS.register("saturation_charm", () -> new SaturationCharm(new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> SPEED_CHARM = ITEMS.register("speed_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.MOVEMENT_SPEED.get(), 50));
    public static RegistryObject<Item> SPEED_2_CHARM = ITEMS.register("speed_2_charm", () -> new UpgradedCharmItem(new Item.Properties().stacksTo(1), MobEffects.MOVEMENT_SPEED.get(), 50));
    public static RegistryObject<Item> HASTE_CHARM = ITEMS.register("haste_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.DIG_SPEED.get(), 50));
    public static RegistryObject<Item> HASTE_2_CHARM = ITEMS.register("haste_2_charm", () -> new UpgradedCharmItem(new Item.Properties().stacksTo(1), MobEffects.DIG_SPEED.get(), 50));
    public static RegistryObject<Item> STRENGTH_CHARM = ITEMS.register("strength_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.DAMAGE_BOOST.get(), 50));
    public static RegistryObject<Item> STRENGTH_2_CHARM = ITEMS.register("strength_2_charm", () -> new UpgradedCharmItem(new Item.Properties().stacksTo(1), MobEffects.DAMAGE_BOOST.get(), 50));
    public static RegistryObject<Item> ABSORPTION_CHARM = ITEMS.register("absorption_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.ABSORPTION.get(), 50));
    public static RegistryObject<Item> GLOWING_CHARM = ITEMS.register("glowing_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.GLOWING.get(), 50));
    public static RegistryObject<Item> DOLPHIN_CHARM = ITEMS.register("dolphin_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.DOLPHINS_GRACE.get(), 50));
    public static RegistryObject<Item> BLINDNESS_CHARM = ITEMS.register("blindness_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.BLINDNESS.get(), 50));
    public static RegistryObject<Item> NAUSEA_CHARM = ITEMS.register("nausea_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.CONFUSION.get(), 220));
    public static RegistryObject<Item> INVISIBILITY_CHARM = ITEMS.register("invisibility_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.INVISIBILITY.get(), 50));
    public static RegistryObject<Item> LUCK_CHARM = ITEMS.register("luck_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.LUCK.get(), 50));
    public static RegistryObject<Item> LEVITATION_CHARM = ITEMS.register("levitation_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.LEVITATION.get(), 50));
    public static RegistryObject<Item> CHARM_BASE = ITEMS.register("charm_base", () -> new Item(new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> SLOWNESS_CHARM = ITEMS.register("slowness_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.MOVEMENT_SLOWDOWN.get(), 50));
    public static RegistryObject<Item> SLOW_FALLING_CHARM = ITEMS.register("slow_falling_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.SLOW_FALLING.get(), 50));
    public static RegistryObject<Item> ABSORPTION_2_CHARM = ITEMS.register("absorption_2_charm", () -> new UpgradedCharmItem(new Item.Properties().stacksTo(1), MobEffects.ABSORPTION.get(), 50));
    public static RegistryObject<Item> FIRE_RESISTANCE_CHARM = ITEMS.register("fire_resistance_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.FIRE_RESISTANCE.get(), 50));
    public static RegistryObject<Item> WATER_BREATHING_CHARM = ITEMS.register("water_breathing_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.WATER_BREATHING.get(), 50));
    public static RegistryObject<Item> MINING_FATIGUE_CHARM = ITEMS.register("mining_fatigue_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.DIG_SLOWDOWN.get(), 50));
    public static RegistryObject<Item> NIGHT_VISION_CHARM = ITEMS.register("night_vision_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.NIGHT_VISION.get(), 220));
    public static RegistryObject<Item> RESISTANCE_CHARM = ITEMS.register("resistance_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.DAMAGE_RESISTANCE.get(), 50));
    public static RegistryObject<Item> RESISTANCE_2_CHARM = ITEMS.register("resistance_2_charm", () -> new UpgradedCharmItem(new Item.Properties().stacksTo(1), MobEffects.DAMAGE_RESISTANCE.get(), 50));
    public static RegistryObject<Item> JUMP_CHARM = ITEMS.register("jump_charm", () -> new CharmItem(new Item.Properties().stacksTo(1), MobEffects.JUMP.get(), 50));
    public static RegistryObject<Item> JUMP_2_CHARM = ITEMS.register("jump_2_charm", () -> new UpgradedCharmItem(new Item.Properties().stacksTo(1), MobEffects.JUMP.get(), 50));
    public static RegistryObject<Item> SPIDER_CHARM = ITEMS.register("spider_charm", () -> new SpiderCharm(new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> FALL_CHARM = ITEMS.register("fall_charm", () -> new FallCharm(new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> BOUNCE_CHARM = ITEMS.register("bounce_charm", () -> new BounceCharm(new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> STEEL_TOED_CHARM = ITEMS.register("steel_toed_charm", () -> new SteelToedCharm(new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> STEP_UP_CHARM = ITEMS.register("step_up_charm", () -> new StepUpCharm(new Item.Properties().stacksTo(1)));

    public static RegistryObject<Item> CHARM_CONTAINER = ITEMS.register("charm_container", () -> new BlockItem(CharmBlocks.CHARM_CONTAINER.get(), new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> ADVANCED_CHARM_CONTAINER = ITEMS.register("advanced_charm_container", () -> new BlockItem(CharmBlocks.ADVANCED_CHARM_CONTAINER.get(), new Item.Properties().stacksTo(64)));
    public static RegistryObject<Item> ULTIMATE_CHARM_CONTAINER = ITEMS.register("ultimate_charm_container", () -> new BlockItem(CharmBlocks.ULTIMATE_CHARM_CONTAINER.get(), new Item.Properties().stacksTo(64)));

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("rp_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.literal("Charms"))
            .icon(() -> CHARM_BASE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                ITEMS.getEntries().forEach(item->output.accept(item.get()));
            }).build());
}