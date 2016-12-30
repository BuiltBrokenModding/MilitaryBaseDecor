package com.builtbroken.militarybasedecor.modules.vanilla.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.vanilla.VanillaModule;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCauldron;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by henna on 30.12.2016.
 */
public class BlockBasicMixer extends BlockCauldron {

    @SideOnly(Side.CLIENT)
    private IIcon innerIcon;
    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    @SideOnly(Side.CLIENT)
    private IIcon bottomIcon;


    public BlockBasicMixer() {
        super();
        this.setBlockName("basic_mixer");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "basic_mixer");
        this.setHardness(2F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int int1, int int2)
    {
        return int1 == 1 ? this.topIcon : (int1 == 0 ? this.bottomIcon : this.blockIcon);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        this.innerIcon = register.registerIcon(this.getTextureName() + "_" + "inner");
        this.topIcon = register.registerIcon(this.getTextureName() + "_top");
        this.bottomIcon = register.registerIcon(this.getTextureName() + "_" + "bottom");
        this.blockIcon = register.registerIcon(this.getTextureName() + "_side");
    }

    @Override
    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {}


    // TODO Change liquid from water to liquid concrete, and add the planned recipe functionality.
    @Override
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (p_149727_1_.isRemote)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = p_149727_5_.inventory.getCurrentItem();

            if (itemstack == null)
            {
                return true;
            }
            else
            {
                int i1 = p_149727_1_.getBlockMetadata(p_149727_2_, p_149727_3_, p_149727_4_);
                int j1 = func_150027_b(i1);

                if (itemstack.getItem() == Items.water_bucket)
                {
                    if (j1 < 3)
                    {
                        if (!p_149727_5_.capabilities.isCreativeMode)
                        {
                            p_149727_5_.inventory.setInventorySlotContents(p_149727_5_.inventory.currentItem, new ItemStack(Items.bucket));
                        }

                        this.func_150024_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, 3);
                    }

                    return true;
                }

                    return false;
            }
        }
    }


    // TODO Properly load item and item texture!
    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return VanillaModule.basicMixerItem;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return VanillaModule.basicMixerItem;
    }
}