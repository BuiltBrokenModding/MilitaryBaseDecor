package com.builtbroken.militarybasedecor.modules.worldwar1.content.block;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/4/2016.
 */
public class ItemWireFence extends ItemBlockWorldWar1
{
    public ItemWireFence(Block block)
    {
        super(block);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        super.addInformation(itemStack, player, list, par4);
        if (itemStack.getItemDamage() == 2)
        {
            list.add(EnumChatFormatting.RED + "Warning: Causes damage to entities");
        }
    }
}
