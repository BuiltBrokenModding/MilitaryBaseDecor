package com.builtbroken.militarybasedecor.vanilla.content.item.tool;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Ole on 5/16/2015.
 */
public class ItemWireCutters extends Item {

    public ItemWireCutters() {
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
        this.setNoRepair();
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + "Vanilla Module");
    }
}
