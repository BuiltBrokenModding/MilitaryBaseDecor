package com.builtbroken.militarybasedecor.modules.blastcraft;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.blastcraft.content.block.*;
import net.minecraft.block.Block;

/**
 * Created by ole on 13/01/16.
 */
public class Blastcraft extends AbstractLoadable
{

    public static Block hardenedBrick;
    public static Block rawBlastProofWalling;
    public static Block blastProofWalling;
    public static Block blastProofGlass;
    public static Block blastProofTrapDoor;
    public static Block carbonPlatedWalling;

    @Override
    public void preInit()
    {
        hardenedBrick = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockHardenedBrick.class, ItemBlockBlastcraft.class);
        rawBlastProofWalling = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockRawBlastProofWalling.class, ItemBlockBlastcraft.class);
        blastProofWalling = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBlastProofWalling.class, ItemBlockBlastcraft.class);
        blastProofGlass = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBlastProofGlass.class, ItemBlockBlastcraft.class);
        blastProofTrapDoor = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBlastProofTrapDoor.class, ItemBlockBlastcraft.class);
        carbonPlatedWalling = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockCarbonPlatedWalling.class, ItemBlockBlastcraft.class);
    }
}
