package com.builtbroken.militarybasedecor.gunpowder.content.block;

import java.util.Random;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.gunpowder.GunpowderModule;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockTangledRope extends Block {

	public BlockTangledRope()
    {
        super(Material.cloth);
        this.setHardness(1.0F);
        this.setResistance(7.0F);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
        this.setBlockName("tangled_rope");
        this.setStepSound(soundTypeCloth);
        this.setBlockTextureName(MilitaryBaseDecor.DOMAIN + ":" + "tangled_rope");
    }

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return GunpowderModule.rope;
    }
	
	public int quantityDropped(Random random)
    {
        return random.nextInt(4) + 1;
    }
	
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
    		entity.setInWeb();
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
    }

    public int getRenderType()
    {
        return 1;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    protected boolean canSilkHarvest()
    {
        return true;
    }
}