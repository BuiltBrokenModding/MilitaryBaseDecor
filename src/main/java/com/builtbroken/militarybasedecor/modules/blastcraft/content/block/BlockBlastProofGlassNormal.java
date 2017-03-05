package com.builtbroken.militarybasedecor.modules.blastcraft.content.block;

import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.blastcraft.Blastcraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/**
 * @see <a href="https://github.com/BuilBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry Stabell) on 13.01.2016 for MilitaryBaseDecor.
 */
public class BlockBlastProofGlassNormal extends Block implements IRecipeContainer {

    public BlockBlastProofGlassNormal() {
        super(Material.glass);
        this.setBlockName("blast_proof_glass_normal");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "blastcraft/blast_proof_glass/blast_proof_glass_1");
        this.setHardness(50f);
        this.setResistance(6000000.0F);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    protected boolean canSilkHarvest() {
        return true;
    }

    @Override
    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
        return false;
    }

    @Override
    public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {
    }

    @Override
    public boolean canDropFromExplosion(Explosion p_149659_1_) {
        return false;
    }

    @Override
    public void genRecipes(List<IRecipe> recipes) {
        recipes.add(newShapedRecipe(new ItemStack(this, 5, 0), "GBG", "GBG", "GBG", 'G', Blocks.glass, 'B', Blastcraft.blastProofWalling));
    }
}
