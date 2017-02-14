package com.builtbroken.militarybasedecor.modules.future.block;

import com.builtbroken.mc.prefab.tile.item.ItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blog/development/license.md"></a> for what you can and can't do with the code.
 * Created by Hennamann(Henry) on 16/01/2017.
 */
public class ItemBlockFuture extends ItemBlockMetadata {

    public ItemBlockFuture(Block block) {
        super(block);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + StatCollector.translateToLocal("tooltip.future"));
    }
}
