package com.builtbroken.militarybasedecor.coldwar.content;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.List;
import java.util.Random;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Ole on 23.01.2015.
 */
public class BlockBarbedWire extends BlockPane {

    public BlockBarbedWire()
    {
        super("militarybasedecor:barbed_wire", "militarybasedecor:barbed_wire", Material.iron, true);
        this.setBlockName("barbed_wire");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "barbed_wire");
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }
    
    	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    	{
    	list.add(EnumChatFormatting.AQUA + "Cold War Module");
    	}
    
    	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    	{
        return null;
    	}
    
		public void onEntityCollidedWithBlock(World world, int player, int player2, int player3, Entity entity)
		{
			entity.attackEntityFrom(DamageSource.cactus, 1.0F);
			entity.setInWeb();
		}
}
