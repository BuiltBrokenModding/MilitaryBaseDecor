package com.builtbroken.militarybasedecor.future.content.block;

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
 * Created by Ole on 4/27/2015.
 */
public class BlockGroundLight extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon[] texture;

    final static String[] subBlocks = new String[]{"smooth", "cobble", "bricks"};

    public BlockGroundLight() {
        super(Material.rock);
        this.setBlockName("stone_light");
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
        this.setLightLevel(1.5F);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {

        texture = new IIcon[subBlocks.length];

        for (int i = 0; i < subBlocks.length; i++) {
            texture[i] = iconRegister.registerIcon(MilitaryBaseDecor.DOMAIN + ":" + "stone_light_" + subBlocks[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs creativetabs, List list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        return texture[meta];
    }
}