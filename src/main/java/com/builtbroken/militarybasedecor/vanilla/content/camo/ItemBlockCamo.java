package com.builtbroken.militarybasedecor.vanilla.content.camo;

import com.builtbroken.mc.prefab.tile.item.ItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * Created by robert on 1/25/2015.
 */
public class ItemBlockCamo extends ItemBlockMetadata
{
    public ItemBlockCamo(Block block)
    {
        super(block);
        this.setHasSubtypes(true);
    }
}
