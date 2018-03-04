package com.builtbroken.militarybasedecor;

import com.builtbroken.militarybasedecor.core.MBDCreativeTab;
import com.builtbroken.militarybasedecor.core.handler.MBDGuiHandler;
import com.builtbroken.militarybasedecor.core.handler.RegistryHandler;
import com.builtbroken.militarybasedecor.core.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = MilitaryBaseDecor.MODID, name = MilitaryBaseDecor.NAME, version = MilitaryBaseDecor.VERSION)
public class MilitaryBaseDecor {

    public static final String MODID = "militarybasedecor";
    public static final String NAME = "Military Base Decor";
    public static final String VERSION = "@MC@.@MAJOR@.@MINOR@.@REVIS@.@BUILD@";
    public static final String PREFIX = MODID + ":";

    private static Logger logger;

    @Mod.Instance("militarybasedecor")
    public static MilitaryBaseDecor INSTANCE;

    @SidedProxy(clientSide = "com.builtbroken.militarybasedecor.core.proxy.ClientProxy", serverSide = "com.builtbroken.militarybasedecor.core.proxy.CommonProxy")

    public static CommonProxy PROXY;

    public static final CreativeTabs MILITARYBASEDECORTAB = new MBDCreativeTab("militarybasedecor");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(RegistryHandler.class);
        logger = event.getModLog();
        RegistryHandler.preInitRegistries();
        PROXY.preInit(event);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new MBDGuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        RegistryHandler.initRegistries();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        RegistryHandler.postInitRegistries();
    }
}