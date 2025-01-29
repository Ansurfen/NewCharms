package yaboichips.charms.common.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.EnchantingTableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import yaboichips.charms.common.container.AdvancedCharmContainer;
import yaboichips.charms.common.tileentitys.AdvancedCharmTE;
import yaboichips.charms.core.CharmTileEntityTypes;

import javax.annotation.Nullable;


public class AdvancedCharmBlock extends BaseEntityBlock {

    public AdvancedCharmBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }



    @Override
    public InteractionResult useWithoutItem(BlockState state, Level worldIn, BlockPos pos, Player player, BlockHitResult result) {
        if (!worldIn.isClientSide) {
            BlockEntity tile = worldIn.getBlockEntity(pos);
            if (tile instanceof AdvancedCharmTE) {
                player.openMenu(this.getMenuProvider(state, worldIn, pos));
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152160_, BlockState p_152161_, BlockEntityType<T> type) {
        return createTickerHelper(type, CharmTileEntityTypes.ADVANCED_CHARM_CONTAINER.get(), AdvancedCharmTE::tick);
    }

    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity te = worldIn.getBlockEntity(pos);
            if (te instanceof AdvancedCharmTE) {
                Containers.dropContents(worldIn, pos, ((AdvancedCharmTE) te).getItems());
            }
            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49090_) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return CharmTileEntityTypes.ADVANCED_CHARM_CONTAINER.get().create(blockPos, blockState);
    }

    @Nullable
    protected MenuProvider getMenuProvider(BlockState p_335872_, Level p_334298_, BlockPos p_336351_) {
        BlockEntity blockentity = p_334298_.getBlockEntity(p_336351_);
        if (blockentity instanceof AdvancedCharmTE) {
            Component component = ((Nameable)blockentity).getDisplayName();
            return new SimpleMenuProvider((p_328554_, p_332165_, p_330050_) -> new AdvancedCharmContainer(p_328554_, p_332165_, new SimpleContainer(9)), component);
        } else {
            return null;
        }
    }
}