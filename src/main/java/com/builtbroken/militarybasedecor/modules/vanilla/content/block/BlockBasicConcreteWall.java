package com.builtbroken.militarybasedecor.modules.vanilla.content.block;

import com.builtbroken.militarybasedecor.modules.vanilla.VanillaModule;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * Created by Ole on 4/28/2015.
 */
public class BlockBasicConcreteWall extends BlockWall {

    public BlockBasicConcreteWall(Block p_i45435_1_) {
        super(p_i45435_1_);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return VanillaModule.basicConcrete.getBlockTextureFromSide(p_149691_1_);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
    }
}