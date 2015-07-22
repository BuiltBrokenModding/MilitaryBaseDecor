package com.builtbroken.militarybasedecor.vanilla.content.item;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemRustyIronIngot extends Item {

    public ItemRustyIronIngot() {
        this.setUnlocalizedName("rusty_iron_ingot");
        this.setTextureName(MilitaryBaseDecor.PREFIX + "rusty_iron_ingot");
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + "Vanilla Module");
    }

}
