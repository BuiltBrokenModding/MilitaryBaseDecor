package com.builtbroken.militarybasedecor.modules.coldwar.content.block;

import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/5/2016.
 * @author DarkGuardsman, Hennamann
 */
public class BlockICBMConcrete extends Block implements IRecipeContainer
{
    @SideOnly(Side.CLIENT)
    private IIcon[] texture;

    final static String[] subBlocks = new String[]{"normal", "compact", "reinforced", "dark"};

    public BlockICBMConcrete()
    {
        super(Material.rock);
        this.setBlockName(MilitaryBaseDecor.PREFIX + "icbm_concrete");
        this.setCreativeTab(MilitaryBaseDecor.MAIN_TAB);
        this.setResistance(50);
        this.setHardness(3.8F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {

        texture = new IIcon[subBlocks.length];

        for (int i = 0; i < subBlocks.length; i++)
        {
            texture[i] = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "icbm_concrete_" + subBlocks[i]);
        }
    }

    @Override
    public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
    {
        int metadata = world.getBlockMetadata(x, y, z);

        switch (metadata)
        {
            case 1:
                return 38;
            case 2:
                return 48;
            case 3:
                return 50;
            case 4:
                return 38;
        }

        return this.getExplosionResistance(par1Entity);
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

    @Override
    public void genRecipes(List<IRecipe> recipes)
    {
        GameRegistry.addShapedRecipe(new ItemStack(this, 8, 0), "SGS", "GWG", "SGS", 'G', Blocks.gravel, 'S', Blocks.sand, 'W', Items.water_bucket);
        GameRegistry.addShapedRecipe(new ItemStack(this, 8, 1), "COC", "OCO", "COC", 'C', new ItemStack(this, 1, 0), 'O', Blocks.obsidian);
        GameRegistry.addShapedRecipe(new ItemStack(this, 8, 2), "COC", "OCO", "COC", 'C', new ItemStack(this, 1, 1), 'O', Items.iron_ingot);
        GameRegistry.addShapelessRecipe(new ItemStack(this, 1, 3), new ItemStack(this, 1, 0), new ItemStack(Items.dye, 1, 0));
    }
}