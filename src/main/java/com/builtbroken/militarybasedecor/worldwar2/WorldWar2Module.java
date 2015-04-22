package com.builtbroken.militarybasedecor.worldwar2;

import java.awt.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.coldwar.content.block.BlockAsphalt;
import com.builtbroken.militarybasedecor.coldwar.content.block.BlockBarbedWire;
import com.builtbroken.militarybasedecor.coldwar.content.block.BlockReinforcedRail;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldWar2Module extends AbstractLoadable
{

	public static Item chocolate;
	
    @Override
    public void preInit()
    {
    	if (MilitaryBaseDecor.CHOCOLATE_ENABLED) {
    	chocolate = MilitaryBaseDecor.INSTANCE.getManager().newItem("chocolate", new ItemFood(0, 0F, false).setPotionEffect(20, 60, 1, 1F).setTextureName(MilitaryBaseDecor.DOMAIN + "chocolate").setUnlocalizedName("chocolate").setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB));
    	}
    }
    
    @Override
    public void postInit()
    {
    }
}

