package com.builtbroken.militarybasedecor.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.content.init.MBDInit;
import com.builtbroken.militarybasedecor.util.IIModel;
import net.minecraft.block.BlockButtonStone;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockReinforcedButton extends BlockButtonStone implements IIModel{

    public BlockReinforcedButton(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(MilitaryBaseDecor.MILITARTYBASEDECORTAB);
        setHardness(2.5F);
        setResistance(35);
        MBDInit.BLOCKS.add(this);
        MBDInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        MilitaryBaseDecor.PROXY.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
