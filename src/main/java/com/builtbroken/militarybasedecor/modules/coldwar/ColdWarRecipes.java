package com.builtbroken.militarybasedecor.modules.coldwar;

import com.builtbroken.militarybasedecor.modules.vanilla.VanillaModule;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by henna on 01.01.2017.
 */
public class ColdWarRecipes {

    public static void initItemRecipes()
    {
        // Bituminous Coal
        GameRegistry.addSmelting(Items.coal, new ItemStack(ColdWarModule.bituminousCoal), 0);
        // Bituminous Coal in a Bucket
        GameRegistry.addShapelessRecipe(new ItemStack(ColdWarModule.bituminousCoalBucket, 1, 0), Items.bucket, ColdWarModule.bituminousCoal);
        // Bucket of Liquid Bitumine
        GameRegistry.addSmelting(ColdWarModule.bituminousCoalBucket, new ItemStack(ColdWarModule.liquidBitumineBucket), 0);
    }

    public static void initBlockRecipes()
    {
    }
}
