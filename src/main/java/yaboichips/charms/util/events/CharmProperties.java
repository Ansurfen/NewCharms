package yaboichips.charms.util.events;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yaboichips.charms.Charms;
import yaboichips.charms.common.items.CharmItem;
import yaboichips.charms.common.items.UpgradedCharmItem;

@Mod.EventBusSubscriber(modid = Charms.MOD_ID)
public class CharmProperties {

    @SubscribeEvent
    public void doCharms(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Item offhandItem = player.getOffhandItem().getItem();
        if (offhandItem instanceof CharmItem charm) {
            if (charm.getCharmEffect() != null) {
                player.addEffect(new MobEffectInstance(charm.getCharmEffect(), 100));
            }
        }
        if (offhandItem instanceof UpgradedCharmItem upCharm) {
            if (upCharm.getCharmEffect() != null) {
                player.addEffect(new MobEffectInstance(upCharm.getCharmEffect(), 50, 1));
            }
        }
        if (player.getInventory().isEmpty()) {
            player.setMaxUpStep(0.6f);
        }
    }
}