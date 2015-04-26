package com.builtbroken.militarybasedecor.vanilla.content.block;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.IBlockAccess;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

public class BlockChainLinkFence extends BlockPane {
	
    public BlockChainLinkFence()
    {
        super("militarybasedecor:chain_link_fence", "militarybasedecor:wired_fence_top", Material.iron, true);
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
        this.setBlockName("chain_link_fence");
    }
    
    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
        return true;
    }
}
