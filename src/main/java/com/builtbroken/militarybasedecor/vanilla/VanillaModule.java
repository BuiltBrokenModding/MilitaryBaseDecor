package com.builtbroken.militarybasedecor.vanilla;

import com.builtbroken.mc.lib.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.vanilla.content.*;
import net.minecraft.block.Block;

/**
 * Content themed to vanilla MC rather than any set mod or History era
 */
public class VanillaModule implements ILoadable
{
    public static Block reinforcedSoil;
    public static Block reinforcedStone;
    public static Block reinforcedGlass;
    public static Block reinforcedCasing;
    public static Block metalFence;

    @Override
    public void preInit()
    {
        reinforcedSoil = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedSoil.class);
        reinforcedStone = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedStone.class);
        reinforcedGlass = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedGlass.class);
        reinforcedCasing = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedCasing.class);
        metalFence = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockMetalFence.class);
    }

    @Override
    public void init()
    {

    }

    @Override
    public void postInit()
    {

    }
}
