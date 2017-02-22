package com.builtbroken.militarybasedecor.modules.blastcraft.content.block;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * @see <a href="https://github.com/BuilBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry Stabell) on 22.02.2017 for VoltzEngine.
 */
public class ItemBlockBlastProofGlassSeamless extends ItemBlockBlastcraft {

    public ItemBlockBlastProofGlassSeamless(Block block) {
        super(block);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        super.addInformation(itemStack, player, list, par4);
        list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip.seamless"));
    }
}
