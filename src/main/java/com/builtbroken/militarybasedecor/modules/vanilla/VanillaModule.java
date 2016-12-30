package com.builtbroken.militarybasedecor.modules.vanilla;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.BlockBasicMixer;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.reinforced.BlockReinforcedButton;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.ItemBlockVanilla;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.reinforced.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;

/**
 * Content themed to vanilla MC rather than any set mod or History era
 */
public class VanillaModule extends AbstractLoadable
{

    public static Block reinforcedSoil;
    public static Block reinforcedStone;
    public static Block reinforcedMetal;
    public static Block reinforcedGlass;
    public static Block reinforcedWoodenCasing;
    public static Block reinforcedMetalCasing;
    public static Block reinforcedButton;
    public static Block basicMixer;

    public static Item basicMixerItem;


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
        basicMixer = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBasicMixer.class);
        basicMixerItem = MilitaryBaseDecor.INSTANCE.getManager().newItem("basic_mixer", new ItemReed(basicMixer).setCreativeTab(MilitaryBaseDecor.MAIN_TAB).setUnlocalizedName("basic_mixer").setTextureName(MilitaryBaseDecor.PREFIX + "basic_mixer"));

        MilitaryBaseDecor.MAIN_TAB.itemStack = new ItemStack(reinforcedSoil);
    }

    @Override
    public void postInit()
    {
        VanillaRecipes.initItemRecipes();
        VanillaRecipes.initBlockRecipes();
    }
}