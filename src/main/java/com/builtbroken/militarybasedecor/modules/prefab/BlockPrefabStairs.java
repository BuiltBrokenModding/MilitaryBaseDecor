package com.builtbroken.militarybasedecor.modules.prefab;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

/**
 * Created by Ole on 24.01.2016.
 */
public class BlockPrefabStairs extends BlockStairs {

    public BlockPrefabStairs(Block block, int i) {
        super(block, i);
        this.lightOpacity = 0;
    }
}
