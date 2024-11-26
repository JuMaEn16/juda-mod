package de.dar1rojumaen.juda;

import de.dar1rojumaen.juda.dar1ro.block.DaModBlocks;
import de.dar1rojumaen.juda.dar1ro.inventoryGroup.DaModGroups;
import de.dar1rojumaen.juda.dar1ro.item.DaModItems;
import de.dar1rojumaen.juda.jumaen.block.JuModBlocks;
import de.dar1rojumaen.juda.jumaen.inventoryGroup.JuModGroups;
import de.dar1rojumaen.juda.jumaen.item.JuModItems;
import de.dar1rojumaen.juda.jumaen.sounds.JuModSounds;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JuDaMod implements ModInitializer {
	public static final String MOD_ID = "juda-mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		//Dar1ro
		DaModGroups.registerGroups();

		DaModBlocks.registerModBlocks();
		DaModItems.registerModItems();


		//JuMaEn16
		JuModGroups.registerGroups();

		JuModItems.registerModItems();
		JuModBlocks.registerModBlocks();

		JuModSounds.register();

		LOGGER.info("Hello Fabric world!");
	}
}