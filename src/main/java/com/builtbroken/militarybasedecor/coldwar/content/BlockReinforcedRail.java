package com.builtbroken.militarybasedecor.coldwar.content;

import java.util.List;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import net.minecraft.block.BlockRail;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

/** @author DarkGuardsman */
public class BlockReinforcedRail extends BlockRail
{
    public BlockReinforcedRail()
    {
        super();
        this.setBlockName("reinforcedRail");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "reinforced_rail");
        this.setHardness(10F);
        this.setResistance(10F);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }
    
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
    	list.add(EnumChatFormatting.BLUE + "Cold War Module");
    }

    @Override
    public float getRailMaxSpeed(World world, EntityMinecart cart, int y, int x, int z)
    {
        return 0.6f;
    }
}
