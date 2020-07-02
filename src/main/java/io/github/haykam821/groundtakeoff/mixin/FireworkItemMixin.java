package io.github.haykam821.groundtakeoff.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FireworkItem;

@Mixin(FireworkItem.class)
public class FireworkItemMixin {
	@Redirect(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isFallFlying()Z"))
	public boolean allowFireworkFromGround(PlayerEntity player) {
		return true;
	}
}