package com.builtbroken.militarybasedecor.future;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.future.content.block.BlockGroundLight;
import com.builtbroken.militarybasedecor.future.content.block.ItemBlockFuture;
import net.minecraft.block.Block;

/**
 * A module set in the future, this module allows for a lot more imagination than the other modules.
 * Created by Ole on 4/27/2015.
 */
public class FutureModule extends AbstractLoadable {

    public static Block stoneLight;

    @Override
    public void preInit() {

        stoneLight = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockGroundLight.class, ItemBlockFuture.class);

    }

    @Override
    public void postInit() {

    }
}