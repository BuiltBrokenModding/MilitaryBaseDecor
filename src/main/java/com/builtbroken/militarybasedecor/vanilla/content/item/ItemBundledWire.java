package com.builtbroken.militarybasedecor.vanilla.content.item;

import java.util.List;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

public class ItemBundledWire extends Item {
	
	 public ItemBundledWire()
	    {}
	    
	    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	    {
	    	list.add(EnumChatFormatting.BLUE + "Vanilla Module");
	    }
}
