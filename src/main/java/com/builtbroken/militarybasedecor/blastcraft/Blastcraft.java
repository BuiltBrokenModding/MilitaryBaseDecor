package com.builtbroken.militarybasedecor.blastcraft;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.blastcraft.content.block.BlockBlastProofBrick;
import com.builtbroken.militarybasedecor.blastcraft.content.block.BlockBlastProofGlass;
import com.builtbroken.militarybasedecor.blastcraft.content.block.ItemBlockBlastcraft;
import com.builtbroken.militarybasedecor.vanilla.content.block.ItemBlockVanilla;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * Created by ole on 13/01/16.
 */
public class Blastcraft extends AbstractLoadable {

    public static Block blastProofBrick;
    public static Block blastProofGlass;

    @Override
    public void preInit() {

        blastProofBrick = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBlastProofBrick.class, ItemBlockBlastcraft.class);
        blastProofGlass = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockBlastProofGlass.class, ItemBlockBlastcraft.class);

        MilitaryBaseDecor.CREATIVE_TAB_2.itemStack = new ItemStack(blastProofBrick);
    }

    @Override
    public void postInit() {

        BlastcraftRecipes.initItemRecipes();
        BlastcraftRecipes.initBlockRecipes();
    }

}
