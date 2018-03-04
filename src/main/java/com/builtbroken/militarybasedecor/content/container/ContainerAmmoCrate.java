package com.builtbroken.militarybasedecor.content.container;

import com.builtbroken.militarybasedecor.content.tile.TileEntityAmmoCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 03/03/2018.
 */
public class ContainerAmmoCrate extends Container {

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();

            if (index < containerSlots) {
                if (!this.mergeItemStack(itemstack1, containerSlots, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

    public ContainerAmmoCrate(InventoryPlayer playerInv, final TileEntityAmmoCrate crate) {
            IItemHandler inventory = crate.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);

        for (int i =0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new SlotItemHandler(inventory, j + i * 9 + 9, 8 + j * 18, 17 + i * 18) {
                    @Override
                    public void onSlotChanged() {
                        crate.markDirty();
                    }});
                }
            }

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 9; l++) {
                addSlotToContainer(new Slot(playerInv, l + k * 9 + 9, 8 + l * 18, 84 + k * 18));
            }
        }

        for (int m = 0; m < 9; m++) {
            addSlotToContainer(new Slot(playerInv, m, 8 + m * 18, 142));
        }
    }
}