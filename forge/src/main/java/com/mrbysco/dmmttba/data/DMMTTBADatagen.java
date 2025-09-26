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
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class DMMTTBADatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		generator.addProvider(true, new BoatEntityTagProvider(packOutput, lookupProvider));
	}

	public static class BoatEntityTagProvider extends EntityTypeTagsProvider {
		public BoatEntityTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
			super(packOutput, completableFuture, Constants.MOD_ID);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			//Add modded boats
			this.tag(Tags.EntityTypes.BOATS)
					.addOptional(ResourceLocation.fromNamespaceAndPath("thermal", "rubberwood_boat"))
					.addOptional(ResourceLocation.fromNamespaceAndPath("thermal", "rubberwood_chest_boat"))
					.addOptional(ResourceLocation.fromNamespaceAndPath("ecologics", "boat"))
					.addOptional(ResourceLocation.fromNamespaceAndPath("ecologics", "chest_boat"))
					.addOptional(ResourceLocation.fromNamespaceAndPath("terraform", "boat"))
					.addOptional(ResourceLocation.fromNamespaceAndPath("terraform", "chest_boat"))
					.addOptional(ResourceLocation.fromNamespaceAndPath("blueprint", "boat"))
					.addOptional(ResourceLocation.fromNamespaceAndPath("blueprint", "chest_boat"))
					.addOptional(ResourceLocation.fromNamespaceAndPath("blueprint", "chest_boat"))
					.addOptional(ResourceLocation.fromNamespaceAndPath("utilitix", "shulker_boat"))
			;

			this.tag(Constants.STEERABLE).addTag(Tags.EntityTypes.BOATS);
		}
	}
}
