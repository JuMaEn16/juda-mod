package de.dar1rojumaen.juda.jumaen.item.doubleJump;

import de.dar1rojumaen.juda.jumaen.item.JuModItems;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
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

        if (!wearingCustomBoots) {
            // Reset state if the boots are not equipped
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
            // If the player is airborne and hasn't double-jumped yet
            if (client.options.jumpKey.isPressed()) {
                if (!jumpKeyWasPressed && jumpReleasedAfterFirstJump) {
                    // Perform the double jump with directional boost

                    // Get the player's movement input (forward/backward and sideways)
                    float forward = player.input.movementForward;  // Forward input (-1 to 1)
                    float sideways = player.input.movementSideways;  // Sideways input (-1 to 1)

                    // Calculate the movement direction relative to the player's yaw
                    float yaw = player.getYaw(); // Player's yaw (rotation around the Y axis)
                    double radians = Math.toRadians(yaw);

                    // Forward movement direction vector (player's facing direction)
                    Vec3d forwardVec = new Vec3d(-Math.sin(radians), 0, Math.cos(radians));

                    // Right movement direction vector (perpendicular to forward)
                    Vec3d rightVec = new Vec3d(Math.cos(radians), 0, Math.sin(radians));

                    // Combine the forward and sideways vectors based on input
                    Vec3d direction = forwardVec.multiply(forward).add(rightVec.multiply(sideways));

                    // Normalize direction to prevent speed boost inconsistency
                    if (direction.lengthSquared() > 0.01) {
                        direction = direction.normalize();
                    } else {
                        // If there's no significant movement input, default to forward direction
                        direction = forwardVec; // Default to moving forward
                    }

                    // Get the player's pitch (looking up/down)
                    float pitch = player.getPitch(); // Negative for looking down, positive for looking up

                    // If the player is looking up (positive pitch), apply positive vertical boost
                    double verticalBoostFactor = 0.7 + (pitch / 90.0) * -0.6; // Increase boost with pitch


                    // Apply the boost
                    Vec3d boost = direction.multiply(0.8).add(new Vec3d(0, verticalBoostFactor, 0)); // Apply both horizontal and vertical boost
                    player.setVelocity(player.getVelocity().add(boost));
                    player.velocityModified = true; // Ensure velocity change is applied

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
}