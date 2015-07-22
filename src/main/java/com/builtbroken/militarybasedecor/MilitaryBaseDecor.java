package com.builtbroken.militarybasedecor;

import com.builtbroken.mc.lib.mod.AbstractMod;
import com.builtbroken.mc.lib.mod.ModCreativeTab;
import com.builtbroken.militarybasedecor.coldwar.ColdWarModule;
import com.builtbroken.militarybasedecor.future.FutureModule;
import com.builtbroken.militarybasedecor.gunpowder.GunpowderModule;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import com.builtbroken.militarybasedecor.worldwar1.WorldWar1Module;
import com.builtbroken.militarybasedecor.worldwar2.WorldWar2Module;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by robert on 11/18/2014.
 */
@Mod(modid = MilitaryBaseDecor.DOMAIN, name = MilitaryBaseDecor.NAME, version = MilitaryBaseDecor.VERSION, dependencies = "required-after:VoltzEngine")
public final class MilitaryBaseDecor extends AbstractMod {
    /**
     * Name of the channel and mod ID.
     */
    public static final String NAME = "Military Base Decor";
    public static final String DOMAIN = "militarybasedecor";
    public static final String PREFIX = DOMAIN + ":";

    /**
     * The version of MilitaryBaseDecor.
     */
    public static final String MAJOR_VERSION = "@MAJOR@";
    public static final String MINOR_VERSION = "@MINOR@";
    public static final String REVISION_VERSION = "@REVIS@";
    public static final String BUILD_VERSION = "@BUILD@";
    public static final String VERSION = MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + "." + BUILD_VERSION;

    public static final String ASSETS_PATH = "/assets/militarybasedecor/";
    public static final String TEXTURE_PATH = "textures/";
    public static final String GUI_PATH = TEXTURE_PATH + "gui/";
    public static final String MODEL_PATH = "models/";
    public static final String MODEL_DIRECTORY = ASSETS_PATH + MODEL_PATH;

    public static final String MODEL_TEXTURE_PATH = TEXTURE_PATH + MODEL_PATH;
    public static final String BLOCK_PATH = TEXTURE_PATH + "blocks/";
    public static final String ITEM_PATH = TEXTURE_PATH + "items/";

    @Mod.Instance(DOMAIN)
    public static MilitaryBaseDecor INSTANCE;

    @SidedProxy(clientSide = "com.builtbroken.militarybasedecor.ClientProxy", serverSide = "com.builtbroken.militarybasedecor.CommonProxy")
    public static CommonProxy proxy;

    public static boolean VANILLA_ENABLED = true;
    public static boolean GUNPOWDER_ERA_ENABLED = true;
    public static boolean COLD_WAR_ENABLED = true;
    public static boolean WORLD_WAR_ONE_ENABLED = true;
    public static boolean WORLD_WAR_TWO_ENABLED = true;
    public static boolean FUTURE_ENABLED = true;

    public static boolean CHOCOLATE_ENABLED = true;

    public static ModCreativeTab CREATIVE_TAB;

    public MilitaryBaseDecor() {
        super(DOMAIN, "MilitaryBaseDecor");
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        CREATIVE_TAB = new ModCreativeTab("MilitaryBaseDecor");
        CREATIVE_TAB.itemSorter = new ModCreativeTab.NameSorter(); // Temporary Solution to an nullexception error on creativetab rendering. TODO Rearrange the creative tab sorting system.
        getManager().setTab(CREATIVE_TAB);

        // Config
        VANILLA_ENABLED = getConfig().getBoolean("Enable Vanilla Module", "Modules", true, "Enables/Disables the Vanilla module.");
        GUNPOWDER_ERA_ENABLED = getConfig().getBoolean("Enable Civil War Module", "Modules", true, "Enables/Disables the Civil War module.");
        COLD_WAR_ENABLED = getConfig().getBoolean("Enable Cold War Module", "Modules", true, "Enables/Disables the Cold War module.");
        WORLD_WAR_ONE_ENABLED = getConfig().getBoolean("Enable WW1 Module", "Modules", true, "Enables/Disables the WW1 module.");
        WORLD_WAR_TWO_ENABLED = getConfig().getBoolean("Enable WW2 Module", "Modules", true, "Enables/Disables the WW2 module.");
        FUTURE_ENABLED = getConfig().getBoolean("Enable Future Module", "Modules", true, "Enables/Disables the Future module.");

        if (WORLD_WAR_TWO_ENABLED) {
            CHOCOLATE_ENABLED = getConfig().getBoolean("Enable Chocolate", "Settings", false, "Should the chocolate item(joke item) be enabled/disabled?");
        }

        // Module Loading
        if (VANILLA_ENABLED) {
            loader.applyModule(new VanillaModule());
        }

        if (GUNPOWDER_ERA_ENABLED) {
            loader.applyModule(new GunpowderModule());
        }

        if (WORLD_WAR_ONE_ENABLED) {
            loader.applyModule(new WorldWar1Module());
        }

        if (WORLD_WAR_TWO_ENABLED) {
            loader.applyModule(new WorldWar2Module());
        }

        if (COLD_WAR_ENABLED) {
            loader.applyModule(new ColdWarModule());
        }

        if (FUTURE_ENABLED) {
            loader.applyModule(new FutureModule());
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public CommonProxy getProxy() {
        return proxy;
    }
}
