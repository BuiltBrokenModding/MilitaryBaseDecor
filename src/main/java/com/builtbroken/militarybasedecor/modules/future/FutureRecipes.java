package com.builtbroken.militarybasedecor.modules.future;

import com.builtbroken.militarybasedecor.core.ConfigManager;
import com.builtbroken.militarybasedecor.modules.vanilla.VanillaModule;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * Created by Ole on 11.01.2016.
 */
public class FutureRecipes
{

    public static void initItemRecipes()
    {
    }

    public static void initBlockRecipes()
    {

        // Reinforced Glass Panel
        if (ConfigManager.VANILLA_ENABLED)
        {
            GameRegistry.addShapedRecipe(new ItemStack(FutureModule.reinforcedGlassPanel, 3, 0), "GGG", "   ", "   ", 'G', VanillaModule.reinforcedGlass);
        }
        // Glass Floor Panel
        GameRegistry.addShapedRecipe(new ItemStack(FutureModule.glassFloorPanel, 3, 0), "GGG", "   ", "   ", 'G', Blocks.glass);
        // Meshed Floor Panel
        GameRegistry.addShapedRecipe(new ItemStack(FutureModule.meshedFloorPanel, 3, 0), "MMM", "   ", "   ", 'M', FutureModule.metalMeshBlock);
    }
}
