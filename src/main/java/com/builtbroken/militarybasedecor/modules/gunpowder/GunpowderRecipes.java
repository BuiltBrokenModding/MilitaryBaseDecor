package com.builtbroken.militarybasedecor.modules.gunpowder;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Ole on 11.01.2016.
 */
public class GunpowderRecipes {

    public static void initItemRecipes() {

        // Rope
        GameRegistry.addShapedRecipe(new ItemStack(GunpowderModule.rope, 6, 0), "SS ", "S S", "SS ", 'S', Items.string);
        //

    }

    public static void initBlockRecipes() {

        // Tangled Rope
        GameRegistry.addShapelessRecipe(new ItemStack(GunpowderModule.tangledRope, 2, 0), new ItemStack(GunpowderModule.rope, 4, 0));
        // Rope Fence
        GameRegistry.addShapedRecipe(new ItemStack(GunpowderModule.ropeFence, 6, 0), "   ", "SRS", "SRS", 'S', Items.stick, 'R', GunpowderModule.rope);
        // Picket Fence
        GameRegistry.addShapedRecipe(new ItemStack(GunpowderModule.picketFence, 6, 0), "S S", "WWW", "S S", 'S', Items.stick, 'W', Blocks.planks);
    }

}
