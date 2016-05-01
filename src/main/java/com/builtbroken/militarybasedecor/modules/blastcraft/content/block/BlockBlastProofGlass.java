package com.builtbroken.militarybasedecor.modules.blastcraft.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.prefab.BlockBlastProof;

/**
 * Created by Ole on 13.01.2016.
 */
public class BlockBlastProofGlass extends BlockBlastProof {

    public BlockBlastProofGlass() {
        this.setBlockName("blast_proof_glass");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "blastcraft/blast_proof_glass");
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
}
