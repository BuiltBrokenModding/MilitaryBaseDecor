package com.builtbroken.militarybasedecor.gunpowder.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLimecrete extends Block {

    public BlockLimecrete() {
        super(Material.rock);
        this.setBlockName("limecrete");
        this.setBlockTextureName(MilitaryBaseDecor.DOMAIN + ":" + "limecrete");
        this.setHardness(2.8F);
        this.setResistance(18F);
        this.setStepSound(Block.soundTypeStone);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
    }
}
