package com.builtbroken.militarybasedecor.modules.gunpowder.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.IBlockAccess;

public class BlockRopeFence extends BlockPane
{

    public BlockRopeFence()
    {
        super("militarybasedecor:rope_fence", "militarybasedecor:rope_fence_top", Material.wood, true);
        this.setBlockName("rope_fence");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "rope_fence");
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
    }

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
        return true;
    }
}