package com.mrbysco.dmmttba;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;

public class CommonClass {

	/**
	 * Rotate steerable entities to match the player's yaw
	 *
	 * @param mountedEntity  The entity that is being mounted
	 * @param mountingEntity The entity that is mounting the other entity
	 */
	public static void rotateSteerable(Entity mountedEntity, Entity mountingEntity) {
		if ((mountedEntity.getType().is(Constants.STEERABLE) || mountedEntity instanceof Boat) && !mountedEntity.hasControllingPassenger() && mountingEntity instanceof Player player) {
			mountedEntity.setYRot(player.getYRot());
		}
	}
}