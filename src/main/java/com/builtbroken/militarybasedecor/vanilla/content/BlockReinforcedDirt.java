package com.builtbroken.militarybasedecor.vanilla.content;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by Ole on 23.01.2015.
 */
public class BlockReinforcedDirt extends Block {

    public BlockReinforcedDirt()
    {
        super(Material.ground);
        this.setBlockName("reinforcedDirt");
        this.setBlockTextureName("reinforcedDirt");
        this.setHardness(2.5F);
        this.setResistance(35);
        this.setStepSound(BlockButton.soundTypeWood); // Dirt???
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
