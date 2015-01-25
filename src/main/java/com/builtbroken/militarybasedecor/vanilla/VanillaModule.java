package com.builtbroken.militarybasedecor.vanilla;

import com.builtbroken.mc.lib.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.vanilla.content.*;
import com.builtbroken.militarybasedecor.vanilla.content.camo.TileSimpleCamo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import javax.swing.*;

/**
 * Content themed to vanilla MC rather than any set mod or History era
 */
public class VanillaModule implements ILoadable
{
    public static Block reinforcedSoil;
    public static Block reinforcedStone;
    public static Block reinforcedGlass;
    public static Block reinforcedCasing;
    public static Block simpleCamoBlock;
    public static Block metalFence;

    @Override
    public void preInit()
    {
        reinforcedSoil = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedSoil.class);
        reinforcedStone = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedStone.class);
        reinforcedGlass = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedGlass.class);
        reinforcedCasing = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedCasing.class);
        metalFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockMetalFence.class);
        simpleCamoBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(TileSimpleCamo.class);
    }

    @Override
    public void init()
    {

    }

    @Override
    public void postInit()
    {
        //Reinforced wood casing
        GameRegistry.addShapedRecipe(new ItemStack(reinforcedCasing, 1, 0), new Object[]{"SWS", "WSW" , "SWS", 'S', Items.stick, 'W', Blocks.planks});
    }
}
