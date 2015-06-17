package com.builtbroken.militarybasedecor.worldwar2.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Ole on 6/17/2015.
 */
public class BlockAmmunitionBox extends Block {

    public BlockAmmunitionBox() {
        super(Material.iron);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
        this.setBlockName("ammunition_box");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "ammunition_box");
        this.setHardness(1);
        this.setResistance(1);
        this.setStepSound(Block.soundTypeMetal);
    }
}
