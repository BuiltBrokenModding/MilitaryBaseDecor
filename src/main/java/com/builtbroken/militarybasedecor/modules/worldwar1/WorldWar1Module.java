package com.builtbroken.militarybasedecor.modules.worldwar1;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.camo.TileSimpleCamo;
import com.builtbroken.militarybasedecor.modules.vanilla.content.item.VanillaItems;
import com.builtbroken.militarybasedecor.modules.vanilla.content.item.tool.ItemWireCutters;
import com.builtbroken.militarybasedecor.modules.worldwar1.content.block.*;
import com.builtbroken.militarybasedecor.modules.worldwar1.content.item.ItemWire;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WorldWar1Module extends AbstractLoadable
{
    public static Block blockWireFence;
    public static Block blockFenceTopper;
    public static Block camouflageBlock;
    public static Block simpleCamoBlock;
    public static Block basicConcrete;
    public static Block sandBag;

    public static Item itemBag;
    public static Item itemWire;
    public static Item itemWireCutters;

    @Override
    public void preInit()
    {
        basicConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBasicConcrete.class, ItemBlockWorldWar1.class);
        simpleCamoBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock("simple_camo", new TileSimpleCamo("simple_camo", Material.rock));
        camouflageBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock("camouflage_block", new BlockCamouflageBlock().setBlockName("camouflage_block"), ItemBlockWorldWar1.class);

        sandBag = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBasicSandBag.class, ItemBlockWorldWar1.class);
        itemBag = MilitaryBaseDecor.INSTANCE.getManager().newItem("bag", new VanillaItems()).setUnlocalizedName("bag").setTextureName(MilitaryBaseDecor.PREFIX + "bag");

        itemWireCutters = MilitaryBaseDecor.INSTANCE.getManager().newItem("wire_cutters", new ItemWireCutters()).setUnlocalizedName("wire_cutters").setTextureName(MilitaryBaseDecor.PREFIX + "wire_cutters");

        itemWire = MilitaryBaseDecor.INSTANCE.getManager().newItem("bundled_wire", new ItemWire());

        blockWireFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockWireFence.class, ItemBlockWireFence.class);
        blockFenceTopper = MilitaryBaseDecor.INSTANCE.getManager().newBlock("pane_barbs", new TileFenceTopper());

        MilitaryBaseDecor.MAIN_TAB.itemStack = new ItemStack(blockWireFence);
    }
}
