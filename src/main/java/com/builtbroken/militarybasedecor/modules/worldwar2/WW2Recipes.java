package com.builtbroken.militarybasedecor.modules.worldwar2;

import com.builtbroken.mc.lib.helper.recipe.OreNames;
import com.builtbroken.militarybasedecor.modules.worldwar1.WorldWar1Module;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Ole on 11.01.2016.
 */
public class WW2Recipes
{

    public static void initItemRecipes()
    {
        // Rebar
        GameRegistry.addShapelessRecipe(new ItemStack(WorldWar2Module.rebar, 2, 0), Items.iron_ingot, Items.iron_ingot);
    }

    public static void initBlockRecipes()
    {

        // Ammunition Block
        GameRegistry.addShapedRecipe(new ItemStack(WorldWar2Module.ammunitionBox, 8, 0), "III", "IYI", "III", 'I', Items.iron_ingot, 'Y', new ItemStack(Items.dye, 1, 11));
        // Olive Drab Textured Block
        GameRegistry.addShapelessRecipe(new ItemStack(WorldWar2Module.oliveDrabTexturedBlock, 1, 0), new ItemStack(Blocks.wool, 1, 13), new ItemStack(Items.dye, 1, 10));
        // Equipment Crate
        GameRegistry.addShapedRecipe(new ItemStack(WorldWar2Module.equipmentCrate, 3, 0), "III", "DDD", "III", 'I', Items.iron_ingot, 'D', new ItemStack(Items.dye, 1, 15));
    }

}
