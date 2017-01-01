package com.builtbroken.militarybasedecor.modules.worldwar1;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.vanilla.content.item.tool.ItemWireCutters;
import com.builtbroken.militarybasedecor.modules.worldwar1.content.DamageSourceConcreteSolidify;
import com.builtbroken.militarybasedecor.modules.worldwar1.content.block.*;
import com.builtbroken.militarybasedecor.modules.worldwar1.content.item.ItemWire;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class WorldWar1Module extends AbstractLoadable
{
    public static Block blockWireFence;
    public static Block blockFenceTopper;
    public static Block camouflageBlock;
    public static Block basicConcrete;
    public static Block sandBag;
    public static Block basicMixer;

    public static Item itemWire;
    public static Item itemWireCutters;
    public static Item basicMixerItem;
    public static Item bag;
    public static Item bagCement;
    public static Item liquidConcreteBucket;

    public static DamageSource concreteSolidify;

    @Override
    public void preInit()
    {
        basicConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBasicConcrete.class, ItemBlockWorldWar1.class);
        camouflageBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock("camouflage_block", new BlockCamouflageBlock().setBlockName("camouflage_block"), ItemBlockWorldWar1.class);
        basicMixer = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBasicMixer.class, ItemBlockWorldWar1.class);
        blockWireFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockWireFence.class, ItemBlockWireFence.class);
        blockFenceTopper = MilitaryBaseDecor.INSTANCE.getManager().newBlock("pane_barbs", new TileFenceTopper());
        sandBag = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBasicSandBag.class, ItemBlockWorldWar1.class);

        bag = MilitaryBaseDecor.INSTANCE.getManager().newItem("bag", new Item()).setUnlocalizedName("bag").setTextureName(MilitaryBaseDecor.PREFIX + "bag");
        bagCement = MilitaryBaseDecor.INSTANCE.getManager().newItem("bag_cement", new Item()).setUnlocalizedName("bag_cement").setTextureName(MilitaryBaseDecor.PREFIX + "bag_cement");
        itemWireCutters = MilitaryBaseDecor.INSTANCE.getManager().newItem("wire_cutters", new ItemWireCutters()).setUnlocalizedName("wire_cutters").setTextureName(MilitaryBaseDecor.PREFIX + "wire_cutters");
        itemWire = MilitaryBaseDecor.INSTANCE.getManager().newItem("bundled_wire", new ItemWire());
        basicMixerItem = MilitaryBaseDecor.INSTANCE.getManager().newItem("basic_mixer", new ItemReed(basicMixer).setCreativeTab(MilitaryBaseDecor.MAIN_TAB).setUnlocalizedName("basic_mixer").setTextureName(MilitaryBaseDecor.PREFIX + "basic_mixer"));
        liquidConcreteBucket = MilitaryBaseDecor.INSTANCE.getManager().newItem("bucket_liquid_concrete", new Item()).setCreativeTab(MilitaryBaseDecor.MAIN_TAB).setUnlocalizedName("bucket_liquid_concrete").setTextureName(MilitaryBaseDecor.PREFIX + "bucket_liquid_concrete").setMaxStackSize(1);

        concreteSolidify = new DamageSourceConcreteSolidify();

        MilitaryBaseDecor.MAIN_TAB.itemStack = new ItemStack(blockWireFence);
    }

    @Override
    public void postInit()
    {
        WW1Recipes.initItemRecipes();
        WW1Recipes.initBlockRecipes();
    }
}
