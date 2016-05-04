package com.builtbroken.militarybasedecor.modules.worldwar1.content.block;

import com.builtbroken.militarybasedecor.core.ConfigManager;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.vanilla.VanillaModule;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by Ole on 23.01.2015.
 */
public class BlockBarbedWireFence extends BlockPane
{

    public PlayerCapabilities capabilities = new PlayerCapabilities();

    public BlockBarbedWireFence()
    {
        super("militarybasedecor:barbed_wire_fence", "militarybasedecor:wired_fence_top", Material.iron, true);
        this.setBlockName("barbed_wire_fence");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "barbed_wire_fence");
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(MilitaryBaseDecor.MAIN_TAB);
        this.setBlockUnbreakable();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int int4, float float1, float float2, float float3)
    {

        if (world.isRemote)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = player.inventory.getCurrentItem();

            if (itemstack == null)
            {
                return true;
            }
            else
            {
                if (itemstack.getItem() == VanillaModule.wireCutters)
                {
                    world.playSoundEffect(x, y, z, "militarybasedecor:wirecutters", 2.0F, 1.0F);
                    itemstack.damageItem(1, player);
                    world.setBlockToAir(x, y, z);
                    player.inventory.addItemStackToInventory(new ItemStack(this.getItem(world, x, y, z)));
                    player.inventoryContainer.detectAndSendChanges();
                    if (ConfigManager.WIRECUTTERS_CHAT)
                    {
                        player.addChatMessage(new ChatComponentText(player.getDisplayName() + " cut a Barbed Wire Fence"));
                    }
                }
                return true;
            }
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity player)
    {
        if (!(player instanceof EntityPlayer) || !((EntityPlayer) player).capabilities.isCreativeMode)
        {
            player.setInWeb();
            player.attackEntityFrom(DamageSource.cactus, 1.0F);
        }
    }

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
        return true;
    }
}
