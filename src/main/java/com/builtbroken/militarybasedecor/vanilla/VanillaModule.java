package com.builtbroken.militarybasedecor.vanilla;

import com.builtbroken.mc.lib.helper.recipe.UniversalRecipe;
import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.mc.lib.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.coldwar.ColdWarModule;
import com.builtbroken.militarybasedecor.vanilla.content.BlockBasicSandBag;
import com.builtbroken.militarybasedecor.vanilla.content.BlockWiredFence;
import com.builtbroken.militarybasedecor.vanilla.content.camo.TileSimpleCamo;
import com.builtbroken.militarybasedecor.vanilla.content.concrete.BlockConcrete;
import com.builtbroken.militarybasedecor.vanilla.content.items.ItemBag;
import com.builtbroken.militarybasedecor.vanilla.content.items.ItemBagConcrete;
import com.builtbroken.militarybasedecor.vanilla.content.reinforced.BlockReinforcedCasing;
import com.builtbroken.militarybasedecor.vanilla.content.reinforced.BlockReinforcedGlass;
import com.builtbroken.militarybasedecor.vanilla.content.reinforced.BlockReinforcedMetal;
import com.builtbroken.militarybasedecor.vanilla.content.reinforced.BlockReinforcedSoil;
import com.builtbroken.militarybasedecor.vanilla.content.reinforced.BlockReinforcedStone;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
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
    public static Block concrete;
    public static Block wiredFence;
    public static Block sandBag;

    public static Item bagConcrete;
    public static Item leatherBag;

    @Override
    public void preInit()
    {
        reinforcedSoil = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedSoil.class);
        reinforcedStone = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedStone.class);
        reinforcedMetal = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedMetal.class);
        reinforcedGlass = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedGlass.class);
        reinforcedCasing = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedCasing.class);
        concrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockConcrete.class);
        simpleCamoBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(TileSimpleCamo.class);
        wiredFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockWiredFence.class);
        // TODO Create integration with the Armory mod(when we get to making it...) sandBag = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBasicSandBag.class);
        bagConcrete = MilitaryBaseDecor.INSTANCE.getManager().newItem(ItemBagConcrete.class);
        leatherBag = MilitaryBaseDecor.INSTANCE.getManager().newItem(ItemBag.class);

        MilitaryBaseDecor.CREATIVE_TAB.itemStack = new ItemStack(concrete);
    }
    
    @Override
    public void postInit()
    {
    	// Blocks
        // Reinforced wood casing
        GameRegistry.addShapedRecipe(new ItemStack(reinforcedCasing, 1, 0), new Object[]{"SWS", "WSW" , "SWS", 'S', Items.stick, 'W', Blocks.planks});
        // Concrete
        GameRegistry.addShapelessRecipe(new ItemStack(concrete, 2, 0), new Object[]{Items.water_bucket, bagConcrete});
        // Wired Fence
        GameRegistry.addShapedRecipe(new ItemStack(wiredFence, 6, 0), new Object[]{"III", "   ", "III", 'I', Items.iron_ingot});
        // Simple Camo Block
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(simpleCamoBlock, 8), "WWW", "WCW", "WWW", 'W', Blocks.vine, 'C', UniversalRecipe.CIRCUIT_T1.get()));
        // Reinforced Glass
        GameRegistry.addShapedRecipe(new ItemStack(reinforcedGlass, 8, 0), new Object[]{"IGI", "GIG", "IGI", 'I', Items.iron_ingot, 'G', Blocks.glass});
        
        // Items
        // Leather Bag
        GameRegistry.addShapedRecipe(new ItemStack(leatherBag, 1, 0), new Object[]{"S S", "L L", "LLL", 'S', Items.string, 'L', Items.leather});
        // Bag of Concrete
        GameRegistry.addShapelessRecipe(new ItemStack(bagConcrete, 1, 0), new Object[]{Blocks.gravel, Blocks.sand, leatherBag});
        
        // Basic Sandbag
        // TODO Create integration with the Armory mod(when we get to making it...) GameRegistry.addShapedRecipe(new ItemStack(sandBag, 1, 0), new Object[]{"WWW", "WSW", "WWW", 'W', Blocks.wool, 'S', new ItemStack(Blocks.sand, 1, 0)});
    }
}
