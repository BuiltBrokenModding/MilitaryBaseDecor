package com.builtbroken.militarybasedecor.modules.worldwar1.content.block;

import com.builtbroken.mc.prefab.tile.item.ItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemBlockWorldWar1 extends ItemBlockMetadata
{

    public ItemBlockWorldWar1(Block block)
    {
        super(block);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add(EnumChatFormatting.BLUE + "WW1 Module");
    }

}
