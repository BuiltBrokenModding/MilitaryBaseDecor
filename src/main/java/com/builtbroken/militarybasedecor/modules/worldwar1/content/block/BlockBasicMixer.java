package com.builtbroken.militarybasedecor.modules.worldwar1.content.block;

import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.vanilla.VanillaModule;
import com.builtbroken.militarybasedecor.modules.worldwar1.content.render.RenderBasicMixer;
import com.builtbroken.militarybasedecor.modules.worldwar1.WorldWar1Module;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

/**
 * Created by hennamann on 30.12.2016.
 */
public class BlockBasicMixer extends Block implements IRecipeContainer {

    @SideOnly(Side.CLIENT)
    public static IIcon[] textures;

    public static int stickCount = 0;

    public BlockBasicMixer() {
        super(Material.wood);
        this.setBlockName("basic_mixer");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "basic_mixer");
        this.setHardness(2F);
        this.setStepSound(Block.soundTypeWood);
    }

    @Override
    public CreativeTabs getCreativeTabToDisplayOn() {
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? textures[3] : (side == 0 ? textures[0] : textures[2]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        textures = new IIcon[5];

        textures[0] = register.registerIcon(this.getTextureName() +  "_bottom");
        textures[1] = register.registerIcon(this.getTextureName() + "_inner");
        textures[2] = register.registerIcon(this.getTextureName() + "_side");
        textures[3] = register.registerIcon(this.getTextureName() + "_top");
        textures[4] = register.registerIcon(this.getTextureName() + "_liquid");
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return WorldWar1Module.basicMixerItem;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return WorldWar1Module.basicMixerItem;
    }

    @Override
    public int getRenderType()
    {
        return RenderBasicMixer.id;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
    {
        return true;
    }

    @Override
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axis, List list, Entity entity)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
        float f = 0.125F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
        this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
        this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
        this.setBlockBoundsForItemRender();
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity player)
    {
        int l = func_150027_b(world.getBlockMetadata(x, y, z));
        float f = (float)y + (6.0F + (float)(3 * l)) / 16.0F;

        if (!world.isRemote && l > 0 && player.boundingBox.minY <= (double)f)
        {
            player.setInWeb();
            player.attackEntityFrom(WorldWar1Module.concreteSolidify, 1.0F);
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = player.inventory.getCurrentItem();

            if (itemstack == null)
            {
                return true;
            }
            else
            {
                int i1 = world.getBlockMetadata(x, y, z);
                int j1 = func_150027_b(i1);



                if (itemstack.getItem() == WorldWar1Module.liquidConcreteBucket)
                {
                    if (j1 < 3)
                    {
                        this.func_150024_a(world, x, y, z, 3);
                    }

                    return true;
                }
                else
                {
                    if (itemstack.getItem() == Items.stick)
                    {
                        if (j1 > 0)
                        {
                            makeBasicConcrete(world, x, y, z);
                            stickCount++;
                        }
                    }
                    return false;
                }
            }
        }
    }

    public void makeBasicConcrete(World world, int x, int y, int z)
    {
        int i1 = world.getBlockMetadata(x, y, z);
        int j1 = func_150027_b(i1);

        if (!world.isRemote) {
            if (stickCount == 5) {
                world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Item.getItemFromBlock(WorldWar1Module.basicConcrete), 5, 0)));
                stickCount = 0;
                func_150024_a(world, x, y, z, j1 - 3);
            }
        }

        return;
    }

    public void func_150024_a(World p_150024_1_, int p_150024_2_, int p_150024_3_, int p_150024_4_, int p_150024_5_)
    {
        p_150024_1_.setBlockMetadataWithNotify(p_150024_2_, p_150024_3_, p_150024_4_, MathHelper.clamp_int(p_150024_5_, 0, 3), 2);
        p_150024_1_.func_147453_f(p_150024_2_, p_150024_3_, p_150024_4_, this);
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_)
    {
        int i1 = p_149736_1_.getBlockMetadata(p_149736_2_, p_149736_3_, p_149736_4_);
        return func_150027_b(i1);
    }

    public static int func_150027_b(int p_150027_0_)
    {
        return p_150027_0_;
    }

    @SideOnly(Side.CLIENT)
    public static float getRenderLiquidLevel(int p_150025_0_)
    {
        int j = MathHelper.clamp_int(p_150025_0_, 0, 3);
        return (float)(6 + 3 * j) / 16.0F;
    }

    @Override
    public void genRecipes(List<IRecipe> recipes) {
        GameRegistry.addShapedRecipe(new ItemStack(WorldWar1Module.basicMixerItem, 1, 0), "W W", "W W", "WWW", 'W', Blocks.planks);
    }
}