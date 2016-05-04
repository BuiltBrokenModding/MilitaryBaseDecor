package com.builtbroken.militarybasedecor.modules.worldwar1;

import com.builtbroken.militarybasedecor.core.ConfigManager;
import com.builtbroken.militarybasedecor.modules.vanilla.VanillaModule;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Ole on 10.01.2016.
 */
public class WW1Recipes
{

    public static void initItemRecipes()
    {
        // Barbed Bundled Wire
        GameRegistry.addShapedRecipe(new ItemStack(WorldWar1Module.barbedBundledWire, 6, 0), "IF ", "I F", "FII", 'I', Items.iron_ingot, 'F', Items.flint);
        if (ConfigManager.VANILLA_ENABLED)
        {
            GameRegistry.addShapelessRecipe(new ItemStack(WorldWar1Module.barbedBundledWire, 1, 0), VanillaModule.bundledWire, Items.flint);
        }
    }

    public static void initBlockRecipes()
    {
        // Barbed Wire Fence
        GameRegistry.addShapedRecipe(new ItemStack(WorldWar1Module.barbedWireFence, 6, 0), "WWW", "   ", "WWW", 'W', WorldWar1Module.barbedBundledWire);
        // Concertina Wire
        GameRegistry.addShapelessRecipe(new ItemStack(WorldWar1Module.concertinaWire, 4, 0), new ItemStack(WorldWar1Module.barbedBundledWire, 4, 0));
        // Pane Barbs
        GameRegistry.addShapedRecipe(new ItemStack(WorldWar1Module.paneBarbs, 6, 0), "B B", " B ", "III", 'B', WorldWar1Module.barbedWireFence, 'I', Items.iron_ingot);
    }
}
