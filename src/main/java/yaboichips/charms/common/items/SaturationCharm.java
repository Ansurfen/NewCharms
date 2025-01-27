package yaboichips.charms.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class SaturationCharm extends CharmItem implements ICurioItem {
    public SaturationCharm(Properties properties) {
        super(properties, MobEffects.BAD_OMEN, 0);
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
        LivingEntity livingEntity = slotContext.entity();
        if (livingEntity instanceof Player player) {
            if (player.getFoodData().getSaturationLevel() < 0.5f) {
                player.getFoodData().setSaturation(1);
            }
        }
    }
}