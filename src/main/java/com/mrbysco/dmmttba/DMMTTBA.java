package com.mrbysco.dmmttba;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(DMMTTBA.MOD_ID)
public class DMMTTBA {
	public static final String MOD_ID = "dmmttba";
	public static final Logger LOGGER = LogUtils.getLogger();
	public static final TagKey<EntityType<?>> BOATS = forgeTag("boats");

	public DMMTTBA() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onServerStarting(EntityMountEvent event) {
		Entity mountedEntity = event.getEntityBeingMounted();
		Entity mountingEntity = event.getEntityMounting();
		if (mountedEntity.getType().is(BOATS) && !mountedEntity.hasControllingPassenger() && mountingEntity instanceof Player player) {
			mountedEntity.setYRot(player.getYRot());
		}
	}

	private static TagKey<EntityType<?>> forgeTag(String name) {
		return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge", name));
	}
}
