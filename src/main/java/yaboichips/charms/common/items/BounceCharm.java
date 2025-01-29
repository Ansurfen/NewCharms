package yaboichips.charms.common.items;

import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class BounceCharm extends CharmItem implements ICurioItem {
    public BounceCharm(Properties properties) {
        super(properties, null, 0);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        Player entity = (Player)slotContext.entity();
        checkAndBouncePlayer(entity);
    }
    public static void checkAndBouncePlayer(Player player) {
        if (!player.level().isClientSide && player instanceof ServerPlayer serverPlayer) {
            if (player.onGround()) {
                double savedYVelocity = player.getPersistentData().getDouble("savedYVelocity");
                double lookAngle = Math.toRadians(player.getYRot()); // Player's yaw rotation in degrees
                double horizontalBoost = Math.abs(savedYVelocity) * 0.3; // Scale boost by vertical velocity
                double xBoost = -Math.sin(lookAngle) * horizontalBoost;
                double zBoost = Math.cos(lookAngle) * horizontalBoost;
                if (Math.abs(savedYVelocity) > 0.5) {
                    double bounceVelocity = savedYVelocity * 0.8;
                    Vec3 velocity = new Vec3(player.getDeltaMovement().x + xBoost, -bounceVelocity, player.getDeltaMovement().z + zBoost);
                    serverPlayer.connection.send(new ClientboundSetEntityMotionPacket(serverPlayer.getId(), velocity));
                    serverPlayer.setDeltaMovement(velocity);
                    player.level().playSound(null, player.blockPosition(), SoundEvents.SLIME_BLOCK_FALL, SoundSource.PLAYERS, 1.0F, 1.0F);
                    savedYVelocity *= -0.6;
                    if (Math.abs(savedYVelocity) < 0.3) {
                        savedYVelocity = 0.0; // Clear saved velocity
                    }
                    player.getPersistentData().putDouble("savedYVelocity", savedYVelocity);
                } else {
                    player.getPersistentData().putDouble("savedYVelocity", 0.0);
                }
            } else {
                player.getPersistentData().putDouble("savedYVelocity", player.getDeltaMovement().y);
            }
        }
    }
}