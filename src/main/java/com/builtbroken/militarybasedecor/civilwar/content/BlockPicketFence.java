package com.builtbroken.militarybasedecor.civilwar.content;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by Ole on 26.01.2015.
 */

// TODO fix crashes on block placement!
public class BlockPicketFence extends BlockPane {

    public BlockPicketFence()
    {
        super("militarybasedecor:BlockPicketFence", "militarybasedecor:BlockPicketFence", Material.iron, true);
        this.setBlockName("picketFence");
        this.setBlockTextureName("picketFence");
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().replace("tile.", ""));
    }
}

