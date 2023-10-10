package com.mrbysco.dmmttba.mixin;

import com.mrbysco.dmmttba.CommonClass;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {

	@Inject(
			method = "startRiding(Lnet/minecraft/world/entity/Entity;Z)Z",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/entity/Entity;isPassenger()Z"
			),
			cancellable = true
	)
	public void dmmttba$onStartRiding(Entity entity, boolean bl, CallbackInfoReturnable<Boolean> cir) {
		CommonClass.rotateSteerable(entity, (Entity) (Object) this);
	}
}