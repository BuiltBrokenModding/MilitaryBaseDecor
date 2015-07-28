package com.builtbroken.militarybasedecor.worldwar1.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * Created by Ole on 28/07/2015.
 */
public class BlockCamouflageBlock extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon[] texture;

    final static String[] subBlocks = new String[] {"woodlands", "desert", "urban"};

    public BlockCamouflageBlock() {
        super(Material.cloth);
        this.setHardness(0.5f);
        this.setResistance(1);
        this.setStepSound(Block.soundTypeCloth);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {

        texture = new IIcon[subBlocks.length];

        for(int i = 0; i < subBlocks.length; i++) {
            texture[i] = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "camouflage_block_" + subBlocks[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {

        for (int i = 0; i < subBlocks.length; i++) {
            list.add(new ItemStack(block, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return texture[meta];
    }

}
