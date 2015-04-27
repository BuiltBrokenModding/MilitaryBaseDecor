package com.builtbroken.militarybasedecor.future.content.block;

import com.builtbroken.mc.prefab.tile.item.ItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ole on 4/27/2015.
 */
public class ItemBlockFuture extends ItemBlockMetadata {

    public ItemBlockFuture(Block block) {
        super(block);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add(EnumChatFormatting.BLUE + "Future Module");
    }
}
