package com.builtbroken.militarybasedecor.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.content.tile.TileEntityAmmoCrate;
import com.builtbroken.militarybasedecor.content.tile.TileEntityAmmunitionBox;
import com.builtbroken.militarybasedecor.handler.MBDGuiHandler;
import com.builtbroken.militarybasedecor.util.IIModel;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 04/03/2018.
 */
public class BlockAmmunitionBox extends BlockTileEntity<TileEntityAmmunitionBox> implements IIModel {

    public BlockAmmunitionBox() {
        super("ammunition_box", Material.IRON, MapColor.IRON, SoundType.METAL);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            player.openGui(MilitaryBaseDecor.INSTANCE, MBDGuiHandler.AMMUNITION_BOX, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityAmmunitionBox tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);

        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public Class<TileEntityAmmunitionBox> getTileEntityClass() {
        return TileEntityAmmunitionBox.class;
    }

    @Nullable
    @Override
    public TileEntityAmmunitionBox createTileEntity(World world, IBlockState state) {
        return new TileEntityAmmunitionBox();
    }
}