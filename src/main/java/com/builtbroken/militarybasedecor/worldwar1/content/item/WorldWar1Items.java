package com.builtbroken.militarybasedecor.worldwar1.content.item;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ole on 7/22/2015.
 */
public class WorldWar1Items extends Item {

    public WorldWar1Items() {
        super();
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + "WW1 Module");
    }
}