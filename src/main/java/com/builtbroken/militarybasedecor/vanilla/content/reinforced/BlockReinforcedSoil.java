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
public class BlockReinforcedSoil extends BlockReinforced
{
    public static float RESISTANCE_SCALE = 5;

    public BlockReinforcedSoil()
    {
        super(Material.ground, "reinforcedSoil");
        this.setStepSound(soundTypeWood);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        super.registerBlockIcons(iconRegister);
        //TODO use block textures that this block mimics
        //TOOD add overlay on render to render edge of block as 2px wood frame
        this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().replace("tile.", ""));
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

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (ReinforcedSoilMeta type : ReinforcedSoilMeta.values())
        {
            list.add(new ItemStack(item, 1, type.ordinal()));
        }
    }

    /**
     * Sub types for this block
     */
    public static enum ReinforcedSoilMeta
    {
        DIRT(Blocks.dirt),
        SAND(Blocks.sand),
        GRASS(Blocks.grass);

        public final float hardness;
        public final float base_resistance;

        private ReinforcedSoilMeta(Block block)
        {
            hardness = BlockUtility.getBlockHardness(block);
            base_resistance = BlockUtility.getBlockResistance(block);
        }

        private ReinforcedSoilMeta(float hardness, float base_resistance)
        {
            this.hardness = hardness;
            this.base_resistance = base_resistance;
        }
    }
}
