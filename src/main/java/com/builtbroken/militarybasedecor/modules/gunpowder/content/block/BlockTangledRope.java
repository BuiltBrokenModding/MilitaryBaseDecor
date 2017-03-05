package com.builtbroken.militarybasedecor.modules.gunpowder.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.gunpowder.GunpowderModule;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Random;

public class BlockTangledRope extends Block
{
    public BlockTangledRope()
    {
        super(Material.cloth);
        this.setHardness(1.0F);
        this.setResistance(7.0F);
        this.setBlockName("tangled_rope");
        this.setStepSound(soundTypeCloth);
        this.setBlockTextureName(MilitaryBaseDecor.DOMAIN + ":" + "tangled_rope");
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return GunpowderModule.rope;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return random.nextInt(4) + 1;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        entity.setInWeb();
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

    @Override
    public int getRenderType()
    {
        return 1;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    protected boolean canSilkHarvest()
    {
        return true;
    }
}