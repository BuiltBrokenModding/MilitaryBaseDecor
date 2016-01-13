package com.builtbroken.militarybasedecor.vanilla.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBasicSandBag extends Block {

    public BlockBasicSandBag() {
        super(Material.cloth);
        this.setBlockName("sand_bag");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "sand_bag");
        this.setHardness(0.5f);
        this.setResistance(1);
        this.setStepSound(Block.soundTypeCloth);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
    }

}
