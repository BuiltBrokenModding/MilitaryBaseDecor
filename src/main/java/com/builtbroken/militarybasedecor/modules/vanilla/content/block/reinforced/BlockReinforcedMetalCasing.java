package com.builtbroken.militarybasedecor.modules.vanilla.content.block.reinforced;

import com.builtbroken.mc.lib.helper.BlockUtility;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;

import java.util.List;

/**
 * Created by Ole Henrik Stabell on 27.12.2016.
 */
public class BlockReinforcedMetalCasing extends BlockReinforced
{
    public BlockReinforcedMetalCasing()
    {
        super(Material.ground, "metal_casing");

        this.setStepSound(soundTypeMetal);
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "metal_casing");
    }

    @Override
    public float getBlockHardness(int meta)
    {
        if (meta < ReinforcedMetalCasing.values().length)
        {
            return ReinforcedMetalCasing.values()[meta].hardness;
        }
        return this.blockHardness;
    }

    @Override
    public float getBlockResistance(int meta)
    {
        if (meta < ReinforcedMetalCasing.values().length)
        {
            return ReinforcedMetalCasing.values()[meta].base_resistance;
        }
        return 35;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (ReinforcedMetalCasing type : ReinforcedMetalCasing.values())
        {
            list.add(new ItemStack(item, 1, type.ordinal()));
        }
    }

    /**
     * Sub types for this block
     */
    public enum ReinforcedMetalCasing
    {
        METAL(Blocks.planks);

        public final float hardness;
        public final float base_resistance;

        ReinforcedMetalCasing(Block block)
        {
            hardness = BlockUtility.getBlockHardness(block);
            base_resistance = BlockUtility.getBlockResistance(block);
        }

        ReinforcedMetalCasing(float hardness, float base_resistance)
        {
            this.hardness = hardness;
            this.base_resistance = base_resistance;
        }
    }

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderBlockPass()
    {
        return 0;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
}