package de.dar1rojumaen.juda.jumaen.enchantment;

import com.mojang.serialization.MapCodec;
import de.dar1rojumaen.juda.JuDaMod;
import de.dar1rojumaen.juda.jumaen.enchantment.custom.JuCloudBootsEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JuModEnchantmentEffects {

    public static final MapCodec<? extends EnchantmentEntityEffect> CLOUD_JUMP =
            registerEntityEffect("cloud_jump", JuCloudBootsEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(
            String name, MapCodec<? extends  EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(JuDaMod.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        JuDaMod.LOGGER.info("Registering JuMaEn Mod Enchantment Effects for " + JuDaMod.MOD_ID);
    }
}
