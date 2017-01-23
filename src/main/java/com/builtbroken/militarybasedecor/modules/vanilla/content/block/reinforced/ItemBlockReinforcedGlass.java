package com.builtbroken.militarybasedecor.modules.vanilla.content.block.reinforced;

import com.builtbroken.militarybasedecor.modules.vanilla.content.block.ItemBlockVanilla;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * @see <a href="https://github.com/BuilBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry Stabell) on 23.01.2017 for Military Base Decor.
 */
public class ItemBlockReinforcedGlass extends ItemBlockVanilla {

    public ItemBlockReinforcedGlass(Block block) {
        super(block);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        super.addInformation(itemStack, player, list, par4);
        list.add(EnumChatFormatting.ITALIC + "Seamless Version");
    }

}
