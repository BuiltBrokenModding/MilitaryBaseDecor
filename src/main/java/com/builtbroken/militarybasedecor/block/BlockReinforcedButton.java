package com.builtbroken.militarybasedecor.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.init.MBDInit;
import net.minecraft.block.BlockButtonStone;
import net.minecraft.item.ItemBlock;

public class BlockReinforcedButton extends BlockButtonStone {

    public BlockReinforcedButton(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(MilitaryBaseDecor.MILITARTYBASEDECORTAB);
        setHardness(2.5F);
        setResistance(35);
        MBDInit.BLOCKS.add(this);
        MBDInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
}
