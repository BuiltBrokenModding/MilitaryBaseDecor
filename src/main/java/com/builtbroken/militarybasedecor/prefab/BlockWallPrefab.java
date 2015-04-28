package com.builtbroken.militarybasedecor.prefab;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.util.IIcon;

/**
 * Created by Ole on 4/28/2015.
 */
public class BlockWallPrefab extends BlockWall {

    @SideOnly(Side.CLIENT)
    private IIcon[] field_150033_a;

    public BlockWallPrefab(Block block)
    {
        super(block);
    }
}