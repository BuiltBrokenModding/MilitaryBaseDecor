package com.builtbroken.militarybasedecor.vanilla.content.block;

import java.util.List;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

	/**
	 * Created by Ole on 3.11.2015.
	 */
	public class BlockWiredFence extends BlockPane {
		
	    public BlockWiredFence(String texture1, String texture2, Material material, boolean bool)
	    {
	        super(texture1, texture2, material, bool);
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



