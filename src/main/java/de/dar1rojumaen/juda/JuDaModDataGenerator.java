package de.dar1rojumaen.juda;

import de.dar1rojumaen.juda.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;

public class JuDaModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(JuDaModBlockTag::new);
		pack.addProvider(JuDaModItemTag::new);
		pack.addProvider(JuDaModLootTable::new);
		pack.addProvider(JuDaModModel::new);
		pack.addProvider(JuDaModRecipe::new);
		pack.addProvider(JuDaModRegistry::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		//registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, ModTrimMaterials::bootstrap);
		//registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, ModEnchantments::bootstrap);
	}
}
