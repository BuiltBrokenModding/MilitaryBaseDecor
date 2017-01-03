package com.builtbroken.militarybasedecor.modules.blastcraft.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * Created by Ole on 13.01.2016.
 */
public class BlockBlastProofBrick extends Block
{
    public BlockBlastProofBrick()
    {
        super(Material.rock);
        this.setBlockName("blast_proof_block");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "blastcraft/blast_proof_brick");
        this.setHardness(50f);
        this.setResistance(6000000.0F);
        this.setCreativeTab(MilitaryBaseDecor.MAIN_TAB);
    }

    // Gives the block the right color on minimaps and vanilla maps.
    @Override
    public MapColor getMapColor(int p_149728_1_)
    {
        return MapColor.blackColor;
    }
    
    @Override		
 -    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)		
 -    {		
 -        return false;		
 -    }		
 -		
 -    @Override		
 -    public void onBlockExploded(World world, int x, int y, int z, Explosion explosion)		
 -    {		
 -    }		
 -		
 -    @Override		
 -    public boolean canDropFromExplosion(Explosion p_149659_1_)		
 -    {		
 -        return false;		
 -    }
}
