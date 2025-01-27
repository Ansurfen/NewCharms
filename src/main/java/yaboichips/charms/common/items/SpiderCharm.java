package yaboichips.charms.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class SpiderCharm extends CharmItem implements ICurioItem {
    public SpiderCharm(Properties properties) {
        super(properties, null, 0);
    }

    public static void tryMakeEntityClimb(Level worldIn, LivingEntity entity, double climbSpeed) {
        if (entity.isCrouching()) {
            entity.setDeltaMovement(entity.getDeltaMovement().x, 0.0, entity.getDeltaMovement().z);
        } else if (entity.moveDist > 0.0F && entity.getDeltaMovement().y < climbSpeed) {
            entity.setDeltaMovement(entity.getDeltaMovement().x, climbSpeed, entity.getDeltaMovement().z);
            entity.fallDistance = 0.0F;
        }
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
        if (player.horizontalCollision) {
            tryMakeEntityClimb(player.level(), player, 0.31D);
        }
    }
}