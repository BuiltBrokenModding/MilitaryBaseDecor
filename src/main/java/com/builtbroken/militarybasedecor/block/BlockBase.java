package com.builtbroken.militarybasedecor.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.init.MBDInit;
import com.builtbroken.militarybasedecor.util.IIModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IIModel {

    public BlockBase(String name, Material material, MapColor mapColor, SoundType soundType) {
        super(material, mapColor);
        setUnlocalizedName(name);
        setRegistryName(name);
        blockSoundType = soundType;
        MBDInit.BLOCKS.add(this);
        MBDInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        setCreativeTab(MilitaryBaseDecor.MILITARTYBASEDECORTAB);
    }

    @Override
    public void registerModels() {
       MilitaryBaseDecor.PROXY.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}