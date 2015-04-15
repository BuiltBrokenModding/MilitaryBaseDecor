package com.builtbroken.militarybasedecor.coldwar.content;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Ole on 10.02.2015.
 */
public class BlockAsphalt extends Block {

    public BlockAsphalt()
    {
        super(Material.rock);
        this.setBlockName("asphalt");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "asphalt");
        this.setHardness(2.8f);
        this.setResistance(18);
        this.setStepSound(Block.soundTypeStone);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }
}
