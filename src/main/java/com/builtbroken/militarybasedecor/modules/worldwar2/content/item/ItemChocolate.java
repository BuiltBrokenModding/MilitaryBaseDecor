package com.builtbroken.militarybasedecor.modules.worldwar2.content.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemChocolate extends ItemFood {

    public ItemChocolate(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
        super(p_i45339_1_, p_i45339_3_);
    }

    public ItemChocolate(int p_i45340_1_, boolean p_i45340_2_) {
        this(p_i45340_1_, 0.6F, p_i45340_2_);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + "WW2 Module");
        list.add(EnumChatFormatting.ITALIC + "???");
    }
}
