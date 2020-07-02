package io.github.haykam821.groundtakeoff.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;

@Mixin(FireworkRocketEntity.class)
public class FireworkRocketEntityMixin {
	@Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isFallFlying()Z"))
	public boolean allowBoostingGroundedPlayer(LivingEntity entity) {
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).startFallFlying();
		}
		return true;
	}
}