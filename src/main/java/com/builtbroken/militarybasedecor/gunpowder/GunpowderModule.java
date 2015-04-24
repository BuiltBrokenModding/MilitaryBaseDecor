package com.builtbroken.militarybasedecor.gunpowder;

import com.builtbroken.mc.lib.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.gunpowder.content.block.BlockPicketFence;
import com.builtbroken.militarybasedecor.gunpowder.content.block.BlockRopeFence;
import com.builtbroken.militarybasedecor.gunpowder.content.block.ItemBlockGunpowderEra;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/** Content themed after the civil war
 * Created by Ole on 25.1.2015
 */
public class GunpowderModule implements ILoadable
{

    public static Block picketFence;
    public static Block ropeFence;

    @Override
    public void preInit()
    {
    	ropeFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockRopeFence.class, ItemBlockGunpowderEra.class);
    	picketFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockPicketFence.class, ItemBlockGunpowderEra.class);
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
    	GameRegistry.addShapedRecipe(new ItemStack(picketFence, 3, 0), new Object[]{"SSS", "S S", "S S", 'S', Items.stick});

    }
}
