package com.builtbroken.militarybasedecor.vanilla.content.item;

import java.util.List;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Ole on 09.02.2015.
 */
public class ItemBagCement extends Item {

    public ItemBagCement()
    {
        this.setUnlocalizedName("bagCement");
        this.setTextureName(MilitaryBaseDecor.PREFIX + "bag_cement");
        this.setMaxStackSize(1);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }
    
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
    	list.add(EnumChatFormatting.BLUE + "Vanilla Module");
    }
}
