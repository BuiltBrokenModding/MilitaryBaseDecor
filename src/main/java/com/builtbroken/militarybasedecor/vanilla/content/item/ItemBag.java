package com.builtbroken.militarybasedecor.vanilla.content.item;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ole on 09.02.2015.
 */
public class ItemBag extends Item {

    public ItemBag() {
        this.setUnlocalizedName("Bag");
        this.setTextureName(MilitaryBaseDecor.PREFIX + "bag");
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + "Vanilla Module");
    }
}
