package com.mrbysco.dmmttba.data;

import com.mrbysco.dmmttba.Constants;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class DMMTTBADatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(event.includeServer(), new BoatEntityTagProvider(packOutput, lookupProvider, helper));
		}
	}

	public static class BoatEntityTagProvider extends EntityTypeTagsProvider {
		public BoatEntityTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, ExistingFileHelper existingFileHelper) {
			super(packOutput, completableFuture, Constants.MOD_ID, existingFileHelper);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			//Add modded boats
			this.tag(Tags.EntityTypes.BOATS)
					.addOptional(new ResourceLocation("thermal", "rubberwood_boat"))
					.addOptional(new ResourceLocation("thermal", "rubberwood_chest_boat"))
					.addOptional(new ResourceLocation("ecologics", "boat"))
					.addOptional(new ResourceLocation("ecologics", "chest_boat"))
					.addOptional(new ResourceLocation("terraform", "boat"))
					.addOptional(new ResourceLocation("terraform", "chest_boat"))
					.addOptional(new ResourceLocation("blueprint", "boat"))
					.addOptional(new ResourceLocation("blueprint", "chest_boat"))
					.addOptional(new ResourceLocation("blueprint", "chest_boat"))
					.addOptional(new ResourceLocation("utilitix", "shulker_boat"))
			;

			this.tag(Constants.STEERABLE).addTag(Tags.EntityTypes.BOATS);
		}
	}
}
