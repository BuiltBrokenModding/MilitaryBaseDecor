package com.builtbroken.militarybasedecor.coldwar.content;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBlockSpikes extends Item
{
    public ItemBlockSpikes(int par1)
    {
        super();
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        return this.getUnlocalizedName() + "." + itemstack.getItemDamage();
    }
}
