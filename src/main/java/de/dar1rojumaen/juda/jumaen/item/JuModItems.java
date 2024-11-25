package de.dar1rojumaen.juda.jumaen.item;

import de.dar1rojumaen.juda.JuDaMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JuModItems {


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(JuDaMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        JuDaMod.LOGGER.info("Registering JuMaEn Mod Items for " + JuDaMod.MOD_ID);
    }
}
