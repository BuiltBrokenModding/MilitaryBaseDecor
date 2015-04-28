package com.builtbroken.militarybasedecor.prefab;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Ole on 4/28/2015.
 */
public class BlockColoredStairs extends BlockStairs {

    public BlockColoredStairs(Block block, int color) {
        super(block, color);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.lightOpacity = 0; // Dirty fix to stop a weird shadow bug when rendering an inside corner...
    }

}
