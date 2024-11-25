package de.dar1rojumaen.juda;

import de.dar1rojumaen.juda.dar1ro.datagen.DaModBlockTag;
import de.dar1rojumaen.juda.jumaen.datagen.JuModBlockTag;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class JuDaModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(DaModBlockTag::new);
		pack.addProvider(JuModBlockTag::new);
	}
}
