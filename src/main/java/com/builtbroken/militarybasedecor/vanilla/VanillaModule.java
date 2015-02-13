package com.builtbroken.militarybasedecor.vanilla;

import com.builtbroken.mc.lib.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.vanilla.content.BlockConcrete;
import com.builtbroken.militarybasedecor.vanilla.content.camo.TileSimpleCamo;
import com.builtbroken.militarybasedecor.vanilla.content.items.ItemBag;
import com.builtbroken.militarybasedecor.vanilla.content.items.ItemBagConcrete;
import com.builtbroken.militarybasedecor.vanilla.content.reinforced.BlockReinforcedCasing;
import com.builtbroken.militarybasedecor.vanilla.content.reinforced.BlockReinforcedGlass;
import com.builtbroken.militarybasedecor.vanilla.content.reinforced.BlockReinforcedSoil;
import com.builtbroken.militarybasedecor.vanilla.content.reinforced.BlockReinforcedStone;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Content themed to vanilla MC rather than any set mod or History era
 */
public class VanillaModule implements ILoadable
{
    public static Block reinforcedSoil;
    public static Block reinforcedStone;
    public static Block reinforcedGlass;
    public static Block reinforcedCasing;
    public static Block simpleCamoBlock;
    public static Block metalFence;
    public static Block concrete;

    public static Item bagConcrete;
    public static Item leatherBag;

    @Override
    public void preInit()
    {
        reinforcedSoil = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedSoil.class);
        reinforcedStone = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedStone.class);
        reinforcedGlass = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedGlass.class);
        reinforcedCasing = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedCasing.class);
        concrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockConcrete.class);
        //metalFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockMetalFence.class);
        simpleCamoBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(TileSimpleCamo.class);

        bagConcrete = MilitaryBaseDecor.INSTANCE.getManager().newItem(ItemBagConcrete.class);
        leatherBag = MilitaryBaseDecor.INSTANCE.getManager().newItem(ItemBag.class);

        MilitaryBaseDecor.CREATIVE_TAB.itemStack = new ItemStack(concrete);
    }

    @Override
    public void init()
    {

    }

    @Override
    public void postInit()
    {
        //Reinforced wood casing
        GameRegistry.addShapedRecipe(new ItemStack(reinforcedCasing, 1, 0), new Object[]{"SWS", "WSW" , "SWS", 'S', Items.stick, 'W', Blocks.planks});
        //Leather Bag
        GameRegistry.addShapedRecipe(new ItemStack(leatherBag, 1, 0), new Object[]{"S S", "L L", "LLL", 'S', Items.string, 'L', Items.leather});
        //Bag of Concrete
        GameRegistry.addShapelessRecipe(new ItemStack(bagConcrete, 1, 0), new Object[]{Blocks.gravel, Blocks.sand, leatherBag});
    }
}
