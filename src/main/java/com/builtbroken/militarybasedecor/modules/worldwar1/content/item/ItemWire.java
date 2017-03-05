package com.builtbroken.militarybasedecor.modules.worldwar1.content.item;

import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/4/2016.
 */
public class ItemWire extends Item implements IRecipeContainer
{
    public ItemWire()
    {
        this.setHasSubtypes(true);
        this.setUnlocalizedName("bundled_wire");
        this.setTextureName(MilitaryBaseDecor.PREFIX + "bundled_wire");
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add(EnumChatFormatting.BLUE + StatCollector.translateToLocal("tooltip.worldwar1"));
    }

    @Override
    public void genRecipes(List<IRecipe> recipes)
    {
        //TODO replace recipe with a version that uses iron wires from VE
        //TODO replace flint with more wires, eg barbed wire it literally twisted wire on wire
        GameRegistry.addShapedRecipe(new ItemStack(this, 6, 0), "IF ", "I F", "FII", 'I', Items.iron_ingot, 'F', Items.flint);
        //GameRegistry.addShapelessRecipe(new ItemStack(this, 1, 0), VanillaModule.bundledWire, Items.flint);
    }
}
