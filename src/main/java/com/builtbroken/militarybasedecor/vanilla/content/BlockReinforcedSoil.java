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
import net.minecraft.world.World;
import scala.reflect.internal.Types;

import java.util.List;

/**
 * Created by Ole on 23.01.2015.
 */
public class BlockReinforcedSoil extends Block {

    public BlockReinforcedSoil()
    {
        super(Material.ground);
        this.setBlockName("reinforcedSoil");
        this.setBlockTextureName("reinforcedSoil");
        this.setHardness(2.5F);
        this.setResistance(35);
        this.setStepSound(Block.soundTypeWood);
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
    public float getBlockHardness(World world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        if(meta < SubTypes.values().length)
        {
            return SubTypes.values()[meta].hardness;
        }
        return this.blockHardness;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for(SubTypes type : SubTypes.values())
        {
            list.add(new ItemStack(item, 1, type.ordinal()));
        }
    }

    /**
     * Sub types for this block
     */
    public static enum SubTypes
    {
        DIRT(Blocks.dirt),
        SAND(Blocks.sand),
        GRASS(Blocks.grass);

        public final float hardness;
        public final float base_resistance;

        private SubTypes(Block block)
        {
            hardness = BlockUtility.getBlockHardness(block);
            base_resistance = BlockUtility.getBlockResistance(block);
        }

        private SubTypes(float hardness, float base_resistance)
        {
            this.hardness = hardness;
            this.base_resistance = base_resistance;
        }
    }
}
