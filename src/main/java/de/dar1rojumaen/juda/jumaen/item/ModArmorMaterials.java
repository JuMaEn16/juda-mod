package de.dar1rojumaen.juda.jumaen.item;

import de.dar1rojumaen.juda.JuDaMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> VOIDITE_ARMOR_MATERIAL = registerArmorMaterial("voidite",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), typeIntegerEnumMap -> {
                typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, 3);
                typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, 4);
                typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, 5);
                typeIntegerEnumMap.put(ArmorItem.Type.HELMET, 2);
                typeIntegerEnumMap.put(ArmorItem.Type.BODY, 4);
            }),
                    22,
                    SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
                    () -> Ingredient.ofItems(JuModItems.VOIDITE),
                    List.of(new ArmorMaterial.Layer(Identifier.of(JuDaMod.MOD_ID, "voidite"))), 2.0F, 1.0F));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(JuDaMod.MOD_ID, name), material.get());
    }
}
