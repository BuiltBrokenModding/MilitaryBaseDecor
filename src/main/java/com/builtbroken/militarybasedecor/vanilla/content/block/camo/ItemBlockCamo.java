package com.builtbroken.militarybasedecor.vanilla.content.block.camo;

import java.util.List;

import com.builtbroken.mc.prefab.tile.item.ItemBlockMetadata;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by robert on 1/25/2015.
 */
public class ItemBlockCamo extends ItemBlockMetadata
{
    public ItemBlockCamo(Block block)
    {
        super(block);
        this.setHasSubtypes(true);
    }
    
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
    	list.add(EnumChatFormatting.BLUE + "Vanilla Module");
    }
    
}
