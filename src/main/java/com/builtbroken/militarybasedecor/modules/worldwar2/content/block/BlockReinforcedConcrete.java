package com.builtbroken.militarybasedecor.modules.worldwar2.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Ole on 24.01.2016.
 */
public class BlockReinforcedConcrete extends Block {

    public BlockReinforcedConcrete() {
        super(Material.rock);
        this.setHardness(20);
        this.setResistance(175);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName("concrete_reinforced");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "concrete_reinforced");
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);

    }
}
