package com.mrbysco.dmmttba.data;

import com.mrbysco.dmmttba.Constants;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DMMTTBADatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(new BoatEntityTagProvider(generator, helper));
		}
	}

	public static class BoatEntityTagProvider extends EntityTypeTagsProvider {
		public BoatEntityTagProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
			super(generator, Constants.MOD_ID, existingFileHelper);
		}

		public static final TagKey<EntityType<?>> BOATS = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge", "boats"));

		@Override
		protected void addTags() {
			this.tag(BOATS).add(EntityType.BOAT);
			this.tag(Constants.STEERABLE).addTag(BOATS);
		}
	}
}
