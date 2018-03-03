package com.builtbroken.militarybasedecor.handler;

import com.builtbroken.militarybasedecor.content.container.ContainerAmmoCrate;
import com.builtbroken.militarybasedecor.content.container.ContainerAmmunitionBox;
import com.builtbroken.militarybasedecor.content.gui.GuiAmmoCrate;
import com.builtbroken.militarybasedecor.content.gui.GuiAmmunitionBox;
import com.builtbroken.militarybasedecor.content.tile.TileEntityAmmoCrate;
import com.builtbroken.militarybasedecor.content.tile.TileEntityAmmunitionBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 03/03/2018.
 */
public class MBDGuiHandler implements IGuiHandler {

    public static final int AMMO_CRATE = 0;
    public static final int AMMUNITION_BOX = 1;

    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case AMMO_CRATE:
                return new ContainerAmmoCrate(player.inventory, (TileEntityAmmoCrate) world.getTileEntity(new BlockPos(x, y, z)));
            case AMMUNITION_BOX:
                return new ContainerAmmunitionBox(player.inventory, (TileEntityAmmunitionBox) world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int i, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        switch (i) {
            case AMMO_CRATE:
                return new GuiAmmoCrate(getServerGuiElement(i, entityPlayer, world, x, y, z), entityPlayer.inventory);
            case AMMUNITION_BOX:
                return new GuiAmmunitionBox(getServerGuiElement(i, entityPlayer, world, x, y, z), entityPlayer.inventory);
            default:
                return null;
        }
    }
}
