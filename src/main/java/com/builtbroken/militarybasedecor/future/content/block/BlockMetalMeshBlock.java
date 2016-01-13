package com.builtbroken.militarybasedecor.future.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Ole on 09.01.2016.
 */
public class BlockMetalMeshBlock extends Block {

    public BlockMetalMeshBlock() {
        super(Material.iron);
        this.setBlockName("metal_mesh_block");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "metal_mesh_block");
        this.setHardness(2.5f);
        this.setResistance(1);
        this.setStepSound(Block.soundTypeMetal);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderBlockPass() {
        return 0;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}
