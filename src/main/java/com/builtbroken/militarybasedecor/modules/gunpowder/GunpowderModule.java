package com.builtbroken.militarybasedecor.modules.gunpowder;

import com.builtbroken.mc.framework.mod.loadable.AbstractLoadable;
import com.builtbroken.mc.framework.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.gunpowder.content.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * Content themed after the civil war
 * Created by Ole on 25.1.2015
 */
public class GunpowderModule extends AbstractLoadable implements ILoadable
{

    public static Block picketFence;
    public static Block ropeFence;
    public static Block tangledRope;

    @Override
    public void preInit()
    {
        ropeFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockRopeFence.class, ItemBlockGunpowderEra.class);
        tangledRope = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockTangledRope.class, ItemBlockGunpowderEra.class);
        picketFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockPicketFence.class, ItemBlockGunpowderEra.class);

        MilitaryBaseDecor.MAIN_TAB.itemStack = new ItemStack(ropeFence);
    }

    @Override
    public void init()
    {
    }

    @Override
    public void postInit()
    {
        GunpowderRecipes.initBlockRecipes();
    }
}
