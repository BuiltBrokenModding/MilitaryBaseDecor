package com.builtbroken.militarybasedecor.modules.gunpowder.content.item;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * Created by Ole on 7/22/2015.
 */
public class GunpowderItems extends Item
{

    public GunpowderItems()
    {
        this.setCreativeTab(MilitaryBaseDecor.MAIN_TAB);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add(EnumChatFormatting.BLUE + StatCollector.translateToLocal("tooltip.gunpowder"));
    }
}