package com.builtbroken.militarybasedecor.modules.vanilla;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.*;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.camo.TileSimpleCamo;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.reinforced.*;
import com.builtbroken.militarybasedecor.modules.vanilla.content.item.VanillaItems;
import com.builtbroken.militarybasedecor.modules.vanilla.content.item.tool.ItemWireCutters;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
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
    public static Block reinforcedCasing;
    public static Block simpleCamoBlock;
    public static Block basicConcrete;
    public static Block basicConcreteWall;
    public static Block wiredFence;
    public static Block sandBag;
    public static Block metalFence;
    public static Block metalWall;
    public static Block chainLinkFence;

    public static Item bagCement;
    public static Item leatherBag;
    public static Item bundledWire;
    public static Item wireCutters;

    @Override
    public void preInit()
    {
        reinforcedSoil = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedSoil.class, ItemBlockVanilla.class);
        reinforcedStone = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedStone.class, ItemBlockVanilla.class);
        reinforcedMetal = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedMetal.class, ItemBlockVanilla.class);
        reinforcedGlass = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedGlass.class, ItemBlockVanilla.class);
        reinforcedCasing = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedCasing.class, ItemBlockVanilla.class);
        basicConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBasicConcrete.class, ItemBlockVanilla.class);
        basicConcreteWall = MilitaryBaseDecor.INSTANCE.getManager().newBlock("concrete_wall", new BlockBasicConcreteWall(basicConcrete).setResistance(150).setHardness(15).setCreativeTab(MilitaryBaseDecor.MAIN_TAB).setStepSound(Block.soundTypeStone), ItemBlockVanilla.class);
        simpleCamoBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock("simple_camo", new TileSimpleCamo("simple_camo", Material.rock));
        wiredFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock("wired_fence", new BlockWiredFence("militarybasedecor:wired_fence", "militarybasedecor:wired_fence_top", Material.iron, true).setBlockName("wired_fence"), ItemBlockVanilla.class);
        sandBag = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBasicSandBag.class, ItemBlockVanilla.class);
        chainLinkFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockChainLinkFence.class, ItemBlockVanilla.class);

        bagCement = MilitaryBaseDecor.INSTANCE.getManager().newItem("cement_bag", new VanillaItems()).setUnlocalizedName("cement_bag").setMaxStackSize(1).setTextureName(MilitaryBaseDecor.PREFIX + "cement_bag");
        leatherBag = MilitaryBaseDecor.INSTANCE.getManager().newItem("bag", new VanillaItems()).setUnlocalizedName("bag").setTextureName(MilitaryBaseDecor.PREFIX + "bag");
        bundledWire = MilitaryBaseDecor.INSTANCE.getManager().newItem("bundled_wire", new VanillaItems()).setUnlocalizedName("bundled_wire").setTextureName(MilitaryBaseDecor.PREFIX + "bundled_wire");
        wireCutters = MilitaryBaseDecor.INSTANCE.getManager().newItem("wire_cutters", new ItemWireCutters()).setUnlocalizedName("wire_cutters").setTextureName(MilitaryBaseDecor.PREFIX + "wire_cutters");

        MilitaryBaseDecor.MAIN_TAB.itemStack = new ItemStack(basicConcrete);
    }

    @Override
    public void postInit()
    {
        VanillaRecipes.initItemRecipes();
        VanillaRecipes.initBlockRecipes();
    }
}