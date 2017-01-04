package com.builtbroken.militarybasedecor.modules.worldwar1;

import com.builtbroken.militarybasedecor.modules.worldwar1.WorldWar1Module;
import com.builtbroken.militarybasedecor.modules.worldwar2.WorldWar2Module;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by henna on 31.12.2016.
 */
public class WW1Recipes {

    public static void initItemRecipes()
    {
        // Leather Bag
        GameRegistry.addShapedRecipe(new ItemStack(WorldWar1Module.bag, 1, 0), "S S", "L L", "LLL", 'S', Items.string, 'L', Items.leather);
        // Bag of Cement
        GameRegistry.addShapelessRecipe(new ItemStack(WorldWar1Module.bagCement, 1, 0), Blocks.gravel, Blocks.sand, WorldWar1Module.bag);
        // Bucket of Liquid Concrete
        GameRegistry.addShapelessRecipe(new ItemStack(WorldWar1Module.liquidConcreteBucket, 1, 0), WorldWar1Module.bagCement, Items.water_bucket.setContainerItem(null));
    }

    public static void initBlockRecipes()
    {
        // Basic Sandbag
        GameRegistry.addShapedRecipe(new ItemStack(WorldWar1Module.sandBag, 8, 0), "WWW", "WSW", "WWW", 'W', Blocks.wool, 'S', Blocks.sand);
        GameRegistry.addShapedRecipe(new ItemStack(WorldWar1Module.sandBag, 8, 0), "LLL", "LSL", "LLL", 'L', Items.leather, 'S', Blocks.sand);
    }
}
