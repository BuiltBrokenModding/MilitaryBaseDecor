package com.builtbroken.militarybasedecor.modules.vanilla;

import com.builtbroken.mc.framework.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.camo.TileSimpleCamo;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.reinforced.BlockReinforcedButton;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.ItemBlockVanilla;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.reinforced.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Content themed to vanilla MC rather than any set mod or History era
 */
public class VanillaModule extends AbstractLoadable
{

    public static Block reinforcedGlass;
    public static Block reinforcedButton;
    public static Block simpleCamoBlock;

    @Override
    public void preInit()
    {
        reinforcedGlass = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedGlass.class, ItemBlockVanilla.class);
        reinforcedButton = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedButton.class, ItemBlockVanilla.class);
        simpleCamoBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock("simple_camo", new TileSimpleCamo("simple_camo", Material.rock));
    }

    @Override
    public void postInit()
    {
        VanillaRecipes.initBlockRecipes();
    }
}