package com.builtbroken.militarybasedecor.modules.gunpowder;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Ole on 11.01.2016.
 */
public class GunpowderRecipes
{

    public static void initBlockRecipes()
    {
        GameRegistry.addShapedRecipe(new ItemStack(GunpowderModule.picketFence, 6, 0), "S S", "WWW", "S S", 'S', Items.stick, 'W', Blocks.planks);
    }
}
