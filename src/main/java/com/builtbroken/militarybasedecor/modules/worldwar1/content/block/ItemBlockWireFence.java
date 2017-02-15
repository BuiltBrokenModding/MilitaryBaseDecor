package com.builtbroken.militarybasedecor.modules.worldwar1.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/4/2016.
 */
public class ItemBlockWireFence extends ItemBlockWorldWar1
{

    public ItemBlockWireFence(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int p_77617_1_)
    {
        return this.field_150939_a.func_149735_b(2, BlockColored.func_150032_b(p_77617_1_));
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int p_77647_1_)
    {
        return p_77647_1_;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        super.addInformation(itemStack, player, list, par4);
        if (itemStack.getItemDamage() == 2)
        {
            list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("tooltip.wire_fence"));
        }
        if (itemStack.getItemDamage() == 3)
        {
            list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("tooltip.wire_fence"));
        }
    }
}