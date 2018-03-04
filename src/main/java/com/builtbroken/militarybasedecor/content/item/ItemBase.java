package com.builtbroken.militarybasedecor.content.item;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.content.init.MBDInit;
import com.builtbroken.militarybasedecor.core.util.IIModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IIModel {

    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        MBDInit.ITEMS.add(this);
        setCreativeTab(MilitaryBaseDecor.MILITARYBASEDECORTAB);
    }

    @Override
    public void registerModels()
    {
        MilitaryBaseDecor.PROXY.registerItemRenderer(this, 0, "inventory");
    }
}
