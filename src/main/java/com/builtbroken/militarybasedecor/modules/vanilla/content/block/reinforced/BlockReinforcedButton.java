package com.builtbroken.militarybasedecor.modules.vanilla.content.block.reinforced;

import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.vanilla.VanillaModule;
import com.builtbroken.militarybasedecor.modules.worldwar1.WorldWar1Module;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockButton;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by olehenrikstabell on 31/07/16.
 */
public class BlockReinforcedButton extends BlockButton implements IRecipeContainer{

    public BlockReinforcedButton() {
        super(false);
        this.setBlockName("reinforced_button");
        this.setHardness(2.5F);
        this.setResistance(35);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(null);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return WorldWar1Module.basicConcrete.getBlockTextureFromSide(1);
    }

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
        GameRegistry.addShapelessRecipe(new ItemStack(this, 1, 0), WorldWar1Module.basicConcrete);
    }
}