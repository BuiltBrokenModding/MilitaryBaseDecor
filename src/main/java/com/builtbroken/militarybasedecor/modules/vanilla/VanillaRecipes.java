package com.builtbroken.militarybasedecor.modules.vanilla;

import com.builtbroken.militarybasedecor.modules.worldwar1.WorldWar1Module;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Ole on 09.01.2016.
 */
public class VanillaRecipes
{

    public static void initItemRecipes()
    {
    }

    public static void initBlockRecipes()
    {
        //Reinforced Glass
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.reinforcedGlass, 8, 0), "GIG", "IGI", "GIG", 'G', Blocks.glass, 'I', Items.iron_ingot);
        // Reinforced Wooden Casing
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.reinforcedWoodenCasing, 3, 0), "SSS", "S S", "SSS", 'S', Items.stick);
        // Reinforced Metal Casing
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.reinforcedMetalCasing, 6, 0), "III", "I I", "III", 'I', Items.iron_ingot);
        // Reinforced Soil (Dirt)
        GameRegistry.addShapelessRecipe(new ItemStack(VanillaModule.reinforcedSoil, 1, 0), Blocks.dirt, VanillaModule.reinforcedWoodenCasing);
        // Reinforced Soil (Sand)
        GameRegistry.addShapelessRecipe(new ItemStack(VanillaModule.reinforcedSoil, 1, 1), Blocks.sand, VanillaModule.reinforcedWoodenCasing);
        // Reinforced Soil (Grass)
        // TODO Finish reinforced grass!
        //GameRegistry.addShapelessRecipe(new ItemStack(VanillaModule.reinforcedSoil, 1, 2), Blocks.grass, VanillaModule.reinforcedWoodenCasing);
        // Reinforced Stone (Cobblestone)
        GameRegistry.addShapelessRecipe(new ItemStack(VanillaModule.reinforcedStone, 1, 0), Blocks.cobblestone, VanillaModule.reinforcedMetalCasing);
        // Reinforced Stone (Stone)
        GameRegistry.addShapelessRecipe(new ItemStack(VanillaModule.reinforcedStone, 1, 1), Blocks.stone, VanillaModule.reinforcedMetalCasing);
        // Reinforced Stone (Stonebrick)
        GameRegistry.addShapelessRecipe(new ItemStack(VanillaModule.reinforcedStone, 1, 2), Blocks.stonebrick, VanillaModule.reinforcedMetalCasing);
        // Reinforced Metal (Iron)
        GameRegistry.addShapelessRecipe(new ItemStack(VanillaModule.reinforcedMetal, 1, 0), Blocks.iron_block, VanillaModule.reinforcedMetalCasing);
        // Reinforced Metal (Gold)
        GameRegistry.addShapelessRecipe(new ItemStack(VanillaModule.reinforcedMetal, 1, 1), Blocks.gold_block, VanillaModule.reinforcedMetalCasing);
        // Simple Camo Block
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.simpleCamoBlock, 1, 0), "VVV", "VRV", "VSV", 'V', Blocks.vine, 'R', Items.redstone, 'S', Blocks.stone);
    }
}

