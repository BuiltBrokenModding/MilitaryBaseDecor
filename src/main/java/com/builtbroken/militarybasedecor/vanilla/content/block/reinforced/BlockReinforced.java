package com.builtbroken.militarybasedecor.vanilla.content.block.reinforced;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

/**
 * Created by robert on 1/24/2015.
 */
public abstract class BlockReinforced extends Block
{
    public BlockReinforced(Material material, String name)
    {
        super(material);
        this.setBlockName(name);
        this.setBlockTextureName(name);
        this.setHardness(2.5F);
        this.setResistance(35);
    }

    @Override
    public float getBlockHardness(World world, int x, int y, int z)
    {
        return getBlockHardness(world.getBlockMetadata(x, y, z));
    }

    public abstract float getBlockHardness(int meta);

    @Override
    public float getExplosionResistance(Entity entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
    {
        return getBlockHardness(world.getBlockMetadata(x, y, z));
    }

    public abstract float getBlockResistance(int meta);

}
