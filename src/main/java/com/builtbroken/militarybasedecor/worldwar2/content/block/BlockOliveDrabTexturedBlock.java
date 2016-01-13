package com.builtbroken.militarybasedecor.worldwar2.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Ole on 6/8/2015.
 */
public class BlockOliveDrabTexturedBlock extends Block {

    public BlockOliveDrabTexturedBlock() {
        super(Material.cloth);
        this.setBlockName("olive_drab_textured_block");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "olive_drab_textured_block");
        this.setHardness(0.5f);
        this.setResistance(1);
        this.setStepSound(Block.soundTypeCloth);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
    }
}
