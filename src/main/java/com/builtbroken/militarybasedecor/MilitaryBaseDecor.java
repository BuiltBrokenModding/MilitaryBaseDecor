package com.builtbroken.militarybasedecor;

import com.builtbroken.mc.lib.mod.AbstractMod;
import com.builtbroken.militarybasedecor.coldwar.ColdWarModule;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by robert on 11/18/2014.
 */
public class MilitaryBaseDecor extends AbstractMod
{
    public static final String MOD_ID = "militarybasedecor";
    public static final String MOD_NAME = "Military Base Decor";
    public static final String DOMAIN = MOD_ID;
    public static final String PREFIX = MOD_ID + ":";

    @Mod.Instance(MOD_ID)
    public static MilitaryBaseDecor INSTANCE;

    @SidedProxy(clientSide = "com.builtbroken.militarybasedecor.ClientProxy", serverSide = "com.builtbroken.militarybasedecor.CommonProxy")
    private CommonProxy proxy;

    //@Mod.Metadata(MOD_ID)
    //private ModMetadata meta;



    public MilitaryBaseDecor()
    {
        super(DOMAIN);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        loader.applyModule(ColdWarModule.class, getConfig().getBoolean("ColdWar", "LoadModule", true, ""));
        loader.applyModule(VanillaModule.class, getConfig().getBoolean("Vanilla", "LoadModule", true, ""));
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
