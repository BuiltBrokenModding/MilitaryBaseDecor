package com.builtbroken.militarybasedecor.civilwar.content;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by Ole on 26.01.2015.
 */

public class BlockPicketFence extends BlockPane {

    public BlockPicketFence()
    {
        super("militarybasedecor:picketFence", "militarybasedecor:picketFence", Material.wood, true);
        this.setBlockName("picketFence");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "picketFence");
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }
}

