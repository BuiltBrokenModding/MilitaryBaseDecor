package com.builtbroken.militarybasedecor.modules.coldwar;

import com.builtbroken.mc.framework.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.ConfigManager;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.coldwar.content.block.*;
import com.builtbroken.militarybasedecor.modules.coldwar.content.item.ItemColdWar;
import com.builtbroken.militarybasedecor.modules.coldwar.content.item.ItemLiquidBitumenBucket;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
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
    public static Block icbmConcrete;
    public static Block highStrengthConcrete;
    public static Block reinforcedDoor;
    public static Item reinforcedDoorItem;

    public static Item bituminousCoal;
    public static Item bituminousCoalBucket;
    public static Item liquidBitumenBucket;

    @Override
    public void preInit()
    {
        asphalt = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAsphalt.class, ItemBlockColdWar.class);
        reinforcedRail = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedRail.class, ItemBlockColdWar.class);
        highStrengthConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock("high_strength_concrete", new BlockColored(Material.rock).setBlockName("high_strength_concrete").setBlockTextureName(MilitaryBaseDecor.PREFIX + "concrete/concrete_high_strength/concrete_high_strength").setResistance(80).setHardness(40).setCreativeTab(null), ItemBlockColdWar.class);

        if (ConfigManager.ICBM_CONCRETE_ENABLED) {
            icbmConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock("icbm_concrete", BlockICBMConcrete.class, ItemBlockColdWar.class);
        }
        reinforcedDoor = MilitaryBaseDecor.INSTANCE.getManager().newBlock("reinforced_door", BlockReinforcedDoor.class, ItemBlockColdWar.class);
        reinforcedDoorItem = MilitaryBaseDecor.INSTANCE.getManager().newItem("reinforced_door_item", ItemBlockReinforcedDoor.class);

        bituminousCoal = MilitaryBaseDecor.INSTANCE.getManager().newItem("bituminous_coal", new ItemColdWar().setTextureName(MilitaryBaseDecor.PREFIX + "bituminous_coal").setUnlocalizedName("bituminous_coal").setCreativeTab(MilitaryBaseDecor.MAIN_TAB));
        bituminousCoalBucket = MilitaryBaseDecor.INSTANCE.getManager().newItem("bituminous_coal_bucket", new ItemColdWar().setTextureName(MilitaryBaseDecor.PREFIX + "bituminous_coal_bucket").setUnlocalizedName("bituminous_coal_bucket").setCreativeTab(MilitaryBaseDecor.MAIN_TAB).setMaxStackSize(1));
        liquidBitumenBucket = MilitaryBaseDecor.INSTANCE.getManager().newItem("liquid_bitumen_bucket", new ItemLiquidBitumenBucket(asphalt).setTextureName(MilitaryBaseDecor.PREFIX + "liquid_bitumen_bucket").setUnlocalizedName("liquid_bitumen_bucket").setCreativeTab(MilitaryBaseDecor.MAIN_TAB).setMaxStackSize(1));

        MilitaryBaseDecor.MAIN_TAB.itemStack = new ItemStack(asphalt);
    }

    @Override
    public void postInit()
    {
        ColdWarRecipes.initItemRecipes();
        ColdWarRecipes.initBlockRecipes();
    }
}
