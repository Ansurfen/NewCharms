package yaboichips.charms.common.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import yaboichips.charms.common.container.CharmContainer;
import yaboichips.charms.common.tileentitys.CharmContainerTE;
import yaboichips.charms.core.CharmTileEntityTypes;

import javax.annotation.Nullable;

public class CharmContainerBlock extends BaseEntityBlock {

    public CharmContainerBlock(Properties properties) {
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
            if (tile instanceof CharmContainerTE) {
                player.openMenu(this.getMenuProvider(state, worldIn, pos));
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity te = worldIn.getBlockEntity(pos);
            if (te instanceof CharmContainerTE) {
                Containers.dropContents(worldIn, pos, ((CharmContainerTE) te).getItems());
            }
            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49090_) {
        return RenderShape.MODEL;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152160_, BlockState p_152161_, BlockEntityType<T> type) {
        return createTickerHelper(type, CharmTileEntityTypes.CHARM_CONTAINER.get(), CharmContainerTE::tick);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return CharmTileEntityTypes.CHARM_CONTAINER.get().create(blockPos, blockState);
    }

    @Nullable
    protected MenuProvider getMenuProvider(BlockState p_335872_, Level p_334298_, BlockPos p_336351_) {
        BlockEntity blockentity = p_334298_.getBlockEntity(p_336351_);
        if (blockentity instanceof CharmContainerTE) {
            Component component = ((Nameable) blockentity).getDisplayName();
            return new SimpleMenuProvider((p_328554_, p_332165_, p_330050_) -> new CharmContainer(p_328554_, p_332165_, new SimpleContainer(1)), component);
        } else {
            return null;
        }
    }
}