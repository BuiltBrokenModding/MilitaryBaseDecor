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

private IIcon iconStriped, iconCracked;

    public BlockAsphalt()
    {
        super(Material.rock);
        this.setBlockName("asphalt");
        this.setBlockTextureName("asphalt");
        this.setHardness(2.8f);
        this.setResistance(18);
        this.setStepSound(Block.soundTypeStone);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }

    @Override
    public IIcon getIcon(int side, int metadata)
    {
        switch (metadata)
        {
            case 1:
                return this.iconStriped;
            case 2:
                return this.iconCracked;
        }

        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        super.registerBlockIcons(iconRegister);

        this.iconStriped = iconRegister.registerIcon(this.getTextureName().replace("tile.", "") + "Striped");
        this.iconCracked = iconRegister.registerIcon(this.getTextureName().replace("tile.", "") + "Cracked");
    }

    @Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < 5; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return false;
    }
}
