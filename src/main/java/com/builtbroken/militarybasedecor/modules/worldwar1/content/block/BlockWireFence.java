package com.builtbroken.militarybasedecor.modules.worldwar1.content.block;

import com.builtbroken.militarybasedecor.core.ConfigManager;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.vanilla.VanillaModule;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockWireFence extends BlockPane
{
    @SideOnly(Side.CLIENT)
    IIcon chainLinkIcon;
    @SideOnly(Side.CLIENT)
    IIcon wireIcon;

    public BlockWireFence()
    {
        super(MilitaryBaseDecor.PREFIX + "barbed_wire_fence", MilitaryBaseDecor.PREFIX + "wired_fence_top", Material.iron, true);
        this.setBlockName("wire_fence");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "wire_fence");
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
        super.registerBlockIcons(reg);
        chainLinkIcon = reg.registerIcon(MilitaryBaseDecor.PREFIX + "chain_link_fence");
        wireIcon = reg.registerIcon(MilitaryBaseDecor.PREFIX + "wired_fence");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xhit, float yhit, float zhit)
    {
        if (player.getHeldItem() != null && player.getHeldItem().getItem() == VanillaModule.wireCutters)
        {
            if (!world.isRemote)
            {
                if (world.setBlockToAir(x, y, z) && !player.capabilities.isCreativeMode)
                {
                    world.playSoundEffect(x, y, z, "militarybasedecor:wirecutters", 2.0F, 1.0F);
                    player.inventory.addItemStackToInventory(new ItemStack(this.getItem(world, x, y, z)));
                    player.inventoryContainer.detectAndSendChanges();
                    player.getHeldItem().damageItem(1, player);

                    if (ConfigManager.WIRECUTTERS_CHAT)
                    {
                        player.addChatMessage(new ChatComponentText(player.getDisplayName() + " cut a Barbed Wire Fence"));
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity player)
    {
        if (WireFence.getType(world, i, j, k) == WireFence.BARBED)
        {
            if (!(player instanceof EntityPlayer) || !((EntityPlayer) player).capabilities.isCreativeMode)
            {
                player.setInWeb();
                player.attackEntityFrom(DamageSource.cactus, 1.0F);
            }
        }
    }

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
        return true;
    }

    /** Enum of wire types */
    public enum WireFence
    {
        WIRE,
        LINK,
        BARBED;

        public static WireFence getType(World world, int x, int y, int z)
        {
            int meta = world.getBlockMetadata(x, y, z);
            if (meta > 0 && meta < WireFence.values().length)
            {
                return WireFence.values()[meta];
            }
            return WIRE;
        }
    }
}
