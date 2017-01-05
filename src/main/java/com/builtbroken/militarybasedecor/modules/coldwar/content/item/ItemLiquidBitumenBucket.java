package com.builtbroken.militarybasedecor.modules.coldwar.content.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by henna on 02.01.2017.
 */
public class ItemLiquidBitumenBucket extends Item {
    
        private Block block;

        public ItemLiquidBitumenBucket(Block block)
        {
            this.block = block;
        }

        /**
         * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
         * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
         */
        public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int par4, float par5, float par6, float par7)
        {
            Block block = world.getBlock(x, y, z);

            if (block == Blocks.snow_layer && (world.getBlockMetadata(x, y, z) & 7) < 1)
            {
                par4 = 1;
            }
            else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush)
            {
                if (par4 == 0)
                {
                    --y;
                }

                if (par4 == 1)
                {
                    ++y;
                }

                if (par4 == 2)
                {
                    --z;
                }

                if (par4 == 3)
                {
                    ++z;
                }

                if (par4 == 4)
                {
                    --x;
                }

                if (par4 == 5)
                {
                    ++x;
                }
            }

            if (!player.canPlayerEdit(x, y, z, par4, item))
            {
                return false;
            }
            else if (item.stackSize == 0)
            {
                return false;
            }
            else
            {
                if (world.canPlaceEntityOnSide(this.block, x, y, z, false, par4, (Entity)null, item))
                {
                    int i1 = this.block.onBlockPlaced(world, x, y, z, par4, par5, par6, par7, 0);

                    if (world.setBlock(x, y, z, this.block, i1, 3))
                    {
                        if (world.getBlock(x, y, z) == this.block)
                        {
                            this.block.onBlockPlacedBy(world, x, y, z, player, item);
                            this.block.onPostBlockPlaced(world, x, y, z, i1);
                        }
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.bucket));
                        world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.block.stepSound.func_150496_b(), (this.block.stepSound.getVolume() + 1.0F) / 2.0F, this.block.stepSound.getPitch() * 0.8F);
                        --item.stackSize;
                    }
                }

                return true;
            }
        }
}

