package yaboichips.charms.core;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import yaboichips.charms.common.tileentitys.AdvancedCharmTE;
import yaboichips.charms.common.tileentitys.CharmContainerTE;
import yaboichips.charms.common.tileentitys.UltimateCharmTE;

import java.util.function.Supplier;

import static yaboichips.charms.Charms.MOD_ID;

public class CharmTileEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MOD_ID);

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String key, Supplier<BlockEntityType.Builder<T>> builder) {
        return BLOCK_ENTITY.register(key, () -> builder.get().build(null));
    }    public static final RegistryObject<BlockEntityType<CharmContainerTE>> CHARM_CONTAINER = register("charm_container", () -> BlockEntityType.Builder.of(CharmContainerTE::new, CharmBlocks.CHARM_CONTAINER.get()));

    public static final RegistryObject<BlockEntityType<UltimateCharmTE>> ULTAMITE_CHARM_CONTAINER = register("ultamite_charm_container", () -> BlockEntityType.Builder.of(UltimateCharmTE::new, CharmBlocks.ULTIMATE_CHARM_CONTAINER.get()));

    public static final RegistryObject<BlockEntityType<AdvancedCharmTE>> ADVANCED_CHARM_CONTAINER = register("advanced_charm_container", () -> BlockEntityType.Builder.of(AdvancedCharmTE::new, CharmBlocks.ADVANCED_CHARM_CONTAINER.get()));


}
