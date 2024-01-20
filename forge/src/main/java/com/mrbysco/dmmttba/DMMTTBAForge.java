package com.mrbysco.dmmttba;

import net.minecraft.world.entity.Entity;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityMountEvent;

@Mod(Constants.MOD_ID)
public class DMMTTBAForge {

	public DMMTTBAForge() {
		NeoForge.EVENT_BUS.addListener(this::onEntityMount);
	}

	private void onEntityMount(EntityMountEvent event) {
		Entity mountedEntity = event.getEntityBeingMounted();
		Entity mountingEntity = event.getEntityMounting();
		CommonClass.rotateSteerable(mountedEntity, mountingEntity);
	}
}