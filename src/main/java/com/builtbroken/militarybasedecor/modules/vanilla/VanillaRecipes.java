package com.builtbroken.militarybasedecor.modules.vanilla;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Ole on 09.01.2016.
 */
public class VanillaRecipes
{
    public static void initBlockRecipes()
    {
        // Simple Camo Block
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.simpleCamoBlock, 1, 0), "VVV", "VRV", "VSV", 'V', Blocks.vine, 'R', Items.redstone, 'S', Blocks.stone);
    }
}

