package com.builtbroken.militarybasedecor.core.proxy;

import com.builtbroken.militarybasedecor.core.handler.MBDSoundHandler;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void registerItemRenderer(Item item, int meta, String id) {}

    public void preInit(FMLPreInitializationEvent event) {
        MBDSoundHandler.init();
    }
}