package com.builtbroken.militarybasedecor.coldwar;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.mc.lib.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.coldwar.content.BlockAsphalt;
import com.builtbroken.militarybasedecor.coldwar.content.BlockBarbedWire;
import com.builtbroken.militarybasedecor.coldwar.content.BlockReinforcedRail;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import com.builtbroken.militarybasedecor.vanilla.content.BlockConcrete;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/** Content themed after cold ware military bunkers and bases
 * Created by robert on 12/7/2014.
 */
public class ColdWarModule extends AbstractLoadable
{
    public static Block asphalt;
    public static Block barbedWire;
    public static Block reinforcedRail;

    @Override
    public void preInit()
    {
        asphalt = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAsphalt.class);
        barbedWire = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBarbedWire.class);
        reinforcedRail = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedRail.class);
    }
    
    @Override
    public void postInit()
    {
    	// Blocks
    	// Asphalt
        GameRegistry.addShapelessRecipe(new ItemStack(asphalt, 1, 0), new Object[]{VanillaModule.concrete, new ItemStack(Items.dye, 1, 0)});
        // Barbed Wire
        GameRegistry.addShapedRecipe(new ItemStack(barbedWire, 8, 0), new Object[]{"FFF", "FWF", "FFF", 'F', Items.flint, 'W', VanillaModule.wiredFence});
        // Reinforced Raik
        GameRegistry.addShapelessRecipe(new ItemStack(reinforcedRail, 1, 0), new Object[]{VanillaModule.concrete, Blocks.rail});
    }
}
