package com.builtbroken.militarybasedecor.worldwar1;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.worldwar1.content.block.BlockBarbedWire;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import com.builtbroken.militarybasedecor.worldwar1.content.block.BlockAdvancedSandbag;
import com.builtbroken.militarybasedecor.worldwar1.content.block.ItemBlockWorldWar1;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldWar1Module extends AbstractLoadable {
	
	public static Block advancedSandBag;
	
	public static Block barbedWire;
	
	 	@Override
	    public void preInit()
	    {
	 		barbedWire = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBarbedWire.class, ItemBlockWorldWar1.class);
	 		// TODO Create integration with the Armory mod(when we get to making it...) advancedSandBag = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAdvancedSandbag.class, ItemBlockWorldWar1.class);
	    }
	 	
	 	@Override 
	 	public void postInit()
	 	{
	 	// TODO Create integration with the Armory mod(when we get to making it...) GameRegistry.addShapedRecipe(new ItemStack(advancedSandBag, 1, 0), new Object[]{"WWW", "WSW", "WWW", 'W', Blocks.wool, 'S', VanillaModule.sandBag});
	 	}

}
