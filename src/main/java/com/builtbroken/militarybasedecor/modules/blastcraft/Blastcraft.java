package com.builtbroken.militarybasedecor.modules.blastcraft;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.client.MBDRecipeType;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.blastcraft.content.block.*;
import com.builtbroken.militarybasedecor.modules.blastcraft.content.machines.blastcompressor.TileBlastCompressor;
import com.builtbroken.militarybasedecor.modules.blastcraft.content.machines.blastcompressor.recipes.BlastCompressorRecipeHandler;
import net.minecraft.block.Block;

/**
 * Created by ole on 13/01/16.
 */
public class Blastcraft extends AbstractLoadable
{
    public static Block hardenedBrick;
    public static Block rawBlastProofWalling;
    public static Block blastProofWalling;
    public static Block blastProofGlassNormal;
    public static Block blastProofGlassSeamless;
    public static Block blastProofTrapDoor;
    public static Block carbonPlatedWalling;

    public static Block blastCompressor;

    @Override
    public void preInit()
    {
        MBDRecipeType.ITEM_COMPRESSOR.setHandler(new BlastCompressorRecipeHandler());

        hardenedBrick = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockHardenedBrick.class, ItemBlockBlastcraft.class);
        rawBlastProofWalling = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockRawBlastProofWalling.class, ItemBlockBlastcraft.class);
        blastProofWalling = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBlastProofWalling.class, ItemBlockBlastcraft.class);
        blastProofGlassNormal = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBlastProofGlassNormal.class, ItemBlockBlastProofGlassNormal.class);
        blastProofGlassSeamless = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBlastProofGlassSeamless.class, ItemBlockBlastProofGlassSeamless.class);
        blastProofTrapDoor = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBlastProofTrapDoor.class, ItemBlockBlastcraft.class);
        carbonPlatedWalling = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockCarbonPlatedWalling.class, ItemBlockBlastcraft.class);

        blastCompressor = MilitaryBaseDecor.INSTANCE.getManager().newBlock("blast_compressor", TileBlastCompressor.class);
    }
}
