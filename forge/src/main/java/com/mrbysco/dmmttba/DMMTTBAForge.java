package com.mrbysco.dmmttba;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class DMMTTBAForge {

	public DMMTTBAForge() {
		MinecraftForge.EVENT_BUS.addListener(this::onEntityMount);
	}

	private void onEntityMount(EntityMountEvent event) {
		Entity mountedEntity = event.getEntityBeingMounted();
		Entity mountingEntity = event.getEntityMounting();
		CommonClass.rotateSteerable(mountedEntity, mountingEntity);
	}
}