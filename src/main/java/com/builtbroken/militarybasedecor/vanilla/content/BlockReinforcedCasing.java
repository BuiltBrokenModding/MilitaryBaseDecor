package com.builtbroken.militarybasedecor.vanilla.content;

import com.builtbroken.mc.lib.helper.BlockUtility;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Mainly for crafting reinforced blocks, can be used as a decoration if players want
 * Created by robert on 1/24/2015.
 */
public class BlockReinforcedCasing extends BlockReinforced
{
    public BlockReinforcedCasing()
    {
        super(Material.ground, "reinforcedCasing");
        this.setStepSound(Block.soundTypeWood);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        super.registerBlockIcons(iconRegister);
        this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().replace("tile.", ""));
    }

    @Override
    public float getBlockHardness(int meta)
    {
        if (meta < ReinforcedCasing.values().length)
        {
            return ReinforcedCasing.values()[meta].hardness;
        }
        return this.blockHardness;
    }

    @Override
    public float getBlockResistance(int meta)
    {
        if (meta < ReinforcedCasing.values().length)
        {
            return ReinforcedCasing.values()[meta].base_resistance;
        }
        return 35;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (ReinforcedCasing type : ReinforcedCasing.values())
        {
            list.add(new ItemStack(item, 1, type.ordinal()));
        }
    }

    /**
     * Sub types for this block
     */
    public static enum ReinforcedCasing
    {
        WOOD(Blocks.planks);

        public final float hardness;
        public final float base_resistance;

        private ReinforcedCasing(Block block)
        {
            hardness = BlockUtility.getBlockHardness(block);
            base_resistance = BlockUtility.getBlockResistance(block);
        }

        private ReinforcedCasing(float hardness, float base_resistance)
        {
            this.hardness = hardness;
            this.base_resistance = base_resistance;
        }
    }
}
