package com.builtbroken.militarybasedecor.modules.worldwar2;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.worldwar2.content.block.*;
import com.builtbroken.militarybasedecor.modules.worldwar2.content.item.ItemWorldWar2;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WorldWar2Module extends AbstractLoadable
{
    public static Block corrugatedGalvanisedIronBlock;
    public static Block oliveDrabTexturedBlock;
    public static Block ammunitionBox;
    public static Block equipmentCrate;
    public static Block reinforcedConcrete;
    public static Block reinforcedLiquidConcrete;
    public static Block rebarMesh;

    public static Item rebar;

    @Override
    public void preInit()
    {
        ammunitionBox = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAmmunitionBox.class, ItemBlockWorldWar2.class);
        corrugatedGalvanisedIronBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockCorrugatedGalvanisedIron.class, ItemBlockCorrugatedGalvanisedIron.class);
        oliveDrabTexturedBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockOliveDrabTexturedBlock.class, ItemBlockWorldWar2.class);
        equipmentCrate = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockEquipmentCrate.class, ItemBlockWorldWar2.class);
        reinforcedConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock("reinforced_concrete", new BlockColored(Material.rock).setBlockName("concrete_reinforced").setBlockTextureName(MilitaryBaseDecor.PREFIX + "concrete/concrete_reinforced/concrete_reinforced").setHardness(20).setResistance(40).setCreativeTab(MilitaryBaseDecor.MAIN_TAB), ItemBlockWorldWar2.class);
        reinforcedLiquidConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock("reinforced_liquid_concrete", BlockLiquidReinforcedConcrete.class, ItemBlockWorldWar2.class);
        rebarMesh = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockRebarMesh.class, ItemBlockWorldWar2.class);

        rebar = MilitaryBaseDecor.INSTANCE.getManager().newItem("rebar", new ItemWorldWar2().setUnlocalizedName("rebar").setTextureName(MilitaryBaseDecor.PREFIX + "rebar"));

        MilitaryBaseDecor.MAIN_TAB.itemStack = new ItemStack(ammunitionBox);
    }

    @Override
    public void postInit()
    {

        WW2Recipes.initItemRecipes();
        WW2Recipes.initBlockRecipes();
    }
}