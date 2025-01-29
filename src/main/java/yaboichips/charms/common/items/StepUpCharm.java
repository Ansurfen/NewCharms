package yaboichips.charms.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class StepUpCharm extends CharmItem implements ICurioItem {
    public StepUpCharm(Properties properties) {
        super(properties, null, 0);
    }


    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        if (entity instanceof Player player) {
            if (player.isSprinting()) {
                player.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(1.0f);
            } else {
                player.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(0.6f);
            }
        }
    }
}
