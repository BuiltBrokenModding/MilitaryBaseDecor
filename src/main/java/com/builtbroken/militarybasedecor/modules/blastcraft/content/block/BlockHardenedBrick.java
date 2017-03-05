package com.builtbroken.militarybasedecor.modules.blastcraft.content.block;

import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import java.util.List;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blog/development/license.md"></a> for what you can and can't do with the code.
 * Created by Hennamann(Henry) on 08/01/2017.
 */
public class BlockHardenedBrick extends Block implements IRecipeContainer {

    public BlockHardenedBrick()
    {
        super(Material.rock);
        this.setBlockName("hardened_brick");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "blastcraft/hardened_brick");
        this.setHardness(10);

    }

    @Override
    public void genRecipes(List<IRecipe> recipes) {
        GameRegistry.addShapedRecipe(new ItemStack(this, 12, 0), "OBO", "OBO", "OBO", 'O', Blocks.obsidian, 'B', Blocks.brick_block);
    }
}