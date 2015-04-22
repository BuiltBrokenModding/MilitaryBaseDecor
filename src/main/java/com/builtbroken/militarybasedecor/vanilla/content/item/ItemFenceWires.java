package com.builtbroken.militarybasedecor.vanilla.content.item;

import java.util.List;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemFenceWires extends Item {

	 public ItemFenceWires()
	    {
	        this.setUnlocalizedName("fenceWires");
	        this.setTextureName(MilitaryBaseDecor.PREFIX + "fence_wires");
	    }
	    
	    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	    {
	    	list.add(EnumChatFormatting.BLUE + "Vanilla Module");
	    }
	
}
