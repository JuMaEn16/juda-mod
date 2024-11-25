package de.dar1rojumaen.juda.dar1ro.inventoryGroup;

import de.dar1rojumaen.juda.JuDaMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DaModGroups {
    public static final ItemGroup FIRST_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(JuDaMod.MOD_ID, "first_mod_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(() -> Items.ACACIA_BOAT))
                    .displayName(Text.translatable("itemGroup.juda-mod.dar1ro_group"))
                    .entries((displayContext, entries) -> {
                        //entries.add(DaModItems.NAME);
                    })
                    .build());

    public static void registerGroups() {
        JuDaMod.LOGGER.info("Registering Dar1ro Item Groups for " + JuDaMod.MOD_ID);
    }
}
