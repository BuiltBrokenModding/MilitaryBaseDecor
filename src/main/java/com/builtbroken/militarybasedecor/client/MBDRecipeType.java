package com.builtbroken.militarybasedecor.client;

import com.builtbroken.mc.api.recipe.IMachineRecipe;
import com.builtbroken.mc.api.recipe.IMachineRecipeHandler;
import com.builtbroken.mc.api.recipe.RecipeRegisterResult;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @see <a href="https://github.com/BuilBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry Stabell) on 19.03.2017 for MilitaryBaseDecor.
 */
public enum MBDRecipeType {

    ITEM_COMPRESSOR("compressor"),
    ITEM_MIXER("mixer");

    private IMachineRecipeHandler handler;
    public final String INTERNAL_NAME;

    MBDRecipeType(String name)
    {
        this.INTERNAL_NAME = name;
    }

    public IMachineRecipeHandler getHandler()
    {
        return handler;
    }

    public static IMachineRecipeHandler getHandler(String name)
    {
        for(MBDRecipeType type : values())
        {
            if(type.INTERNAL_NAME.equalsIgnoreCase(name))
            {
                return type.getHandler();
            }
        }
        return null;
    }

    /**
     * Used to set the handler for the recipe type. If you
     * plan to override Voltz-Engine's default handler
     * make sure to inform the user that it is your handler.
     * As well make sure to copy over any recipes already
     * registered to avoid compatibility issues.
     *
     * @param handler - new handler instance
     */
    public void setHandler(IMachineRecipeHandler handler)
    {
        this.handler = handler;
    }

    public RecipeRegisterResult registerRecipe(IMachineRecipe recipe)
    {
        if (handler != null)
        {
            return handler.registerRecipe(recipe);
        }
        return RecipeRegisterResult.NO_HANDLER;
    }

    public Object getRecipe(float extra_chance, float fail_chance, Object... items)
    {
        if (getHandler() != null)
        {
            return getHandler().getRecipe(items, extra_chance, fail_chance);
        }
        return null;
    }

    public ItemStack getItemStackRecipe(float extra_chance, float fail_chance, Object... items)
    {
        return toItemStack(getRecipe(extra_chance, fail_chance, items));
    }

    /**
     * Helper method to convert the output into an itemstack
     * @param result - single object result, doesn't handle collections
     * @return ItemStack from the result
     */
    public static ItemStack toItemStack(Object result)
    {
        if (result instanceof ItemStack)
        {
            return (ItemStack) result;
        }
        else if (result instanceof Block)
        {
            return new ItemStack((Block) result);
        }
        else if (result instanceof Item)
        {
            return new ItemStack((Item) result);
        }
        return null;
    }

    @Override
    public String toString()
    {
        return name().toLowerCase();
    }
}