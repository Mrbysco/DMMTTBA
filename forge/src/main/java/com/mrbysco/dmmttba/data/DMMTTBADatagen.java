package com.mrbysco.dmmttba.data;

import com.mrbysco.dmmttba.Constants;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
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
			var tagEntries = this.getOrCreateRawBuilder(Tags.EntityTypes.BOATS)
					.addOptionalElement(ResourceLocation.fromNamespaceAndPath("thermal", "rubberwood_boat"))
					.addOptionalElement(ResourceLocation.fromNamespaceAndPath("thermal", "rubberwood_chest_boat"))
					.addOptionalElement(ResourceLocation.fromNamespaceAndPath("ecologics", "boat"))
					.addOptionalElement(ResourceLocation.fromNamespaceAndPath("ecologics", "chest_boat"))
					.addOptionalElement(ResourceLocation.fromNamespaceAndPath("terraform", "boat"))
					.addOptionalElement(ResourceLocation.fromNamespaceAndPath("terraform", "chest_boat"))
					.addOptionalElement(ResourceLocation.fromNamespaceAndPath("blueprint", "boat"))
					.addOptionalElement(ResourceLocation.fromNamespaceAndPath("blueprint", "chest_boat"))
					.addOptionalElement(ResourceLocation.fromNamespaceAndPath("blueprint", "chest_boat"))
					.addOptionalElement(ResourceLocation.fromNamespaceAndPath("utilitix", "shulker_boat")).build()
			;

			this.tag(Constants.STEERABLE).addTag(Tags.EntityTypes.BOATS);
		}
	}
}
