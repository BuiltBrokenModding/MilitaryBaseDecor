package com.builtbroken.militarybasedecor.vanilla.content.item;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemBundledWire extends Item {

    public ItemBundledWire() {
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + "Vanilla Module");
    }
}
