package com.builtbroken.militarybasedecor.gunpowder.content.block;

import java.util.List;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Ole on 26.01.2015.
 */

public class BlockPicketFence extends BlockPane {

    public BlockPicketFence()
    {
        super("militarybasedecor:picket_fence", "militarybasedecor:picket_fence", Material.wood, true);
        this.setBlockName("picket_fence");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "picket_fence");
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }
}

