package com.builtbroken.militarybasedecor.core.handler;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 04/03/2018.
 */
public final class MBDSoundHandler {

    public static SoundEvent openAmmoCrate;

    public static void init() {
        openAmmoCrate = register("open_ammo_crate");
    }

    public static SoundEvent register(String name) {
        ResourceLocation loc = new ResourceLocation(MilitaryBaseDecor.PREFIX + name);
        SoundEvent e = new SoundEvent(loc).setRegistryName(loc);

        RegistryHandler.registerSounds(e);
        return e;
    }
}