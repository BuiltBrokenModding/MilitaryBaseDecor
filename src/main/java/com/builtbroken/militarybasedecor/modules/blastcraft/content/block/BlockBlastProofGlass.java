package com.builtbroken.militarybasedecor.modules.blastcraft.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Ole on 13.01.2016.
 */
public class BlockBlastProofGlass extends Block
{
    public BlockBlastProofGlass()
    {
        super(Material.glass);
        this.setBlockName("blast_proof_glass");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "blastcraft/blast_proof_glass");
        this.setHardness(50f);
        this.setResistance(6000000.0F);
        this.setCreativeTab(MilitaryBaseDecor.MAIN_TAB);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    protected boolean canSilkHarvest()
    {
        return true;
    }
}
