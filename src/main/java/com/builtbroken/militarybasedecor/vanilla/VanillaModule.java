package com.builtbroken.militarybasedecor.vanilla;

import com.builtbroken.mc.lib.helper.recipe.UniversalRecipe;
import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.mc.lib.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.coldwar.ColdWarModule;
import com.builtbroken.militarybasedecor.prefab.BlockStairsPrefab;
import com.builtbroken.militarybasedecor.prefab.BlockWallPrefab;
import com.builtbroken.militarybasedecor.vanilla.content.block.BlockBasicSandBag;
import com.builtbroken.militarybasedecor.vanilla.content.block.BlockEmbrasureBlock;
import com.builtbroken.militarybasedecor.vanilla.content.block.BlockMetalWall;
import com.builtbroken.militarybasedecor.vanilla.content.block.BlockRustyIronBlock;
import com.builtbroken.militarybasedecor.vanilla.content.block.BlockWiredDoor;
import com.builtbroken.militarybasedecor.vanilla.content.block.BlockWiredFence;
import com.builtbroken.militarybasedecor.vanilla.content.block.ItemBlockVanilla;
import com.builtbroken.militarybasedecor.vanilla.content.block.camo.TileSimpleCamo;
import com.builtbroken.militarybasedecor.vanilla.content.block.reinforced.BlockReinforcedCasing;
import com.builtbroken.militarybasedecor.vanilla.content.block.reinforced.BlockReinforcedGlass;
import com.builtbroken.militarybasedecor.vanilla.content.block.reinforced.BlockReinforcedMetal;
import com.builtbroken.militarybasedecor.vanilla.content.block.reinforced.BlockReinforcedSoil;
import com.builtbroken.militarybasedecor.vanilla.content.block.reinforced.BlockReinforcedStone;
import com.builtbroken.militarybasedecor.vanilla.content.item.ItemBag;
import com.builtbroken.militarybasedecor.vanilla.content.item.ItemBagCement;
import com.builtbroken.militarybasedecor.vanilla.content.item.ItemFenceWires;
import com.builtbroken.militarybasedecor.vanilla.content.item.ItemRustyIronIngot;
import com.builtbroken.militarybasedecor.vanilla.content.item.ItemRustyIronNugget;
import com.builtbroken.militarybasedecor.vanilla.content.item.ItemWiredDoor;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

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
    public static Block concreteStairs;
    public static Block concreteWall;
    public static Block wiredFence;
    public static Block rustyWiredFence;
    public static Block sandBag;
    public static Block metalFence;
    public static Block metalWall;
    public static Block fluidConcrete;
    public static Block embrasureBlock;
    public static Block rustyIronBlock;
    public static Block wiredDoor;

    public static Item bagCement;
    public static Item leatherBag;
    public static Item fenceWires;
    public static Item rustyFenceWires;
    public static Item rustyIronIngot;
    public static Item rustyIronNugget;
    public static Item wiredDoorItem;
    
    @Override
    public void preInit()
    {       
        reinforcedSoil = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedSoil.class, ItemBlockVanilla.class);
        reinforcedStone = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedStone.class, ItemBlockVanilla.class);
        reinforcedMetal = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedMetal.class, ItemBlockVanilla.class);
        reinforcedGlass = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedGlass.class, ItemBlockVanilla.class);
        reinforcedCasing = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedCasing.class, ItemBlockVanilla.class);
        basicConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock("concrete_basic",new BlockColored(Material.rock).setHardness(15).setResistance(150).setStepSound(Block.soundTypeStone).setBlockName("basic_concrete").setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB), ItemBlockVanilla.class);
        concreteStairs = MilitaryBaseDecor.INSTANCE.getManager().newBlock("concrete_stairs", new BlockStairsPrefab(basicConcrete, 0).setBlockTextureName(MilitaryBaseDecor.DOMAIN + "basic_concrete_silver").setResistance(150).setHardness(15).setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB).setStepSound(Block.soundTypeStone), ItemBlockVanilla.class);
        concreteWall = MilitaryBaseDecor.INSTANCE.getManager().newBlock("concrete_wall", new BlockWallPrefab(basicConcrete).setResistance(150).setHardness(15).setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB).setStepSound(Block.soundTypeStone), ItemBlockVanilla.class);
        simpleCamoBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(TileSimpleCamo.class);
        wiredFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock("wired_fence", new BlockWiredFence("militarybasedecor:wired_fence", "militarybasedecor:wired_fence_top", Material.iron, true).setBlockName("wired_fence"), ItemBlockVanilla.class);
        rustyWiredFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock("rusty_wired_fence", new BlockWiredFence("militarybasedecor:rusty_wired_fence", "militarybasedecor:rusty_wired_fence_top", Material.iron, true).setBlockName("rusty_wired_fence"), ItemBlockVanilla.class);
        // TODO Create integration with the Armory mod(when we get to making it...) sandBag = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBasicSandBag.class), ItemBlockVanilla.class;
        metalFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock("metal_fence", new BlockFence("iron_block", Material.iron).setBlockTextureName("iron_block").setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB).setStepSound(Block.soundTypeMetal), ItemBlockVanilla.class); 
        metalWall = MilitaryBaseDecor.INSTANCE.getManager().newBlock("metal_wall", new BlockMetalWall(reinforcedMetal).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB), ItemBlockVanilla.class);
        embrasureBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockEmbrasureBlock.class, ItemBlockVanilla.class);
        rustyIronBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockRustyIronBlock.class, ItemBlockVanilla.class);
        wiredDoor = MilitaryBaseDecor.INSTANCE.getManager().newBlock("wired_door", new BlockWiredDoor(Material.iron).setBlockName("wired_door").setBlockTextureName(MilitaryBaseDecor.DOMAIN + ":" + "wired_door"));
        
        bagCement = MilitaryBaseDecor.INSTANCE.getManager().newItem(ItemBagCement.class);
        leatherBag = MilitaryBaseDecor.INSTANCE.getManager().newItem(ItemBag.class);
        fenceWires = MilitaryBaseDecor.INSTANCE.getManager().newItem("fence_wires", new ItemFenceWires()).setUnlocalizedName("fence_wires");
        rustyFenceWires = MilitaryBaseDecor.INSTANCE.getManager().newItem("rusty_fence_wires", new ItemFenceWires()).setUnlocalizedName("rusty_fence_wires");
        rustyIronIngot = MilitaryBaseDecor.INSTANCE.getManager().newItem(ItemRustyIronIngot.class);
        rustyIronNugget = MilitaryBaseDecor.INSTANCE.getManager().newItem(ItemRustyIronNugget.class);
        wiredDoorItem = MilitaryBaseDecor.INSTANCE.getManager().newItem("wired_door_item", new ItemWiredDoor(Material.iron));
        
        MilitaryBaseDecor.CREATIVE_TAB.itemStack = new ItemStack(basicConcrete);
    }
    
    @Override
    public void postInit()
    {
    	// Blocks
        // Reinforced wood casing
        GameRegistry.addShapedRecipe(new ItemStack(reinforcedCasing, 1, 0), new Object[]{"SWS", "WSW" , "SWS", 'S', Items.stick, 'W', Blocks.planks});
        // Concrete
        GameRegistry.addShapelessRecipe(new ItemStack(basicConcrete, 2, 0), new Object[]{Items.water_bucket, bagCement});
        // Wired Fence
        GameRegistry.addShapedRecipe(new ItemStack(wiredFence, 6, 0), new Object[]{"WWW", "   ", "WWW", 'W', fenceWires});
        // Simple Camo Block
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(simpleCamoBlock, 8), "WWW", "WCW", "WWW", 'W', Blocks.vine, 'C', UniversalRecipe.CIRCUIT_T1.get()));
        // Reinforced Glass
        GameRegistry.addShapedRecipe(new ItemStack(reinforcedGlass, 8, 0), new Object[]{"IGI", "GIG", "IGI", 'I', Items.iron_ingot, 'G', Blocks.glass});
        
        // Items
        // Leather Bag
        GameRegistry.addShapedRecipe(new ItemStack(leatherBag, 1, 0), new Object[]{"S S", "L L", "LLL", 'S', Items.string, 'L', Items.leather});
        // Bag of Concrete
        GameRegistry.addShapelessRecipe(new ItemStack(bagCement, 1, 0), new Object[]{Blocks.gravel, Blocks.sand, leatherBag});
        
        // Basic Sandbag
        // TODO Create integration with the Armory mod(when we get to making it...) GameRegistry.addShapedRecipe(new ItemStack(sandBag, 1, 0), new Object[]{"WWW", "WSW", "WWW", 'W', Blocks.wool, 'S', new ItemStack(Blocks.sand, 1, 0)});
    }
}
