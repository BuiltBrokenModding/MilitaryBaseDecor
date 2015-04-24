package com.builtbroken.militarybasedecor.vanilla.content.item;

import java.util.List;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemRustyIronNugget extends Item {

	public ItemRustyIronNugget()
    {
        this.setUnlocalizedName("rusty_iron_nugget");
        this.setTextureName(MilitaryBaseDecor.PREFIX + "rusty_iron_nugget");
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }
    
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
    	list.add(EnumChatFormatting.BLUE + "Vanilla Module");
    }
	
}
