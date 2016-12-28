package com.builtbroken.militarybasedecor.core;

/**
 * Created by Ole on 27.09.2015.
 */
public class ConfigManager
{

    public static boolean VANILLA_ENABLED = true;
    public static boolean GUNPOWDER_ERA_ENABLED = true;
    public static boolean COLD_WAR_ENABLED = true;
    public static boolean WORLD_WAR_ONE_ENABLED = true;
    public static boolean WORLD_WAR_TWO_ENABLED = true;
    public static boolean FUTURE_ENABLED = true;
    public static boolean BLASTCRAFT_ENABLED = true;
    public static boolean WIRECUTTERS_CHAT = true;

    public static void initConfig()
    {
        VANILLA_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable Vanilla Module", "Modules", true, "Enables/Disables the Vanilla module.");
        GUNPOWDER_ERA_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable Civil War Module", "Modules", true, "Enables/Disables the Civil War module.");
        COLD_WAR_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable Cold War Module", "Modules", true, "Enables/Disables the Cold War module.");
        WORLD_WAR_ONE_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable WW1 Module", "Modules", true, "Enables/Disables the WW1 module.");
        WORLD_WAR_TWO_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable WW2 Module", "Modules", true, "Enables/Disables the WW2 module.");
        FUTURE_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable Future Module", "Modules", true, "Enables/Disables the Future module.");
        BLASTCRAFT_ENABLED = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable Blastcraft", "Modules", true, "Enables/Disables the Blastcraft Module");
        WIRECUTTERS_CHAT = MilitaryBaseDecor.INSTANCE.getConfig().getBoolean("Enable Wire Cutters chat message", "Items", true, "Enables/Disables wire cutters chat messagess");
    }

}