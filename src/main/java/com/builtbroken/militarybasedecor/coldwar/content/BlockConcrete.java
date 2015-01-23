package com.builtbroken.militarybasedecor.coldwar.content;

import java.util.List;

import com.builtbroken.militarybasedecor.ContentRef;
import com.builtbroken.militarybasedecor.vanilla.content.BlockButton;
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
import net.minecraft.creativetab.CreativeTabs;

public class BlockConcrete extends Block
{
    private IIcon iconCompact, iconReinforced;

    public BlockConcrete()
    {
        super(Material.rock);
        this.setBlockName("concrete");
        this.setBlockTextureName("concrete");
        this.setHardness(3.8f);
        this.setResistance(50);
        this.setStepSound(BlockButton.soundTypeMetal);
    }

    @Override
    public IIcon getIcon(int side, int metadata)
    {
        switch (metadata)
        {
            case 1:
                return this.iconCompact;
            case 2:
                return this.iconReinforced;
        }

        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        super.registerBlockIcons(iconRegister);

        this.iconCompact = iconRegister.registerIcon(this.getUnlocalizedName().replace("tile.", "") + "Compact");
        this.iconReinforced = iconRegister.registerIcon(this.getUnlocalizedName().replace("tile.", "") + "Reinforced");

    }

    @Override
    public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
    {
        int metadata = world.getBlockMetadata(x, y, z);

        switch (metadata)
        {
            case 1:
                return 38;
            case 2:
                return 48;
        }

        return this.getExplosionResistance(par1Entity);
    }

    @Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < 3; i++)
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