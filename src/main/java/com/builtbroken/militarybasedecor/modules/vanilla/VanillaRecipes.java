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

    public static void initItemRecipes()
    {

        // Leather Bag
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.leatherBag, 3, 0), "S S", "L L", "LLL", 'S', Items.string, 'L', Items.leather);
        // Bag of Cement
        GameRegistry.addShapelessRecipe(new ItemStack(VanillaModule.bagCement, 1, 0), Blocks.gravel, Blocks.sand, VanillaModule.leatherBag);
        // Bundled Wire
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.bundledWire, 6, 0), "II ", "I I", " II", 'I', Items.iron_ingot);
        // Wire Cutters
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.wireCutters, 1, 0), " I ", "I I", "W W", 'I', Items.iron_ingot, 'W', Blocks.wool);
    }

    public static void initBlockRecipes()
    {

        // Basic Concrete
        GameRegistry.addShapelessRecipe(new ItemStack(VanillaModule.basicConcrete, 1, 0), VanillaModule.bagCement, Items.water_bucket);
        // Basic Colored Concrete
        // N/A
        // Basic Concrete Wall
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.basicConcreteWall, 6, 0), "   ", "CCC", "CCC", 'C', VanillaModule.basicConcrete);
        // Basic Concrete Stairs
        // N/A
        // Reinforced Glass
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.reinforcedGlass, 8, 0), "GIG", "IGI", "GIG", 'G', Blocks.glass, 'I', Items.iron_ingot);
        // Wired Fence
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.wiredFence, 6, 0), "WWW", "   ", "WWW", 'W', VanillaModule.bundledWire);
        // Wood Casing
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.reinforcedCasing, 3, 0), "SSS", "S S", "SSS", 'S', Items.stick);
        // Basic Sandbag
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.sandBag, 8, 0), "WWW", "WSW", "WWW", 'W', Blocks.wool, 'S', Blocks.sand);
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.sandBag, 8, 0), "LLL", "LSL", "LLL", 'L', Items.leather, 'S', Blocks.sand);
        // Chain Link Fence
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.chainLinkFence, 6, 0), "I I", " I ", "I I", 'I', Items.iron_ingot);
        // Simple Camo Block
        GameRegistry.addShapedRecipe(new ItemStack(VanillaModule.simpleCamoBlock, 1, 0), "VVV", "VRV", "VSV", 'V', Blocks.vine, 'R', Items.redstone, 'S', Blocks.stone);
    }
}
