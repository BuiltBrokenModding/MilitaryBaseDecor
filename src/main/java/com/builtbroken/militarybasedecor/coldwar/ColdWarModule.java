package com.builtbroken.militarybasedecor.coldwar;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.mc.lib.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.coldwar.content.block.BlockAsphalt;
import com.builtbroken.militarybasedecor.coldwar.content.block.BlockReinforcedRail;
import com.builtbroken.militarybasedecor.coldwar.content.block.ItemBlockColdWar;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import com.builtbroken.militarybasedecor.vanilla.content.block.BlockBasicConcrete;

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
    public static Block reinforcedRail;

    @Override
    public void preInit()
    {
        asphalt = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAsphalt.class, ItemBlockColdWar.class);
        reinforcedRail = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedRail.class, ItemBlockColdWar.class);
    }
    
    @Override
    public void postInit()
    {
    	// Blocks
    	// Asphalt
    	if (MilitaryBaseDecor.VANILLA_ENABLED) { // Temp solution until we have a complete recipe system figured out!
        GameRegistry.addShapelessRecipe(new ItemStack(asphalt, 1, 0), new Object[]{VanillaModule.basicConcrete, new ItemStack(Items.dye, 1, 0)});
        // Reinforced Rail
        GameRegistry.addShapelessRecipe(new ItemStack(reinforcedRail, 1, 0), new Object[]{VanillaModule.basicConcrete, Blocks.rail});
    	}  
    }
}
