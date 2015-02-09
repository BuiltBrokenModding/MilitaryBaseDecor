package com.builtbroken.militarybasedecor.coldwar.content;

import java.util.List;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockConcrete extends Block
{
    private IIcon iconReinforced, iconPlated, iconDark, iconDecor;

    public BlockConcrete()
    {
        super(Material.rock);
        this.setBlockName("concrete");
        this.setBlockTextureName("concrete");
        this.setHardness(3.8f);
        this.setResistance(28);
        this.setStepSound(Block.soundTypeMetal);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }

    @Override
    public IIcon getIcon(int side, int metadata)
    {
        switch (metadata)
        {
            case 1:
                return this.iconPlated;
            case 2:
                return this.iconReinforced;
            case 3:
                return this.iconDark;
            case 4:
                return this.iconDecor;
        }

        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        super.registerBlockIcons(iconRegister);

        this.iconPlated = iconRegister.registerIcon(this.getTextureName().replace("tile.", "") + "Plated");
        this.iconReinforced = iconRegister.registerIcon(this.getTextureName().replace("tile.", "") + "Reinforced");
        this.iconDark = iconRegister.registerIcon(this.getTextureName().replace("tile.", "") + "Dark");
        this.iconDecor = iconRegister.registerIcon(this.getUnlocalizedName().replace("tile.", "") + "Decor");

    }

    @Override
    public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
    {
        int metadata = world.getBlockMetadata(x, y, z);

        switch (metadata)
        {
            case 1:
                return 48;
            case 2:
                return 38;
            case 3:
                return 28;
            case 4:
                return 28;
        }

        return this.getExplosionResistance(par1Entity);
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