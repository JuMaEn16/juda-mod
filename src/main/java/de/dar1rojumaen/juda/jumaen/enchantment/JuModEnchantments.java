package de.dar1rojumaen.juda.jumaen.enchantment;


import de.dar1rojumaen.juda.JuDaMod;
import de.dar1rojumaen.juda.jumaen.enchantment.custom.JuCloudBootsEffect;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class JuModEnchantments {

    public static final RegistryKey<Enchantment> CLOUD_JUMP =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(JuDaMod.MOD_ID, "cloud_jump"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, CLOUD_JUMP, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.FOOT_ARMOR),
                        5,
                        2,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        8,
                        AttributeModifierSlot.FEET))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET)));
    }


    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
