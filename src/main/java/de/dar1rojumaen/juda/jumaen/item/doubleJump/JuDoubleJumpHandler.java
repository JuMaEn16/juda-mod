package de.dar1rojumaen.juda.jumaen.item.doubleJump;

import de.dar1rojumaen.juda.jumaen.item.JuModItems;
import de.dar1rojumaen.juda.jumaen.sounds.JuModSounds;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.Vec3d;

public class JuDoubleJumpHandler {
    private static boolean canDoubleJump = false; // Tracks if the player can perform a second jump
    private static boolean hasDoubleJumped = false; // Tracks if the second jump has been used
    private static boolean jumpKeyWasPressed = false; // Tracks the state of the jump key in the previous tick
    private static boolean jumpReleasedAfterFirstJump = false; // Ensures space is released after the first jump

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(JuDoubleJumpHandler::onClientTick);
    }

    private static void onClientTick(MinecraftClient client) {
        ClientPlayerEntity player = client.player;
        if (player == null || !player.isAlive()) return;

        // Check if the player is wearing the custom boots
        ItemStack boots = player.getInventory().getArmorStack(0);
        boolean wearingCustomBoots = boots.getItem() == JuModItems.VOIDITE_BOOTS;
        boolean hasCloudJumpEnchantment = boots.hasEnchantments() &&
                boots.getEnchantments().toString().contains("cloud_jump");

        if (!wearingCustomBoots && !hasCloudJumpEnchantment) {
            // Reset state if neither the boots nor the enchantment are present
            canDoubleJump = false;
            hasDoubleJumped = false;
            jumpReleasedAfterFirstJump = false;
            return;
        }

        if (player.isOnGround()) {
            // Reset jump states when on the ground
            canDoubleJump = true;
            hasDoubleJumped = false;
            jumpReleasedAfterFirstJump = false; // Reset this when the player lands
        } else if (canDoubleJump && !hasDoubleJumped) {
            if (client.options.jumpKey.isPressed()) {
                if (!jumpKeyWasPressed && jumpReleasedAfterFirstJump) {
                    // Prioritize Voidite Boots Double Jump first if boots are equipped
                    if (wearingCustomBoots) {
                        performVoiditeDoubleJump(player);
                    }
                    hasDoubleJumped = true; // Mark the double jump as used
                }
            } else {
                // If the jump key is released, mark it for the next press
                jumpReleasedAfterFirstJump = true;
            }
        }

        // Update the jump key state for the next tick
        jumpKeyWasPressed = client.options.jumpKey.isPressed();
    }

    private static void performVoiditeDoubleJump(ClientPlayerEntity player) {
        // Voidite Boots Double Jump Logic - no change to velocity calculation
        double yaw = Math.toRadians(player.getYaw());
        Vec3d direction = new Vec3d(-Math.sin(yaw), 0, Math.cos(yaw));  // Direction based on yaw

        // Get the player's movement input and apply the directional boost
        float forward = player.input.movementForward;  // Forward input (-1 to 1)
        float sideways = player.input.movementSideways;  // Sideways input (-1 to 1)

        Vec3d forwardVec = new Vec3d(-Math.sin(yaw), 0, Math.cos(yaw)); // Forward direction vector
        Vec3d rightVec = new Vec3d(Math.cos(yaw), 0, Math.sin(yaw)); // Rightward direction vector

        // Combine the input with the direction
        Vec3d combinedDirection = forwardVec.multiply(forward).add(rightVec.multiply(sideways));

        // Normalize to avoid speed inconsistencies
        if (combinedDirection.lengthSquared() > 0.01) {
            combinedDirection = combinedDirection.normalize();
        } else {
            combinedDirection = forwardVec;  // Default to forward direction
        }

        // Get the player's pitch (vertical look angle)
        float pitch = player.getPitch(); // Negative for looking down, positive for looking up

        // Calculate a vertical boost based on pitch
        double verticalBoostFactor = 0.7 + (pitch / 90.0) * -0.6; // Increase boost with pitch

        // Apply horizontal and vertical boost to velocity
        Vec3d boost = combinedDirection.multiply(0.8).add(new Vec3d(0, verticalBoostFactor, 0));
        player.setVelocity(player.getVelocity().add(boost));
        player.velocityModified = true;

        // Play Voidite Boots sound
        player.getWorld().playSound(
                player,
                player.getBlockPos(),
                JuModSounds.DOUBLE_JUMP,
                SoundCategory.PLAYERS,
                1.0F,
                1.0F
        );
    }

    private static void performCloudJump(ClientPlayerEntity player) {
        // Original Cloud Jump logic
        Vec3d boost = new Vec3d(0, 0.5, 0); // Simple upward boost
        player.setVelocity(player.getVelocity().add(boost));
        player.velocityModified = true;

        // Optional: Play sound or particles
        //player.getWorld().playSound(
        //        player,
        //        player.getBlockPos(),
        //        JuModSounds.CLOUD_JUMP,
        //        SoundCategory.PLAYERS,
        //        0.8F,
        //        1.2F
        //);
    }
}