package com.builtbroken.militarybasedecor.core.handler;

import com.builtbroken.militarybasedecor.content.tile.TileEntityAmmoCrate;
import com.builtbroken.militarybasedecor.core.util.IIModel;
import com.builtbroken.militarybasedecor.content.init.MBDInit;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Collection;

@Mod.EventBusSubscriber
public class RegistryHandler {

    private static Multimap<Class<?>, IForgeRegistryEntry<?>> soundEntries = MultimapBuilder.hashKeys().arrayListValues().build();

    public static <T extends IForgeRegistryEntry<T>> void registerSounds(IForgeRegistryEntry<T> obj) {
        soundEntries.put(obj.getRegistryType(), obj);
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(MBDInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(MBDInit.BLOCKS.toArray(new Block[0]));
        GameRegistry.registerTileEntity(TileEntityAmmoCrate.class, MBDInit.BLOCK_AMMO_CRATE.getRegistryName().toString());
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for(Item item : MBDInit.ITEMS) {
            if(item instanceof IIModel) {
                ((IIModel)item).registerModels();
            }
        }

        for(Block block : MBDInit.BLOCKS) {
            if(block instanceof IIModel) {
                ((IIModel)block).registerModels();
            }
        }
    }

    @SubscribeEvent
    public static void onSoundRegister(RegistryEvent.Register event) {
        Class<?> type = event.getRegistry().getRegistrySuperType();

        if(soundEntries.containsKey(type)) {
            Collection<IForgeRegistryEntry<?>> ourEntries = soundEntries.get(type);
            for(IForgeRegistryEntry<?> entry : ourEntries)
                event.getRegistry().register(entry);
        }
    }

    public static void preInitRegistries() {}

    public static void initRegistries() {}

    public static void postInitRegistries() {}
}