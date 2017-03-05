package com.builtbroken.militarybasedecor.modules.worldwar2.content.block;

import com.builtbroken.mc.prefab.tile.item.ItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * Created by Ole on 6/17/2015.
 */
public class ItemBlockCorrugatedGalvanisedIron extends ItemBlockWorldWar2
{

    public ItemBlockCorrugatedGalvanisedIron(Block block)
    {
        super(block);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        super.addInformation(itemStack, player, list, par4);
        list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip.quonsethut"));
    }

}
