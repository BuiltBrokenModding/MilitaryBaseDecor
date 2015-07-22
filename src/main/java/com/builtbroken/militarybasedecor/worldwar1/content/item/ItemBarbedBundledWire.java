package com.builtbroken.militarybasedecor.worldwar1.content.item;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ole on 5/17/2015.
 */
public class ItemBarbedBundledWire extends Item {

    public ItemBarbedBundledWire() {
        super();
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
        this.setTextureName(MilitaryBaseDecor.PREFIX + "barbed_bundled_wire");
    }


    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + "WW1 Module");
    }
}
