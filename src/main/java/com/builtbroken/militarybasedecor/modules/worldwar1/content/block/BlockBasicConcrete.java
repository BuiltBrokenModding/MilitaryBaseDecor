package com.builtbroken.militarybasedecor.modules.worldwar1.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Ole on 24.01.2016.
 */
public class BlockBasicConcrete extends Block
{
    public BlockBasicConcrete()
    {
        super(Material.rock);
        this.setHardness(15);
        this.setResistance(100);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName("concrete_basic");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "concrete_basic");
        this.setCreativeTab(MilitaryBaseDecor.MAIN_TAB);
    }
}
