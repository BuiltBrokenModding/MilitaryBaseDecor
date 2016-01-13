package com.builtbroken.militarybasedecor.blastcraft.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.prefab.BlockBlastProof;
import net.minecraft.block.material.MapColor;

/**
 * Created by Ole on 13.01.2016.
 */
public class BlockBlastProofBrick extends BlockBlastProof {

    public BlockBlastProofBrick() {
        this.setBlockName("blast_proof_block");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "blastcraft/blast_proof_brick");
    }

    // Gives the block the right color on minimaps and vanilla maps.
    public MapColor getMapColor(int p_149728_1_)
    {
        return MapColor.blackColor;
    }
}
