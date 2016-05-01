package com.builtbroken.militarybasedecor.modules.vanilla.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Ole on 24.01.2016.
 */
public class BlockBasicConcrete extends Block {

    public BlockBasicConcrete() {
        super(Material.rock);
        this.setHardness(15);
        this.setResistance(150);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName("concrete_basic");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "concrete_basic");
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
    }
}
