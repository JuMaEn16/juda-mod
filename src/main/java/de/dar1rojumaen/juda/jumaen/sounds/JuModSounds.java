package de.dar1rojumaen.juda.jumaen.sounds;

import de.dar1rojumaen.juda.JuDaMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class JuModSounds {
    public static final SoundEvent DOUBLE_JUMP = registerSoundEvent("double_jump");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(JuDaMod.MOD_ID, name);
        SoundEvent soundEvent = SoundEvent.of(id);
        return Registry.register(Registries.SOUND_EVENT, id, soundEvent);
    }

    public static void register() {
        //Registry.register(Registries.SOUND_EVENT, DOUBLE_JUMP.getId(), DOUBLE_JUMP);
    }
}
