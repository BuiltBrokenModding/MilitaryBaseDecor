package com.builtbroken.militarybasedecor.gunpowder.content.item;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemRope extends Item {

    public ItemRope() {
        this.setUnlocalizedName("rope");
        this.setTextureName(MilitaryBaseDecor.PREFIX + "rope");
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + "Gunpowder Era Module");
    }
}
