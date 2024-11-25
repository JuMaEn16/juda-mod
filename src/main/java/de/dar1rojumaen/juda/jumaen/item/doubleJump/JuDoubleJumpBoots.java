package de.dar1rojumaen.juda.jumaen.item.doubleJump;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class JuDoubleJumpBoots extends ArmorItem {
    public JuDoubleJumpBoots(RegistryEntry<ArmorMaterial> material, Settings settings) {
        super(material, Type.BOOTS, settings);
    }

    @Override
    public AttributeModifiersComponent getAttributeModifiers() {
        AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
        AttributeModifierSlot attributeModifierSlot = AttributeModifierSlot.forEquipmentSlot(this.getType().getEquipmentSlot());

        // Add default armor modifiers
        builder.add(
                EntityAttributes.GENERIC_ARMOR,
                new EntityAttributeModifier(
                        Identifier.ofVanilla("armor.boots"),
                        this.getMaterial().value().getProtection(this.getType()),
                        EntityAttributeModifier.Operation.ADD_VALUE
                ),
                attributeModifierSlot
        );

        // Add a custom safe fall distance attribute
        builder.add(
                EntityAttributes.GENERIC_SAFE_FALL_DISTANCE,
                new EntityAttributeModifier(
                        Identifier.ofVanilla("armor.safe_fall"),
                        10.0, // Add 10 extra blocks to safe fall distance
                        EntityAttributeModifier.Operation.ADD_VALUE
                ),
                attributeModifierSlot
        );

        return builder.build();
    }
}