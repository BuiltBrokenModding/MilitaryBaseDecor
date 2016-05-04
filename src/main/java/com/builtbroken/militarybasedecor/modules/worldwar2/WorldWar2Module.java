package com.builtbroken.militarybasedecor.modules.worldwar2;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.worldwar2.content.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class WorldWar2Module extends AbstractLoadable
{
    public static Block corrugatedGalvanisedIronBlock;
    public static Block oliveDrabTexturedBlock;
    public static Block ammunitionBox;
    public static Block equipmentCrate;
    public static Block reinforcedConcrete;

    @Override
    public void preInit()
    {
        ammunitionBox = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAmmunitionBox.class, ItemBlockWorldWar2.class);
        corrugatedGalvanisedIronBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockCorrugatedGalvanisedIron.class, ItemBlockCorrugatedGalvanisedIron.class);
        oliveDrabTexturedBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockOliveDrabTexturedBlock.class, ItemBlockWorldWar2.class);
        equipmentCrate = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockEquipmentCrate.class, ItemBlockWorldWar2.class);
        reinforcedConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedConcrete.class, ItemBlockWorldWar2.class);
        MilitaryBaseDecor.MAIN_TAB.itemStack = new ItemStack(ammunitionBox);
    }

    @Override
    public void postInit()
    {

        WW2Recipes.initItemRecipes();
        WW2Recipes.initBlockRecipes();
    }
}