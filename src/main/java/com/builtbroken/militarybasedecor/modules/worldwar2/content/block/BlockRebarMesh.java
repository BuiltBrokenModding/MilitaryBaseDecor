package com.builtbroken.militarybasedecor.modules.worldwar2.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.worldwar1.WorldWar1Module;
import com.builtbroken.militarybasedecor.modules.worldwar2.WorldWar2Module;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by henna on 31.12.2016.
 */
public class BlockRebarMesh extends Block {

    public BlockRebarMesh() {
        super(Material.iron);
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "rebar_mesh");
        this.setStepSound(Block.soundTypeMetal);
        this.setBlockName("rebar_mesh");
    }

    public void removeItem(EntityPlayer player, ItemStack itemstack) {
        IInventory inv = player.inventory;
        for(int i=0; i < inv.getSizeInventory(); i++)
        {
            if(inv.getStackInSlot(i) != null)
            {
                ItemStack j = inv.getStackInSlot(i);
                if(j.getItem() != null && j.getItem() == itemstack.getItem())
                {
                    inv.setInventorySlotContents(i, null);
                }
            }
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {

        if (world.isRemote) {
            return true;
        } else {
            ItemStack itemstack = player.inventory.getCurrentItem();

            if (itemstack == null) {
                return true;
            } else {
                if (itemstack.getItem() == WorldWar1Module.liquidConcreteBucket) {
                        removeItem(player, itemstack);
                        world.setBlock(x, y, z, WorldWar2Module.reinforcedConcrete);
                }
                return true;
            }
        }
    }
}