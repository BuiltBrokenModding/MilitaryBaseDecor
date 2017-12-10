package com.builtbroken.militarybasedecor.modules.vanilla;

import com.builtbroken.mc.framework.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.camo.TileSimpleCamo;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.reinforced.BlockReinforcedButton;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.ItemBlockVanilla;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.reinforced.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

/**
 * Content themed to vanilla MC rather than any set mod or History era
 */
public class VanillaModule extends AbstractLoadable
{

    public static Block reinforcedSoil;
    public static Block reinforcedStone;
    public static Block reinforcedMetal;
    public static Block reinforcedGlassNormal;
    public static Block reinforcedGlass;
    public static Block reinforcedWoodenCasing;
    public static Block reinforcedMetalCasing;
    public static Block reinforcedButton;
    public static Block simpleCamoBlock;
    public static Block perviousConcrete;
    public static Block glassConcrete;

    @Override
    public void preInit()
    {
        reinforcedSoil = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedSoil.class, ItemBlockVanilla.class);
        reinforcedStone = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedStone.class, ItemBlockVanilla.class);
        reinforcedMetal = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedMetal.class, ItemBlockVanilla.class);
        reinforcedGlass = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedGlass.class, ItemBlockVanilla.class);
        reinforcedWoodenCasing = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedWoodenCasing.class, ItemBlockVanilla.class);
        reinforcedMetalCasing = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedMetalCasing.class, ItemBlockVanilla.class);
        reinforcedButton = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedButton.class, ItemBlockVanilla.class);
        simpleCamoBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock("simple_camo", new TileSimpleCamo("simple_camo", Material.rock));

        MilitaryBaseDecor.MAIN_TAB.itemStack = new ItemStack(reinforcedSoil);
    }

    @Override
    public void postInit()
    {
        VanillaRecipes.initItemRecipes();
        VanillaRecipes.initBlockRecipes();
    }
}