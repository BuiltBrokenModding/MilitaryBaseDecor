package com.builtbroken.militarybasedecor.worldwar1;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.worldwar1.content.block.BlockBarbedWireFence;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import com.builtbroken.militarybasedecor.worldwar1.content.block.BlockAdvancedSandbag;
import com.builtbroken.militarybasedecor.worldwar1.content.block.BlockConcertinaWire;
import com.builtbroken.militarybasedecor.worldwar1.content.block.ItemBlockWorldWar1;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldWar1Module extends AbstractLoadable {
	
	public static Block advancedSandBag;
	public static Block barbedWireFence;
	public static Block concertinaWire;
	
	public static Item barbedWire;
	
	 	@Override
	    public void preInit()
	    {
	 		barbedWireFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBarbedWireFence.class, ItemBlockWorldWar1.class);
	 		concertinaWire = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockConcertinaWire.class, ItemBlockWorldWar1.class);
	 		// TODO Create integration with the Armory mod(when we get to making it...) advancedSandBag = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAdvancedSandbag.class, ItemBlockWorldWar1.class);
	    }
	 	
	 	@Override 
	 	public void postInit()
	 	{
	 	// TODO Create integration with the Armory mod(when we get to making it...) GameRegistry.addShapedRecipe(new ItemStack(advancedSandBag, 1, 0), new Object[]{"WWW", "WSW", "WWW", 'W', Blocks.wool, 'S', VanillaModule.sandBag});
	 	
	 		// Blocks
	 		// Barbed Wire Fence
	 		 GameRegistry.addShapedRecipe(new ItemStack(barbedWireFence, 8, 0), new Object[]{"FFF", "FWF", "FFF", 'F', Items.flint, 'W', VanillaModule.wiredFence});
	 	}

}
