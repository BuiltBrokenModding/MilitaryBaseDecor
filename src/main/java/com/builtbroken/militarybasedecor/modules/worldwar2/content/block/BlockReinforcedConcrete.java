package com.builtbroken.militarybasedecor.modules.worldwar2.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.worldwar2.WorldWar2Module;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import org.lwjgl.Sys;

import java.util.List;
import java.util.Random;

/**
 * Created by Ole on 24.01.2016.
 */
public class BlockReinforcedConcrete extends Block
{

    @SideOnly(Side.CLIENT)
    private IIcon[] texture;

    final static String[] subBlocks = new String[]{"reinforced", "reinforced_liquid_rebar"};

    public BlockReinforcedConcrete()
    {
        super(Material.rock);
        this.setHardness(20);
        this.setResistance(40);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName("concrete_reinforced");
        this.setCreativeTab(MilitaryBaseDecor.MAIN_TAB);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        world.setBlock(x, y, z, WorldWar2Module.reinforcedConcrete);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {

        texture = new IIcon[subBlocks.length];

        for (int i = 0; i < subBlocks.length; i++)
        {
            texture[i] = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "concrete_" + subBlocks[i]);
        }
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

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return texture[meta];
    }

}