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
public class BlockReinforcedSoil extends BlockReinforced
{
    public static float RESISTANCE_SCALE = 5;

    @SideOnly(Side.CLIENT)
    private IIcon[] texture;

    final static String[] subBlocks = new String[]{"dirt", "sand", "grass"};

    public BlockReinforcedSoil()
    {
        super(Material.ground, "reinforced_soil");
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(MilitaryBaseDecor.MAIN_TAB);
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
            texture[i] = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "reinforced_soil_" + subBlocks[i]);
        }
    }

    @Override
    public float getBlockHardness(int meta)
    {
        if (meta < ReinforcedSoilMeta.values().length)
        {
            return ReinforcedSoilMeta.values()[meta].hardness;
        }
        return this.blockHardness;
    }

    @Override
    public float getBlockResistance(int meta)
    {
        if (meta < ReinforcedSoilMeta.values().length)
        {
            return ReinforcedSoilMeta.values()[meta].base_resistance * RESISTANCE_SCALE;
        }
        return 35;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
    {

        for (int i = 0; i < subBlocks.length; i++)
        {
            list.add(new ItemStack(block, 1, i));
        }
    }

    /**
     * Sub types for this block
     */
    public enum ReinforcedSoilMeta
    {
        DIRT(Blocks.dirt),
        SAND(Blocks.sand),
        GRASS(Blocks.grass);

        public final float hardness;
        public final float base_resistance;

        ReinforcedSoilMeta(Block block)
        {
            hardness = BlockUtility.getBlockHardness(block);
            base_resistance = BlockUtility.getBlockResistance(block);
        }

        ReinforcedSoilMeta(float hardness, float base_resistance)
        {
            this.hardness = hardness;
            this.base_resistance = base_resistance;
        }
    }
}
