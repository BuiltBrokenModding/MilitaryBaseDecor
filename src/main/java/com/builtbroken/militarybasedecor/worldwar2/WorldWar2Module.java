package com.builtbroken.militarybasedecor.worldwar2;

import com.builtbroken.militarybasedecor.worldwar2.content.block.BlockCorrugatedGalvanisedIron;
import com.builtbroken.militarybasedecor.worldwar2.content.block.BlockOliveDrabTexturedBlock;
import com.builtbroken.militarybasedecor.worldwar2.content.block.ItemBlockWorldWar2;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.worldwar2.content.item.ItemChocolate;

public class WorldWar2Module extends AbstractLoadable
{

    public static Block corrugatedGalvanisedIronBlock;
    public static Block oliveDrabTexturedBlock;

	public static Item chocolate;
	
    @Override
    public void preInit()
    {
    	if (MilitaryBaseDecor.CHOCOLATE_ENABLED) {
    	chocolate = MilitaryBaseDecor.INSTANCE.getManager().newItem("chocolate", new ItemChocolate(0, 0F, false).setPotionEffect(20, 60, 1, 1F).setTextureName(MilitaryBaseDecor.DOMAIN + "chocolate").setUnlocalizedName("chocolate").setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB));
    	}

        corrugatedGalvanisedIronBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockCorrugatedGalvanisedIron.class, ItemBlockWorldWar2.class);
        oliveDrabTexturedBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockOliveDrabTexturedBlock.class, ItemBlockWorldWar2.class);

    	MilitaryBaseDecor.CREATIVE_TAB.itemStack = new ItemStack(chocolate);
    }
    
    @Override
    public void postInit()
    {
    }
}

