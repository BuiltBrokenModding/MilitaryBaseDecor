package com.builtbroken.militarybasedecor.vanilla.content.reinforced;

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
 * Created by Ole on 23.01.2015.
 */
public class BlockReinforcedStone extends BlockReinforced
{
    public static float RESISTANCE_SCALE = 5;

    public BlockReinforcedStone()
    {
        super(Material.rock, "reinforcedStone");
        this.setStepSound(soundTypeStone);
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
        if (meta < ReinforcedStoneMeta.values().length)
        {
            return ReinforcedStoneMeta.values()[meta].hardness;
        }
        return this.blockHardness;
    }

    @Override
    public float getBlockResistance(int meta)
    {
        if (meta < ReinforcedStoneMeta.values().length)
        {
            return ReinforcedStoneMeta.values()[meta].base_resistance * RESISTANCE_SCALE;
        }
        return 35;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (ReinforcedStoneMeta type : ReinforcedStoneMeta.values())
        {
            list.add(new ItemStack(item, 1, type.ordinal()));
        }
    }

    /**
     * Sub types for this block
     */
    public static enum ReinforcedStoneMeta
    {
        STONE(Blocks.stone),
        BRICK(Blocks.stonebrick);

        public final float hardness;
        public final float base_resistance;

        private ReinforcedStoneMeta(Block block)
        {
            hardness = BlockUtility.getBlockHardness(block);
            base_resistance = BlockUtility.getBlockResistance(block);
        }

        private ReinforcedStoneMeta(float hardness, float base_resistance)
        {
            this.hardness = hardness;
            this.base_resistance = base_resistance;
        }
    }
}



