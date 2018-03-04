package com.builtbroken.militarybasedecor.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.content.init.MBDInit;
import com.builtbroken.militarybasedecor.content.tile.TileEntityAmmoCrate;
import com.builtbroken.militarybasedecor.core.handler.MBDGuiHandler;
import com.builtbroken.militarybasedecor.core.handler.MBDSoundHandler;
import com.builtbroken.militarybasedecor.core.util.IIModel;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 03/03/2018.
 */
public class BlockAmmoCrate extends BlockTileEntity<TileEntityAmmoCrate> implements IIModel {

    public static final PropertyDirection FACING;
    protected static final AxisAlignedBB CRATE_EAST_AABB;
    protected static final AxisAlignedBB CRATE_WEST_AABB;
    protected static final AxisAlignedBB CRATE_SOUTH_AABB;
    protected static final AxisAlignedBB CRATE_NORTH_AABB;

    public BlockAmmoCrate() {
        super("ammo_crate", Material.WOOD, MapColor.WOOD, SoundType.WOOD);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3));
    }

    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
        return i;
    }

    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.getBlock() != this ? state : state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        EnumFacing enumfacing = placer.getHorizontalFacing().rotateY();
        return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, enumfacing);
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch((EnumFacing)state.getValue(FACING)) {
            case EAST:
            default:
                return CRATE_EAST_AABB;
            case WEST:
                return CRATE_WEST_AABB;
            case SOUTH:
                return CRATE_SOUTH_AABB;
            case NORTH:
                return CRATE_NORTH_AABB;
        }
    }

    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        switch((EnumFacing)blockState.getValue(FACING)) {
            case EAST:
            default:
                return CRATE_EAST_AABB;
            case WEST:
                return CRATE_WEST_AABB;
            case SOUTH:
                return CRATE_SOUTH_AABB;
            case NORTH:
                return CRATE_NORTH_AABB;
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        player.playSound(MBDSoundHandler.openAmmoCrate,1.0F, 1F);
        if (!world.isRemote) {
            player.openGui(MilitaryBaseDecor.INSTANCE, MBDGuiHandler.AMMO_CRATE, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityAmmoCrate tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);

        for (int i = 0; i < itemHandler.getSlots(); i++) {
            ItemStack stack = itemHandler.getStackInSlot(i);
            if (!stack.isEmpty()) {
                EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
                world.spawnEntity(item);
            }
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public Class<TileEntityAmmoCrate> getTileEntityClass() {
        return TileEntityAmmoCrate.class;
    }

    @Nullable
    @Override
    public TileEntityAmmoCrate createTileEntity(World world, IBlockState state) {
        return new TileEntityAmmoCrate();
    }

    static {
        FACING = BlockHorizontal.FACING;
        CRATE_EAST_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.25D, 0.9375D, 0.375D, 0.75D); // NORTH
        CRATE_WEST_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.25D, 0.9375D, 0.375D, 0.75D); // SOUTH
        CRATE_SOUTH_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.0625D, 0.75D, 0.375D, 0.9375D); // EAST
        CRATE_NORTH_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.0625D, 0.75D, 0.375D, 0.9375D); // WEST
    }
}