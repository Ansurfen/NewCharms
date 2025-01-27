package yaboichips.charms.core;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import yaboichips.charms.common.container.AdvancedCharmContainer;
import yaboichips.charms.common.container.CharmContainer;
import yaboichips.charms.common.container.UltimateCharmContainer;

import static yaboichips.charms.Charms.MOD_ID;

public class CharmContainerTypes {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MOD_ID);

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> register(String key, MenuType.MenuSupplier<T> builder) {
        return MENUS.register(key, () -> new MenuType<>(builder, FeatureFlagSet.of()));
    }    public static final RegistryObject<MenuType<CharmContainer>> CHARM_CONTAINER = register("charm_container", CharmContainer::new);
    public static final RegistryObject<MenuType<UltimateCharmContainer>> ULTIMATE_CHARM_CONTAINER = register("ultimate_charm_container", UltimateCharmContainer::new);
    public static final RegistryObject<MenuType<AdvancedCharmContainer>> ADVANCED_CHARM_CONTAINER = register("advanced_charm_container", AdvancedCharmContainer::new);


}
