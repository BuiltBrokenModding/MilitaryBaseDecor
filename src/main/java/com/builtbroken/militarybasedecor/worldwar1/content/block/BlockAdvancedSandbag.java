package com.builtbroken.militarybasedecor.worldwar1.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAdvancedSandbag extends Block {

    public BlockAdvancedSandbag() {
        super(Material.cloth);
        this.setBlockName("advSandBag");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "advSandBag");
        this.setHardness(1f);
        this.setResistance(1);
        this.setStepSound(Block.soundTypeCloth);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }
}

