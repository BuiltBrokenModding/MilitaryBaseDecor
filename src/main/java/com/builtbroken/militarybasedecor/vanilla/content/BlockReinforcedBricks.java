package com.builtbroken.militarybasedecor.vanilla.content;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by Ole on 23.01.2015.
 */
public class BlockReinforcedBricks extends Block {

    public BlockReinforcedBricks()
    {
        super(Material.rock);
        this.setBlockName("reinforcedBricks");
        this.setBlockTextureName("reinforcedBricks");
        this.setHardness(3.0F);
        this.setResistance(40);
        this.setStepSound(BlockButton.soundTypeStone);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        super.registerBlockIcons(iconRegister);

        this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().replace("tile.", ""));
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return false;
    }
}



