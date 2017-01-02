package com.builtbroken.militarybasedecor.modules.coldwar;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.coldwar.content.block.BlockAsphalt;
import com.builtbroken.militarybasedecor.modules.coldwar.content.block.BlockReinforcedRail;
import com.builtbroken.militarybasedecor.modules.coldwar.content.block.ItemBlockColdWar;
import com.builtbroken.militarybasedecor.modules.coldwar.content.item.ItemLiquidBitumineBucket;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Content themed after cold ware military bunkers and bases
 * Created by robert on 12/7/2014.
 */
public class ColdWarModule extends AbstractLoadable
{
    public static Block asphalt;
    public static Block reinforcedRail;

    public static Item bituminousCoal;
    public static Item bituminousCoalBucket;
    public static Item liquidBitumineBucket;

    @Override
    public void preInit()
    {
        asphalt = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAsphalt.class, ItemBlockColdWar.class);
        reinforcedRail = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedRail.class, ItemBlockColdWar.class);

        bituminousCoal = MilitaryBaseDecor.INSTANCE.getManager().newItem("bituminous_coal", new Item().setTextureName(MilitaryBaseDecor.PREFIX + "bituminous_coal").setUnlocalizedName("bituminous_coal").setCreativeTab(MilitaryBaseDecor.MAIN_TAB));
        bituminousCoalBucket = MilitaryBaseDecor.INSTANCE.getManager().newItem("bituminous_coal_bucket", new Item().setTextureName(MilitaryBaseDecor.PREFIX + "bituminous_coal_bucket").setUnlocalizedName("bituminous_coal_bucket").setCreativeTab(MilitaryBaseDecor.MAIN_TAB));
        liquidBitumineBucket = MilitaryBaseDecor.INSTANCE.getManager().newItem("liquid_bitumine_bucket", new ItemLiquidBitumineBucket(asphalt).setTextureName(MilitaryBaseDecor.PREFIX + "liquid_bitumine_bucket").setUnlocalizedName("liquid_bitumine_bucket").setCreativeTab(MilitaryBaseDecor.MAIN_TAB));

        MilitaryBaseDecor.MAIN_TAB.itemStack = new ItemStack(asphalt);
    }

    @Override
    public void postInit()
    {
        ColdWarRecipes.initItemRecipes();
        ColdWarRecipes.initBlockRecipes();
    }
}
