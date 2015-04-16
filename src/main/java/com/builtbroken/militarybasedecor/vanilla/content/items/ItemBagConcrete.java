package com.builtbroken.militarybasedecor.vanilla.content.items;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

/**
 * Created by Ole on 09.02.2015.
 */
public class ItemBagConcrete extends Item {

    public ItemBagConcrete()
    {
        this.setUnlocalizedName("bagConcrete");
        this.setTextureName(MilitaryBaseDecor.PREFIX + "bag_concrete");
        this.setMaxStackSize(1);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }
}
