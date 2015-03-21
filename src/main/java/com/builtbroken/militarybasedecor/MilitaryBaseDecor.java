package com.builtbroken.militarybasedecor;

import com.builtbroken.mc.lib.mod.AbstractMod;
import com.builtbroken.mc.lib.mod.ModCreativeTab;
import com.builtbroken.militarybasedecor.civilwar.CivilWarModule;
import com.builtbroken.militarybasedecor.coldwar.ColdWarModule;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import com.builtbroken.militarybasedecor.worldwar1.WorldWar1Module;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by robert on 11/18/2014.
 */
@Mod(modid = MilitaryBaseDecor.DOMAIN, name = MilitaryBaseDecor.NAME, version = MilitaryBaseDecor.VERSION, dependencies = "required-after:VoltzEngine")
public final class MilitaryBaseDecor extends AbstractMod
{
    /** Name of the channel and mod ID. */
    public static final String NAME = "Military Base Decor";
    public static final String DOMAIN = "militarybasedecor";
    public static final String PREFIX = DOMAIN + ":";

    /** The version of MilitaryBaseDecor. */
    public static final String MAJOR_VERSION = "@MAJOR@";
    public static final String MINOR_VERSION = "@MINOR@";
    public static final String REVISION_VERSION = "@REVIS@";
    public static final String BUILD_VERSION = "@BUILD@";
    public static final String VERSION = MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + "." + BUILD_VERSION;

    public static final String ASSETS_PATH = "/assets/militarybasedecor/";
    public static final String TEXTURE_PATH = "textures/";
    public static final String GUI_PATH = TEXTURE_PATH + "gui/";
    public static final String MODEL_PREFIX = "models/";
    public static final String MODEL_DIRECTORY = ASSETS_PATH + MODEL_PREFIX;

    public static final String MODEL_TEXTURE_PATH = TEXTURE_PATH + MODEL_PREFIX;
    public static final String BLOCK_PATH = TEXTURE_PATH + "blocks/";
    public static final String ITEM_PATH = TEXTURE_PATH + "items/";

    @Mod.Instance(DOMAIN)
    public static MilitaryBaseDecor INSTANCE;

    @SidedProxy(clientSide = "com.builtbroken.militarybasedecor.ClientProxy", serverSide = "com.builtbroken.militarybasedecor.CommonProxy")
    public static CommonProxy proxy;

    public static ModCreativeTab CREATIVE_TAB;

    public MilitaryBaseDecor()
    {
        super(DOMAIN, "MilitaryBaseDecor");
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);

        CREATIVE_TAB = new ModCreativeTab("MilitaryBaseDecor");
        getManager().setTab(CREATIVE_TAB);

        loader.applyModule(new ColdWarModule());
        loader.applyModule(new CivilWarModule());
        loader.applyModule(new WorldWar1Module());
        loader.applyModule(new VanillaModule());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }

    @Override
    public CommonProxy getProxy()
    {
        return proxy;
    }
}
