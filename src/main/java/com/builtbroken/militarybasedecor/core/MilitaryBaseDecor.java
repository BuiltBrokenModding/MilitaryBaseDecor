package com.builtbroken.militarybasedecor.core;

import com.builtbroken.mc.core.Engine;
import com.builtbroken.mc.lib.mod.AbstractMod;
import com.builtbroken.mc.lib.mod.ModCreativeTab;
import com.builtbroken.militarybasedecor.client.MBDCreativeTab;
import com.builtbroken.militarybasedecor.modules.blastcraft.Blastcraft;
import com.builtbroken.militarybasedecor.modules.coldwar.ColdWarModule;
import com.builtbroken.militarybasedecor.modules.future.FutureModule;
import com.builtbroken.militarybasedecor.modules.gunpowder.GunpowderModule;
import com.builtbroken.militarybasedecor.modules.vanilla.VanillaModule;
import com.builtbroken.militarybasedecor.modules.worldwar1.WorldWar1Module;
import com.builtbroken.militarybasedecor.modules.worldwar2.WorldWar2Module;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by robert on 11/18/2014.
 */
@Mod(modid = MilitaryBaseDecor.DOMAIN, name = "Military Base Decor", version = "@MAJOR@.@MINOR@.@REVIS@.@BUILD@", dependencies = "required-after:voltzengine")
public final class MilitaryBaseDecor extends AbstractMod
{

    /** Mod ID and asset file name */
    public static final String DOMAIN = "militarybasedecor";
    /** Prefix to place in from resource locations to load from the mod's asset folder */
    public static final String PREFIX = DOMAIN + ":";
    /** Path to the models folder */
    public static final String MODEL_PATH = "models/";

    @Mod.Instance(DOMAIN)
    public static MilitaryBaseDecor INSTANCE;

    @SidedProxy(clientSide = "com.builtbroken.militarybasedecor.client.ClientProxy", serverSide = "com.builtbroken.militarybasedecor.core.CommonProxy")
    public static CommonProxy proxy;

    /** Primary creative tab for the mod */
    public static ModCreativeTab MAIN_TAB;

    public MilitaryBaseDecor()
    {
        super(DOMAIN, "MilitaryBaseDecor");
        MAIN_TAB = new MBDCreativeTab();
    }

    @Override
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        Engine.requestOres();
        Engine.requestResources();
        Engine.requestCircuits();
        Engine.requestCraftingParts();

        super.preInit(event);
        getManager().setTab(MAIN_TAB);
        ConfigManager.initConfig();
        loader.applyModule(VanillaModule.class, ConfigManager.VANILLA_ENABLED);
        loader.applyModule(GunpowderModule.class, ConfigManager.GUNPOWDER_ERA_ENABLED);
        loader.applyModule(WorldWar1Module.class, ConfigManager.WORLD_WAR_ONE_ENABLED);
        loader.applyModule(WorldWar2Module.class, ConfigManager.WORLD_WAR_TWO_ENABLED);
        loader.applyModule(ColdWarModule.class, ConfigManager.COLD_WAR_ENABLED);
        loader.applyModule(FutureModule.class, ConfigManager.FUTURE_ENABLED);
        loader.applyModule(Blastcraft.class, ConfigManager.BLASTCRAFT_ENABLED);
    }

    @Override
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }

    @Override
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
