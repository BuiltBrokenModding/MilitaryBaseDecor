package com.builtbroken.militarybasedecor.managers;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

/**
 * Created by Ole on 27.09.2015.
 */
public class ConfigManager {

    public static boolean VANILLA_ENABLED = true;
    public static boolean GUNPOWDER_ERA_ENABLED = true;
    public static boolean COLD_WAR_ENABLED = true;
    public static boolean WORLD_WAR_ONE_ENABLED = true;
    public static boolean WORLD_WAR_TWO_ENABLED = true;
    public static boolean FUTURE_ENABLED = true;

    public static boolean CHOCOLATE_ENABLED = true;

    public static void initConfig() {
        VANILLA_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable Vanilla Module", "Modules", true, "Enables/Disables the Vanilla module.");
        GUNPOWDER_ERA_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable Civil War Module", "Modules", true, "Enables/Disables the Civil War module.");
        COLD_WAR_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable Cold War Module", "Modules", true, "Enables/Disables the Cold War module.");
        WORLD_WAR_ONE_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable WW1 Module", "Modules", true, "Enables/Disables the WW1 module.");
        WORLD_WAR_TWO_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable WW2 Module", "Modules", true, "Enables/Disables the WW2 module.");
        FUTURE_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable Future Module", "Modules", true, "Enables/Disables the Future module.");

        if (WORLD_WAR_TWO_ENABLED) {
            CHOCOLATE_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable Chocolate", "Settings", false, "Should the chocolate item(joke item) be enabled/disabled?");
        }
    }

}
