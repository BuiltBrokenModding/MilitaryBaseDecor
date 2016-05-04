package com.builtbroken.militarybasedecor.modules.vanilla.content.item.tool;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ole on 5/16/2015.
 */
public class ItemWireCutters extends Item
{

    public ItemWireCutters()
    {
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
        this.setNoRepair();
        this.setCreativeTab(MilitaryBaseDecor.MAIN_TAB);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add(EnumChatFormatting.BLUE + "Vanilla Module");
    }
}
