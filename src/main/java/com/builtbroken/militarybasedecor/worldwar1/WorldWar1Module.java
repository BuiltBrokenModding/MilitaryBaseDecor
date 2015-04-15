package com.builtbroken.militarybasedecor.worldwar1;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.coldwar.content.BlockAsphalt;
import com.builtbroken.militarybasedecor.coldwar.content.BlockBarbedWire;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import com.builtbroken.militarybasedecor.worldwar1.content.BlockAdvancedSandbag;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldWar1Module extends AbstractLoadable {
	
	public static Block advancedSandBag;
	
	 	@Override
	    public void preInit()
	    {
	 		// TODO Create integration with the Armory mod(when we get to making it...) advancedSandBag = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAdvancedSandbag.class);
	    }
	 	
	 	@Override 
	 	public void postInit()
	 	{
	 	// TODO Create integration with the Armory mod(when we get to making it...) GameRegistry.addShapedRecipe(new ItemStack(advancedSandBag, 1, 0), new Object[]{"WWW", "WSW", "WWW", 'W', Blocks.wool, 'S', VanillaModule.sandBag});
	 	}

}
