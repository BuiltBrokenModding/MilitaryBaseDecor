package com.builtbroken.militarybasedecor.handler;

import com.builtbroken.militarybasedecor.util.IIModel;
import com.builtbroken.militarybasedecor.init.MBDInit;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler
{
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(MBDInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(MBDInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for(Item item : MBDInit.ITEMS) {
            if(item instanceof IIModel) {
                ((IIModel)item).registerModels();
            }
        }

        for(Block block : MBDInit.BLOCKS)
        {
            if(block instanceof IIModel)
            {
                ((IIModel)block).registerModels();
            }
        }
    }

    public static void preInitRegistries() {
    }

    public static void initRegistries() {
    }

    public static void postInitRegistries() {}
}