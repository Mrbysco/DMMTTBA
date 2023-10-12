package com.mrbysco.dmmttba.data;

import com.mrbysco.dmmttba.DMMTTBA;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.EntityTypeTagsProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

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
			super(generator, DMMTTBA.MOD_ID, existingFileHelper);
		}

		public static final ITag.INamedTag<EntityType<?>> BOATS = EntityTypeTags.bind(new ResourceLocation("forge", "boats").toString());

		@Override
		protected void addTags() {
			this.tag(BOATS).add(EntityType.BOAT);
			this.tag(DMMTTBA.STEERABLE).addTag(BOATS);
		}
	}
}
