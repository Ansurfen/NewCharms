package yaboichips.charms.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class SteelToedCharm extends CharmItem implements ICurioItem {
    public SteelToedCharm(Properties properties) {
        super(properties, null, 0);
    }


    @Override
    public void playRightClickEquipSound(LivingEntity livingEntity, ItemStack stack) {
        livingEntity.level().playSound(null, livingEntity.blockPosition(),
                SoundEvents.ARMOR_EQUIP_ELYTRA, SoundSource.NEUTRAL,
                1.0F, 1.0F);
    }

    @Override
    public boolean canRightClickEquip(ItemStack stack) {
        return true;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity player = slotContext.entity();
        Level world = player.level();
        BlockState state = world.getBlockState(player.blockPosition().below());
        BlockState state2 = world.getBlockState(player.blockPosition());

        if (state.getBlock() == Blocks.MAGMA_BLOCK) {
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10));
        }
        if (state2.getBlock() == Blocks.WITHER_ROSE) {
            player.removeEffect(MobEffects.WITHER);
        }
    }
}