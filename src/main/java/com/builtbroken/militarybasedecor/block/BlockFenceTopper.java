package com.builtbroken.militarybasedecor.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.init.MBDInit;
import com.builtbroken.militarybasedecor.util.IIModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFenceTopper extends Block implements IIModel {
    public static final PropertyDirection FACING;
    protected static final AxisAlignedBB X_AXIS_AABB;
    protected static final AxisAlignedBB Z_AXIS_AABB;
    public static float entityDamageAmount;

    public BlockFenceTopper(String name, Material material, MapColor mapColor, SoundType soundType, Float damageAmount) {
        super(material, mapColor);
        setUnlocalizedName(name);
        setRegistryName(name);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setLightOpacity(0);
        blockSoundType = soundType;
        entityDamageAmount = damageAmount;
        MBDInit.BLOCKS.add(this);
        MBDInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        setCreativeTab(MilitaryBaseDecor.MILITARTYBASEDECORTAB);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (!(entityIn instanceof EntityPlayer) || !((EntityPlayer) entityIn).capabilities.isCreativeMode)
        {
            entityIn.setInWeb();
            entityIn.attackEntityFrom(MBDInit.DAMAGE_WIRED_FENCE, entityDamageAmount);
        }
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3));
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        return enumfacing.getAxis() == EnumFacing.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
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

    static {
        FACING = BlockHorizontal.FACING;
        X_AXIS_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.225D, 1.0D, 0.3D, 0.775D);
        Z_AXIS_AABB = new AxisAlignedBB(0.225D, 0.0D, 0.0D, 0.775D, 0.3D, 1.0D);
    }

    @Override
    public void registerModels() {
        MilitaryBaseDecor.PROXY.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}