package de.dar1rojumaen.juda.jumaen.item;

import de.dar1rojumaen.juda.JuDaMod;
import de.dar1rojumaen.juda.jumaen.item.doubleJump.JuDoubleJumpBoots;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JuModItems {
    public static final Item VOIDITE = registerItem("voidite", new Item(new Item.Settings()));
    public static final Item RAW_VOIDITE = registerItem("raw_voidite", new Item(new Item.Settings()));

    public static final Item VOIDITE_BOOTS = registerItem("voidite_boots", new JuDoubleJumpBoots(ModArmorMaterials.VOIDITE_ARMOR_MATERIAL,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(JuDaMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        JuDaMod.LOGGER.info("Registering JuMaEn Mod Items for " + JuDaMod.MOD_ID);
    }
}
