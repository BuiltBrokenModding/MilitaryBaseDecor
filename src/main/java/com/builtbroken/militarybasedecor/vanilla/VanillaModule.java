package com.builtbroken.militarybasedecor.vanilla;

import com.builtbroken.mc.lib.helper.recipe.UniversalRecipe;
import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.prefab.BlockColoredStairs;
import com.builtbroken.militarybasedecor.vanilla.content.block.*;
import com.builtbroken.militarybasedecor.vanilla.content.block.camo.ItemBlockCamo;
import com.builtbroken.militarybasedecor.vanilla.content.block.camo.TileSimpleCamo;
import com.builtbroken.militarybasedecor.vanilla.content.block.reinforced.*;
import com.builtbroken.militarybasedecor.vanilla.content.item.VanillaItems;
import com.builtbroken.militarybasedecor.vanilla.content.item.tool.ItemWireCutters;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Content themed to vanilla MC rather than any set mod or History era
 */
public class VanillaModule extends AbstractLoadable {
    public static String[] colors =
            {
                    "Black",
                    "Red",
                    "Green",
                    "Brown",
                    "Blue",
                    "Purple",
                    "Cyan",
                    "LightGray",
                    "Gray",
                    "Pink",
                    "Lime",
                    "Yellow",
                    "LightBlue",
                    "Magenta",
                    "Orange",
                    "White"
            };

    public static Block reinforcedSoil;
    public static Block reinforcedStone;
    public static Block reinforcedMetal;
    public static Block reinforcedGlass;
    public static Block reinforcedCasing;
    public static Block simpleCamoBlock;
    public static Block basicConcrete;
    public static Block basicConcreteStairs[] = new Block[16];
    public static Block basicConcreteWall;
    public static Block wiredFence;
    public static Block sandBag;
    public static Block metalFence;
    public static Block metalWall;
    public static Block chainLinkFence;
    public static Block paneBarbs;

    public static Item bagCement;
    public static Item leatherBag;
    public static Item bundledWire;
    public static Item wireCutters;

    @Override
    public void preInit() {
        reinforcedSoil = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedSoil.class, ItemBlockVanilla.class);
        reinforcedStone = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedStone.class, ItemBlockVanilla.class);
        reinforcedMetal = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedMetal.class, ItemBlockVanilla.class);
        reinforcedGlass = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedGlass.class, ItemBlockVanilla.class);
        reinforcedCasing = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedCasing.class, ItemBlockVanilla.class);
        basicConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock("concrete_basic", new BlockColored(Material.rock).setHardness(15).setResistance(150).setStepSound(Block.soundTypeStone).setBlockName("concrete_basic").setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB), ItemBlockVanilla.class);
        for (int i = 0; i < 16; i++) {
            basicConcreteStairs[i] = MilitaryBaseDecor.INSTANCE.getManager().newBlock("concrete_basic_stairs_" + i, new BlockColoredStairs(basicConcrete, i).setResistance(150).setHardness(15).setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB).setStepSound(Block.soundTypeStone), ItemBlockVanilla.class);
        }
        basicConcreteWall = MilitaryBaseDecor.INSTANCE.getManager().newBlock("concrete_wall", new BlockBasicConcreteWall(basicConcrete).setResistance(150).setHardness(15).setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB).setStepSound(Block.soundTypeStone), ItemBlockVanilla.class);
        simpleCamoBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock("simple_camo", new TileSimpleCamo("simple_camo", Material.rock));
        wiredFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock("wired_fence", new BlockWiredFence("militarybasedecor:wired_fence", "militarybasedecor:wired_fence_top", Material.iron, true).setBlockUnbreakable().setBlockName("wired_fence"), ItemBlockVanilla.class);
        sandBag = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBasicSandBag.class, ItemBlockVanilla.class);
        metalFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock("metal_fence", new BlockFence("iron_block", Material.iron).setBlockTextureName("iron_block").setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB).setStepSound(Block.soundTypeMetal), ItemBlockVanilla.class);
        metalWall = MilitaryBaseDecor.INSTANCE.getManager().newBlock("metal_wall", new BlockMetalWall(reinforcedMetal).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB), ItemBlockVanilla.class);
        chainLinkFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockChainLinkFence.class, ItemBlockVanilla.class).setBlockUnbreakable();
        paneBarbs = MilitaryBaseDecor.INSTANCE.getManager().newBlock("pane_barbs", new TilePaneBarbs()).setBlockName("pane_barbs");

        bagCement = MilitaryBaseDecor.INSTANCE.getManager().newItem("cement_bag", new VanillaItems()).setUnlocalizedName("cement_bag").setMaxStackSize(1).setTextureName(MilitaryBaseDecor.PREFIX + "cement_bag");
        leatherBag = MilitaryBaseDecor.INSTANCE.getManager().newItem("bag", new VanillaItems()).setUnlocalizedName("bag").setTextureName(MilitaryBaseDecor.PREFIX + "bag");
        bundledWire = MilitaryBaseDecor.INSTANCE.getManager().newItem("bundled_wire", new VanillaItems()).setUnlocalizedName("bundled_wire").setTextureName(MilitaryBaseDecor.PREFIX + "bundled_wire");
        wireCutters = MilitaryBaseDecor.INSTANCE.getManager().newItem("wire_cutters", new ItemWireCutters()).setUnlocalizedName("wire_cutters").setTextureName(MilitaryBaseDecor.PREFIX + "wire_cutters");

        MilitaryBaseDecor.CREATIVE_TAB.itemStack = new ItemStack(basicConcrete);
    }

    @Override
    public void postInit() {
        VanillaRecipes.initItemRecipes();
        VanillaRecipes.initBlockRecipes();
    }
}