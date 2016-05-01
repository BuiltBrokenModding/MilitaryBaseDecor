package com.builtbroken.militarybasedecor.modules.gunpowder.content.block;

import com.builtbroken.mc.prefab.tile.item.ItemBlockMetadata;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemBlockGunpowderEra extends ItemBlockMetadata {

    public ItemBlockGunpowderEra(Block block) {
        super(block);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + "Gunpowder Era Module");
    }

}
