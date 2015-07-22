package com.builtbroken.militarybasedecor.vanilla.content.item;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class ItemWiredDoor extends Item {

    private Material doorMaterial;

    public ItemWiredDoor(Material material) {
        this.doorMaterial = material;
        this.maxStackSize = 1;
        this.setUnlocalizedName(MilitaryBaseDecor.DOMAIN + ":" + "wired_door");
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
    }

    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (p_77648_7_ != 1) {
            return false;
        } else {
            ++p_77648_5_;
            Block block;

            if (this.doorMaterial == Material.iron) {
                block = VanillaModule.wiredDoor;

                if (p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) && p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, p_77648_1_)) {
                    if (!block.canPlaceBlockAt(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) {
                        return false;
                    } else {
                        int i1 = MathHelper.floor_double((double) ((p_77648_2_.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
                        placeDoorBlock(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i1, block);
                        --p_77648_1_.stackSize;
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        return bFull3D;
    }

    public static void placeDoorBlock(World p_150924_0_, int p_150924_1_, int p_150924_2_, int p_150924_3_, int p_150924_4_, Block p_150924_5_) {
        byte b0 = 0;
        byte b1 = 0;

        if (p_150924_4_ == 0) {
            b1 = 1;
        }

        if (p_150924_4_ == 1) {
            b0 = -1;
        }

        if (p_150924_4_ == 2) {
            b1 = -1;
        }

        if (p_150924_4_ == 3) {
            b0 = 1;
        }

        int i1 = (p_150924_0_.getBlock(p_150924_1_ - b0, p_150924_2_, p_150924_3_ - b1).isNormalCube() ? 1 : 0) + (p_150924_0_.getBlock(p_150924_1_ - b0, p_150924_2_ + 1, p_150924_3_ - b1).isNormalCube() ? 1 : 0);
        int j1 = (p_150924_0_.getBlock(p_150924_1_ + b0, p_150924_2_, p_150924_3_ + b1).isNormalCube() ? 1 : 0) + (p_150924_0_.getBlock(p_150924_1_ + b0, p_150924_2_ + 1, p_150924_3_ + b1).isNormalCube() ? 1 : 0);
        boolean flag = p_150924_0_.getBlock(p_150924_1_ - b0, p_150924_2_, p_150924_3_ - b1) == p_150924_5_ || p_150924_0_.getBlock(p_150924_1_ - b0, p_150924_2_ + 1, p_150924_3_ - b1) == p_150924_5_;
        boolean flag1 = p_150924_0_.getBlock(p_150924_1_ + b0, p_150924_2_, p_150924_3_ + b1) == p_150924_5_ || p_150924_0_.getBlock(p_150924_1_ + b0, p_150924_2_ + 1, p_150924_3_ + b1) == p_150924_5_;
        boolean flag2 = false;

        if (flag && !flag1) {
            flag2 = true;
        } else if (j1 > i1) {
            flag2 = true;
        }

        p_150924_0_.setBlock(p_150924_1_, p_150924_2_, p_150924_3_, p_150924_5_, p_150924_4_, 2);
        p_150924_0_.setBlock(p_150924_1_, p_150924_2_ + 1, p_150924_3_, p_150924_5_, 8 | (flag2 ? 1 : 0), 2);
        p_150924_0_.notifyBlocksOfNeighborChange(p_150924_1_, p_150924_2_, p_150924_3_, p_150924_5_);
        p_150924_0_.notifyBlocksOfNeighborChange(p_150924_1_, p_150924_2_ + 1, p_150924_3_, p_150924_5_);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.BLUE + "Vanilla Module");
    }
}