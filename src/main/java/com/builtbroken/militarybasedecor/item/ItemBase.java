package com.builtbroken.militarybasedecor.item;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.init.MBDInit;
import com.builtbroken.militarybasedecor.util.IIModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IIModel {

    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        MBDInit.ITEMS.add(this);
        setCreativeTab(MilitaryBaseDecor.MILITARTYBASEDECORTAB);
    }

    @Override
    public void registerModels()
    {
        MilitaryBaseDecor.PROXY.registerItemRenderer(this, 0, "inventory");
    }
}
