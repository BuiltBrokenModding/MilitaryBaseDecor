package com.builtbroken.militarybasedecor.modules.blastcraft.content.block;

import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.blastcraft.Blastcraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blog/development/license.md"></a> for what you can and can't do with the code.
 * Created by Hennamann(Henry) on 08/01/2017.
 */
public class BlockCarbonPlatedWalling extends Block implements IRecipeContainer{

    public BlockCarbonPlatedWalling()
    {
        super(Material.rock);
        this.setBlockName("carbon_plated_walling");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "blastcraft/carbon_plated_walling");
        this.setHardness(85);
        this.setResistance(6000000.0F);
    }

    @Override
    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
    {
        return false;
    }

    @Override
    public void onBlockExploded(World world, int x, int y, int z, Explosion explosion)
    {}

    @Override
    public boolean canDropFromExplosion(Explosion p_149659_1_)
    {
        return false;
    }

    @Override
    public void genRecipes(List<IRecipe> recipes) {
        GameRegistry.addShapedRecipe(new ItemStack(this, 12, 0), "CBC", "CBC", "CBC", 'C', Items.coal, 'B', Blastcraft.blastProofWalling);
    }
}
