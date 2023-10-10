package com.mrbysco.dmmttba;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "dmmttba";
	public static final String MOD_NAME = "Don't Make Me Turn This Boat Around";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	public static final TagKey<EntityType<?>> STEERABLE = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(MOD_ID, "steerable"));
}