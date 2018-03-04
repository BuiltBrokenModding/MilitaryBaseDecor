package com.builtbroken.militarybasedecor.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.content.init.MBDInit;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 04/03/2018.
 */
public class BlockDamaging extends BlockBase {

    public static float entityDamageAmount;

    public BlockDamaging(String name, Material material, MapColor mapColor, SoundType soundType, float damageAmount) {
        super(name, material, mapColor, soundType);
        entityDamageAmount = damageAmount;
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

    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return new AxisAlignedBB(0, 0, 0, 0, 0, 0);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (!(entityIn instanceof EntityPlayer) || !((EntityPlayer) entityIn).capabilities.isCreativeMode) {
            entityIn.setInWeb();
            entityIn.attackEntityFrom(MBDInit.DAMAGE_WIRED_FENCE, entityDamageAmount);
        }
    }

    @Override
    public void registerModels() {
        MilitaryBaseDecor.PROXY.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}