package com.builtbroken.militarybasedecor.modules.vanilla.content.item;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ole on 7/22/2015.
 */
public class VanillaItems extends Item {

    public VanillaItems() {
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + "Vanilla Module");
    }
}
