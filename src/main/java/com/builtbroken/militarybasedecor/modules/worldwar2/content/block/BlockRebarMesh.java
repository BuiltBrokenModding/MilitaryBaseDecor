package com.builtbroken.militarybasedecor.modules.worldwar2.content.block;

import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.worldwar1.WorldWar1Module;
import com.builtbroken.militarybasedecor.modules.worldwar2.WorldWar2Module;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by henna on 31.12.2016.
 */
public class BlockRebarMesh extends Block implements IRecipeContainer {

    public BlockRebarMesh() {
        super(Material.iron);
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "rebar_mesh");
        this.setStepSound(Block.soundTypeMetal);
        this.setBlockName("rebar_mesh");
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {

        if (world.isRemote) {
            return true;
        } else {
            ItemStack itemstack = player.inventory.getCurrentItem();

            if (itemstack == null) {
                return true;
            } else {
                if (itemstack.getItem() == WorldWar1Module.liquidConcreteBucket) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.bucket));
                        world.setBlock(x, y, z, WorldWar2Module.reinforcedConcrete);
                }
                return true;
            }
        }
    }

    @Override
    public void genRecipes(List<IRecipe> recipes)
    {
        GameRegistry.addShapedRecipe(new ItemStack(this, 3, 0), "RRR", "RRR", "RRR", 'R', WorldWar2Module.rebar);
    }
}