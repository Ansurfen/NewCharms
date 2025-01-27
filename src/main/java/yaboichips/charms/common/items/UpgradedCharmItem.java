package yaboichips.charms.common.items;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class UpgradedCharmItem extends CharmItem implements ICurioItem {
    public MobEffect effect;
    public int length;


    public UpgradedCharmItem(Properties properties, MobEffect effects, int length) {
        super(properties, effects, length);
        this.effect = effects;
        this.length = length;
    }

    public MobEffect getCharmEffect() {
        return this.effect;
    }


    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        Item item = stack.getItem();
        if (item instanceof UpgradedCharmItem charm) {
            slotContext.entity().addEffect(new MobEffectInstance(charm.getCharmEffect(), length, 1));
        }
    }
}
