package com.builtbroken.militarybasedecor.coldwar.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Ole on 10.02.2015.
 */
public class BlockAsphalt extends Block {

    public BlockAsphalt() {
        super(Material.rock);
        this.setBlockName("asphalt");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "asphalt");
        this.setHardness(2.8f);
        this.setResistance(18);
        this.setStepSound(Block.soundTypeStone);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }
}
