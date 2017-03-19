package com.builtbroken.militarybasedecor.modules.blastcraft.content.machines.blastcompressor;

import com.builtbroken.mc.prefab.gui.ContainerBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

/**
 * @see <a href="https://github.com/BuilBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry Stabell) on 18.03.2017 for MilitaryBaseDecor.
 */
public class ContainerBlastCompressor extends ContainerBase
{
    private TileBlastCompressor tileBlastCompressor;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public ContainerBlastCompressor(EntityPlayer player, TileBlastCompressor blastCompressor)
    {
        super(player, blastCompressor);
        this.tileBlastCompressor = blastCompressor;
        this.addSlotToContainer(new Slot(blastCompressor, 0, 56, 17));

        this.addSlotToContainer(new SlotFurnace(player, blastCompressor, 2, 116, 35));

        this.addSlotToContainer(new Slot(blastCompressor, 4, 56, 53));

        addPlayerInventory(player);
    }

    @Override
    public void addCraftingToCrafters(ICrafting p_75132_1_)
    {
        super.addCraftingToCrafters(p_75132_1_);
        p_75132_1_.sendProgressBarUpdate(this, 0, this.tileBlastCompressor.processingTicks);
        p_75132_1_.sendProgressBarUpdate(this, 1, this.tileBlastCompressor.burnTime);
        p_75132_1_.sendProgressBarUpdate(this, 2, this.tileBlastCompressor.burnTimeItem);
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if (this.lastCookTime != this.tileBlastCompressor.processingTicks)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tileBlastCompressor.processingTicks);
            }

            if (this.lastBurnTime != this.tileBlastCompressor.burnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tileBlastCompressor.burnTime);
            }

            if (this.lastItemBurnTime != this.tileBlastCompressor.burnTimeItem)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.tileBlastCompressor.burnTimeItem);
            }
        }

        this.lastCookTime = this.tileBlastCompressor.processingTicks;
        this.lastBurnTime = this.tileBlastCompressor.burnTime;
        this.lastItemBurnTime = this.tileBlastCompressor.burnTimeItem;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value)
    {
        if (id == 0)
        {
            this.tileBlastCompressor.processingTicks = value;
        }

        if (id == 1)
        {
            this.tileBlastCompressor.burnTime = value;
        }

        if (id == 2)
        {
            this.tileBlastCompressor.burnTimeItem = value;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return this.tileBlastCompressor.isUseableByPlayer(p_75145_1_);
    }
}