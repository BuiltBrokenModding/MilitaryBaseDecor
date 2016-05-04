package com.builtbroken.militarybasedecor.modules.worldwar1;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.worldwar1.content.block.*;
import com.builtbroken.militarybasedecor.modules.worldwar1.content.item.WorldWar1Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WorldWar1Module extends AbstractLoadable
{

    public static Block advancedSandBag;
    public static Block barbedWireFence;
    public static Block paneBarbs;
    public static Block concertinaWire;
    public static Block camouflageBlock;

    public static Item barbedBundledWire;

    @Override
    public void preInit()
    {
        barbedWireFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBarbedWireFence.class, ItemBlockWorldWar1.class);
        concertinaWire = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockConcertinaWire.class, ItemBlockWorldWar1.class);
        advancedSandBag = MilitaryBaseDecor.INSTANCE.getManager().newBlock("advanced_sandbag", new TileAdvancedSandbag()).setBlockName("advanced_sandbag");
        camouflageBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock("camouflage_block", new BlockCamouflageBlock().setBlockName("camouflage_block"), ItemBlockWorldWar1.class);
        paneBarbs = MilitaryBaseDecor.INSTANCE.getManager().newBlock("pane_barbs", new TilePaneBarbs()).setBlockName("pane_barbs");

        barbedBundledWire = MilitaryBaseDecor.INSTANCE.getManager().newItem("barbed_bundled_wire", new WorldWar1Items()).setUnlocalizedName("barbed_bundled_wire").setTextureName(MilitaryBaseDecor.PREFIX + "barbed_bundled_wire");

        MilitaryBaseDecor.MAIN_TAB.itemStack = new ItemStack(barbedWireFence);
    }

    @Override
    public void postInit()
    {
        WW1Recipes.initItemRecipes();
        WW1Recipes.initBlockRecipes();
    }

}
