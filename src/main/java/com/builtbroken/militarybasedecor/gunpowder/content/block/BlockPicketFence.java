package com.builtbroken.militarybasedecor.gunpowder.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

/**
 * Created by Ole on 26.01.2015.
 */

public class BlockPicketFence extends BlockPane {

    public BlockPicketFence() {
        super("militarybasedecor:picket_fence", "militarybasedecor:picket_fence_top", Material.wood, true);
        this.setBlockName("picket_fence");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "picket_fence");
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }
}