package com.builtbroken.militarybasedecor.vanilla.content;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.IBlockAccess;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

	/**
	 * Created by Ole on 3.11.2015.
	 */
	public class BlockWiredFence extends BlockPane {

	    public BlockWiredFence()
	    {
	        super("militarybasedecor:wired_fence", "militarybasedecor:wired_fence", Material.iron, true);
	        this.setBlockName("wired_fence");
	        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "wired_fence");
	        this.setHardness(3.0F);
	        this.setResistance(10.0F);
	        this.setStepSound(soundTypeMetal);
	        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
	    }
	    
	    @Override
	    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
	    {
	        return true;
	    }
}



