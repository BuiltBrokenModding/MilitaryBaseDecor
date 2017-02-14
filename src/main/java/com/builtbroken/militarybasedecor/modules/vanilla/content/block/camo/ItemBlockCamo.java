package com.builtbroken.militarybasedecor.modules.vanilla.content.block.camo;

import com.builtbroken.mc.prefab.tile.item.ItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

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

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add(EnumChatFormatting.BLUE + StatCollector.translateToLocal("tooltip.vanilla"));
    }

}
