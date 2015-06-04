package com.builtbroken.militarybasedecor.gunpowder;

import com.builtbroken.mc.lib.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.gunpowder.content.block.BlockLimecrete;
import com.builtbroken.militarybasedecor.gunpowder.content.block.BlockPicketFence;
import com.builtbroken.militarybasedecor.gunpowder.content.block.BlockRopeFence;
import com.builtbroken.militarybasedecor.gunpowder.content.block.BlockTangledRope;
import com.builtbroken.militarybasedecor.gunpowder.content.block.ItemBlockGunpowderEra;
import com.builtbroken.militarybasedecor.gunpowder.content.item.ItemRope;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/** Content themed after the civil war
 * Created by Ole on 25.1.2015
 */
public class GunpowderModule implements ILoadable
{

    public static Block picketFence;
    public static Block ropeFence;
    public static Block tangledRope;
    public static Block limecrete;
    
    public static Item rope;

    @Override
    public void preInit()
    {
    	limecrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockLimecrete.class, ItemBlockGunpowderEra.class);
    	ropeFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockRopeFence.class, ItemBlockGunpowderEra.class);
    	tangledRope = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockTangledRope.class, ItemBlockGunpowderEra.class);
    	picketFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockPicketFence.class, ItemBlockGunpowderEra.class);
    	
    	rope = MilitaryBaseDecor.INSTANCE.getManager().newItem("rope", ItemRope.class);
    	
    	MilitaryBaseDecor.CREATIVE_TAB.itemStack = new ItemStack(ropeFence);
    }

    @Override
    public void init()
    {

    }

    @Override
    public void postInit()
    {
    	// Blocks
    	// Picket Fence
    	GameRegistry.addShapedRecipe(new ItemStack(picketFence, 3, 0), "SSS", "S S", "S S", 'S', Items.stick);
    	// Rope Fence
    	GameRegistry.addShapedRecipe(new ItemStack(ropeFence, 1, 0), "PRP", "PRP", "PRP", 'P', Blocks.planks, 'R', rope);
    	// Items
    	// Rope
    	GameRegistry.addShapedRecipe(new ItemStack(rope, 3, 0), "   ", "SSS", "   ", 'S', Items.string);
    	// Tangled Rope
    	GameRegistry.addShapelessRecipe(new ItemStack(tangledRope, 4, 0), rope);

    }
}
