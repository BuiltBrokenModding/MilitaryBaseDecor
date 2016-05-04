package com.builtbroken.militarybasedecor.modules.worldwar2.content.block;

import com.builtbroken.mc.prefab.tile.item.ItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemBlockWorldWar2 extends ItemBlockMetadata
{

    public ItemBlockWorldWar2(Block block)
    {
        super(block);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add(EnumChatFormatting.BLUE + "WW2 Module");
    }

}
