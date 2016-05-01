package com.builtbroken.militarybasedecor.modules.worldwar2.content.block;

import com.builtbroken.mc.prefab.tile.item.ItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ole on 6/17/2015.
 */
public class ItemBlockCorrugatedGalvanisedIron extends ItemBlockMetadata {

    public ItemBlockCorrugatedGalvanisedIron(Block block) {
        super(block);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + "WW2 Module");
        list.add(EnumChatFormatting.ITALIC + "Used to create Quonset huts");
    }

}
