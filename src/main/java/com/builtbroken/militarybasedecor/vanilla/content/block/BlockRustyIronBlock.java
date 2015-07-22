package com.builtbroken.militarybasedecor.vanilla.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockRustyIronBlock extends Block {

    public BlockRustyIronBlock() {
        super(Material.iron);
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal);
        this.setBlockName("rusty_iron_block");
        this.setBlockTextureName(MilitaryBaseDecor.DOMAIN + ":" + "rusty_iron_block");
    }

    public MapColor getMapColor(int p_149728_1_) {
        return MapColor.adobeColor;
    }
}
