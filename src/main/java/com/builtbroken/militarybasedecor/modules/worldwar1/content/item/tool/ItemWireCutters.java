package com.builtbroken.militarybasedecor.modules.worldwar1.content.item.tool;

import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ole on 5/16/2015.
 */
public class ItemWireCutters extends Item implements IRecipeContainer
{

    public ItemWireCutters()
    {
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
        this.setNoRepair();
        this.setCreativeTab(MilitaryBaseDecor.MAIN_TAB);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add(EnumChatFormatting.BLUE + "World War 1 Module");
    }

    @Override
    public void genRecipes(List<IRecipe> recipes) {
        GameRegistry.addShapedRecipe(new ItemStack(this, 1, 0), " I ", "I I", "W W", 'I', Items.iron_ingot, 'W', Blocks.wool);
    }
}
