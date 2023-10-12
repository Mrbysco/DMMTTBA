package com.mrbysco.dmmttba;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(DMMTTBA.MOD_ID)
public class DMMTTBA {
	public static final String MOD_ID = "dmmttba";

	public static final ITag.INamedTag<EntityType<?>> STEERABLE = EntityTypeTags.bind(new ResourceLocation(MOD_ID, "steerable").toString());

	public DMMTTBA() {
		MinecraftForge.EVENT_BUS.addListener(this::onEntityMount);
	}

	private void onEntityMount(EntityMountEvent event) {
		Entity mountedEntity = event.getEntityBeingMounted();
		Entity mountingEntity = event.getEntityMounting();
		if (mountedEntity.getType().is(STEERABLE) && mountedEntity.getControllingPassenger() == null && mountingEntity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) mountingEntity;
			mountedEntity.yRot = player.yRot;
		}
	}
}
