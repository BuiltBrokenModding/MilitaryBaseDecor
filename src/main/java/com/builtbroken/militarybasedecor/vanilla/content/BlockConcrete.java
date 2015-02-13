package com.builtbroken.militarybasedecor.vanilla.content;

import java.util.List;

import com.builtbroken.mc.lib.helper.BlockUtility;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Vanilla version of concrete that is very basic but contains sub colors
 * Created by robert on 2/12/2015.
 */
public class BlockConcrete extends Block
{
    public BlockConcrete()
    {
        super(Material.rock);
        this.setBlockName("concrete");
        this.setBlockTextureName("concrete");
        this.setHardness(15);
        this.setResistance(150);
        this.setStepSound(Block.soundTypeStone);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }
}