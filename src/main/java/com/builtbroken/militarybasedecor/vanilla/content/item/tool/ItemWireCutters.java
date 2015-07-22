package com.builtbroken.militarybasedecor.vanilla.content.item.tool;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Ole on 5/16/2015.
 */
public class ItemWireCutters extends Item {

    public ItemWireCutters() {
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }

    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        return false;
    }

}
