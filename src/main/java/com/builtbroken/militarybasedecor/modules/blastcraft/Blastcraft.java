package com.builtbroken.militarybasedecor.modules.blastcraft;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.blastcraft.content.block.BlockBlastProofBrick;
import com.builtbroken.militarybasedecor.modules.blastcraft.content.block.BlockBlastProofGlass;
import com.builtbroken.militarybasedecor.modules.blastcraft.content.block.ItemBlockBlastcraft;
import net.minecraft.block.Block;

/**
 * Created by ole on 13/01/16.
 */
public class Blastcraft extends AbstractLoadable
{

    public static Block blastProofBrick;
    public static Block blastProofGlass;

    @Override
    public void preInit()
    {

        blastProofBrick = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBlastProofBrick.class, ItemBlockBlastcraft.class);
        blastProofGlass = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBlastProofGlass.class, ItemBlockBlastcraft.class);
    }
}
