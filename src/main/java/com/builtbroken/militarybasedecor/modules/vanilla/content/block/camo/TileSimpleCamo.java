package com.builtbroken.militarybasedecor.modules.vanilla.content.block.camo;

import com.builtbroken.mc.core.network.IPacketReceiver;
import com.builtbroken.mc.core.network.packet.PacketTile;
import com.builtbroken.mc.core.network.packet.PacketType;
import com.builtbroken.mc.imp.transform.vector.Pos;
import com.builtbroken.mc.prefab.tile.Tile;
import com.builtbroken.mc.prefab.tile.TileEnt;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

/**
 * Basic camo block that can only mimic blocks, has no additional features.
 * Created by robert on 1/25/2015.
 */
public class TileSimpleCamo extends TileEnt implements IPacketReceiver
{
    public ItemStack stack = null;
    boolean locked = false;

    @SideOnly(Side.CLIENT)
    public static IIcon simpleCamoTexture;

    public TileSimpleCamo(String name, Material material)
    {
        super(name, material);
        this.itemBlock = ItemBlockCamo.class;
        this.creativeTab = (MilitaryBaseDecor.MAIN_TAB);
    }

    @Override
    public Tile newTile()
    {
        return new TileSimpleCamo("simple_camo", Material.rock);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        simpleCamoTexture = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "simple_camo");
    }

    @Override
    protected boolean onPlayerRightClick(EntityPlayer player, int side, Pos hit)
    {
        if (!locked && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemBlock)
        {
            Block block = Block.getBlockFromItem(player.getCurrentEquippedItem().getItem());
            if (block != null && block != getTileBlock())
            {
                stack = player.getCurrentEquippedItem().copy();
                stack.stackSize = 1;
                sendDescPacket();
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean onPlayerRightClickWrench(EntityPlayer player, int side, Pos hit)
    {
        if (player.isSneaking())
        {
            locked = !locked;
            return true;
        }
        return false;
    }

    @Override
    public void onPlaced(EntityLivingBase entityLiving, ItemStack itemStack)
    {
        if (itemStack != null && itemStack.getTagCompound() != null)
        {
            stack = ItemStack.loadItemStackFromNBT(itemStack.getTagCompound().getCompoundTag("data"));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        Block block = getMimicBlock();
        if (block != null)
        {
            return block.getIcon(side, stack.getItem().getMetadata(stack.getItemDamage()));
        }
        return simpleCamoTexture;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorMultiplier()
    {
        Block block = getMimicBlock();
        if (block != null)
        {
            return block.colorMultiplier(oldWorld(), xi(), yi(), zi());
        }
        return super.getColorMultiplier();
    }

    public Block getMimicBlock()
    {
        if (stack != null && stack.getItem() instanceof ItemBlock)
        {
            Block block = Block.getBlockFromItem(stack.getItem());
            if (block != null && block != getTileBlock())
            {
                return block;
            }
        }
        return null;
    }

    @Override
    public ItemStack toItemStack()
    {
        ItemStack stack = new ItemStack(getTileBlock());
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setTag("data", tag);
        return stack;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setBoolean("locked", locked);
        if (stack != null)
        {
            nbt.setTag("data", stack.writeToNBT(new NBTTagCompound()));
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        locked = nbt.getBoolean("locked");
        if (nbt.hasKey("data"))
        {
            stack = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("data"));
        }
    }

    @Override
    public PacketTile getDescPacket()
    {
        return new PacketTile(this, getSaveData());
    }

    @Override
    public void read(ByteBuf buf, EntityPlayer player, PacketType packet)
    {
        readFromNBT(ByteBufUtils.readTag(buf));
        oldWorld().markBlockRangeForRenderUpdate(xi(), yi(), zi(), xi(), yi(), zi());
    }

    @Override
    public boolean canUpdate()
    {
        return false;
    }
}
