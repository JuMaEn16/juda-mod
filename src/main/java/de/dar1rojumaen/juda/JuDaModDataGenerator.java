package de.dar1rojumaen.juda;

import de.dar1rojumaen.juda.dar1ro.datagen.*;
import de.dar1rojumaen.juda.datagen.JuDaModRegistry;
import de.dar1rojumaen.juda.jumaen.datagen.JuModBlockTag;
import de.dar1rojumaen.juda.jumaen.datagen.JuModItemTag;
import de.dar1rojumaen.juda.jumaen.datagen.JuModLootTable;
import de.dar1rojumaen.juda.jumaen.datagen.JuModModel;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class JuDaModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(DaModBlockTag::new);
		pack.addProvider(JuModBlockTag::new);

		pack.addProvider(DaModItemTag::new);
		pack.addProvider(JuModItemTag::new);

		pack.addProvider(DaModLootTable::new);
		pack.addProvider(JuModLootTable::new);

		pack.addProvider(DaModModel::new);
		pack.addProvider(JuModModel::new);

		pack.addProvider(DaModRecipe::new);
		pack.addProvider(DaModRecipe::new);

		pack.addProvider(JuDaModRegistry::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		//registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, ModTrimMaterials::bootstrap);
		//registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, ModEnchantments::bootstrap);
	}
}
