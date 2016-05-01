package com.builtbroken.militarybasedecor.modules.worldwar2.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Ole on 6/17/2015.
 * TODO Make a one slot storage GUI for any item from Armory.
 */
public class BlockAmmunitionBox extends Block {

    public BlockAmmunitionBox() {
        super(Material.iron);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
        this.setBlockName("ammunition_box");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "ammunition_box");
        this.setHardness(1);
        this.setResistance(1);
        this.setStepSound(Block.soundTypeMetal);
    }
}
