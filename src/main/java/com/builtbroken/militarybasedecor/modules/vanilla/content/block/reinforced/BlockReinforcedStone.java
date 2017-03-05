package com.builtbroken.militarybasedecor.modules.vanilla.content.block.reinforced;

import com.builtbroken.mc.lib.helper.BlockUtility;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * Created by Ole on 23.01.2015.
 */
public class BlockReinforcedStone extends BlockReinforced
{
    public static float RESISTANCE_SCALE = 5;

    @SideOnly(Side.CLIENT)
    private IIcon[] texture;

    final static String[] subBlocks = new String[]{"cobblestone", "stone", "stonebrick"};

    public BlockReinforcedStone()
    {
        super(Material.rock, "reinforced_stone");
        this.setStepSound(soundTypeStone);
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "reinforced_stone");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        return texture[metadata];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        texture = new IIcon[subBlocks.length];

        for (int i = 0; i < subBlocks.length; i++)
        {
            texture[i] = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "reinforced_stone_" + subBlocks[i]);
        }
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

    @Override
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
    public enum ReinforcedStoneMeta
    {
        COBBLE(Blocks.cobblestone),
        STONE(Blocks.stone),
        BRICK(Blocks.stonebrick);

        public final float hardness;
        public final float base_resistance;

        ReinforcedStoneMeta(Block block)
        {
            hardness = BlockUtility.getBlockHardness(block);
            base_resistance = BlockUtility.getBlockResistance(block);
        }

        ReinforcedStoneMeta(float hardness, float base_resistance)
        {
            this.hardness = hardness;
            this.base_resistance = base_resistance;
        }
    }
}