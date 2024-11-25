package de.dar1rojumaen.juda.datagen;

import de.dar1rojumaen.juda.jumaen.item.JuModItems;
import de.dar1rojumaen.juda.jumaen.util.JuModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class JuDaModItemTag extends FabricTagProvider.ItemTagProvider {
    public JuDaModItemTag(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(JuModTags.Items.VOIDITE_ITEMS)
                .add(JuModItems.RAW_VOIDITE)
                .add(JuModItems.VOIDITE);
    }
}
