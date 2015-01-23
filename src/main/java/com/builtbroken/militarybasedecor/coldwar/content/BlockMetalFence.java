package com.builtbroken.militarybasedecor.coldwar.content;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;

/**
 * Created by Ole on 23.01.2015.
 */
public class BlockMetalFence extends BlockFence {

    public BlockMetalFence(String p_i45406_1_, Material p_i45406_2_)
    {
        super(p_i45406_1_, p_i45406_2_);
        this.setBlockName("metalFence");
        this.setBlockTextureName("metalFence");
        this.setHardness(4F);
        this.setResistance(25);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(5));
    }

}
