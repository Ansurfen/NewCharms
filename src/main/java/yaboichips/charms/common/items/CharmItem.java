package yaboichips.charms.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class CharmItem extends Item implements ICurioItem {
    public MobEffect effect;
    public int length;


    public CharmItem(Properties properties, MobEffect effects, int length) {
        super(properties);
        this.effect = effects;
        this.length = length;
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


    public MobEffect getCharmEffect() {
        return this.effect;
    }


    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        Item item = stack.getItem();
        if (item instanceof CharmItem charm) {
            if (getCharmEffect() != null) {
                slotContext.entity().addEffect(new MobEffectInstance(charm.getCharmEffect(), length));
            }
        }
    }
}