package com.builtbroken.militarybasedecor;

import com.builtbroken.militarybasedecor.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MilitaryBaseDecor.MODID, name = MilitaryBaseDecor.NAME, version = MilitaryBaseDecor.VERSION)
public class MilitaryBaseDecor {

    public static final String MODID = "militarybasedecor";
    public static final String NAME = "Military Base Decor";
    public static final String VERSION = "0.0.1";

    private static Logger logger;

    @Mod.Instance("militarybasedecor")
    public static MilitaryBaseDecor INSTANCE;

    @SidedProxy(clientSide = "com.builtbroken.militarybasedecor.proxy.ClientProxy", serverSide = "com.builtbroken.militarybasedecor.proxy.CommonProxy")

    public static CommonProxy PROXY;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    
    }
}