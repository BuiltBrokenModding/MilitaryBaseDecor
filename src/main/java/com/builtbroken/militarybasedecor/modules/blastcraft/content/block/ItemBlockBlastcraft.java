package com.builtbroken.militarybasedecor.modules.blastcraft.content.block;

import com.builtbroken.mc.prefab.tile.item.ItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ole on 13.01.2016.
 */
public class ItemBlockBlastcraft extends ItemBlockMetadata
{

    public ItemBlockBlastcraft(Block block)
    {
        super(block);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add(EnumChatFormatting.BLUE + "Blastcraft");
    }
}
