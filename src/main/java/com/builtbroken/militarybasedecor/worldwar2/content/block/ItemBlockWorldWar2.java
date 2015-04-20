package com.builtbroken.militarybasedecor.worldwar2.content.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.builtbroken.mc.prefab.tile.item.ItemBlockMetadata;

public class ItemBlockWorldWar2 extends ItemBlockMetadata {

	public ItemBlockWorldWar2(Block block) {
		super(block);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
    	list.add(EnumChatFormatting.BLUE + "WW2 Module");
    }

}
