package com.builtbroken.militarybasedecor.worldwar2.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Ole on 6/8/2015.
 */
public class BlockCorrugatedGalvanisedIron extends Block {

    public BlockCorrugatedGalvanisedIron() {
        super(Material.iron);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "corrugated_galvanised_iron_block");
        this.setHardness(1);
        this.setResistance(1);
        this.setStepSound(Block.soundTypeMetal);
    }
}
