package com.builtbroken.militarybasedecor.coldwar.content;

import net.minecraft.item.ItemStack;
import resonant.lib.prefab.item.ItemTooltip;

public class ItemBlockSpikes extends ItemTooltip
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
