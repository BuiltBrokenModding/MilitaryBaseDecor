package com.builtbroken.militarybasedecor.modules.blastcraft.content.machines.blastcompressor.recipes;

import com.builtbroken.mc.prefab.recipe.item.MRHandlerItemStack;
import com.builtbroken.militarybasedecor.client.MBDRecipeType;
import net.minecraft.item.ItemStack;

/**
 * @see <a href="https://github.com/BuilBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry Stabell) on 18.03.2017 for MilitaryBaseDecor.
 */
public class BlastCompressorRecipeHandler extends MRHandlerItemStack {

    public BlastCompressorRecipeHandler()
    {
        super(MBDRecipeType.ITEM_COMPRESSOR.INTERNAL_NAME);
    }

    @Override
    public ItemStack getRecipe(Object[] items, float extraChance, float failureChance)
    {
        if (items != null)
        {
            ItemStack result = super.getRecipe(items, extraChance, failureChance);
            if (result == null && items.length == 1 && items[0] instanceof ItemStack)
            {
                result = BlastCompressorRecipes.compressing().getCompressingResult((ItemStack) items[0]);
            }
            if (result != null)
            {
                ItemStack re = result.copy();
                if (re.stackSize <= 0)
                {
                    re.stackSize = 1;
                }
                return re;
            }
            return result;
        }
        return null;
    }
}