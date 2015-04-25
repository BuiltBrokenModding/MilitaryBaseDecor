package com.builtbroken.militarybasedecor.vanilla.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWiredDoor extends BlockDoor {

	@SideOnly(Side.CLIENT)
    private IIcon[] field_150017_a;
    @SideOnly(Side.CLIENT)
    private IIcon[] field_150016_b;
	
	public BlockWiredDoor(Material p_i45402_1_) {
		super(Material.iron);
		float f = 0.5F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
	}

	 @SideOnly(Side.CLIENT)
	    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	    {
	        return this.field_150016_b[0];
	    }

	    @SideOnly(Side.CLIENT)
	    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
	    {
	        if (p_149673_5_ != 1 && p_149673_5_ != 0)
	        {
	            int i1 = this.func_150012_g(p_149673_1_, p_149673_2_, p_149673_3_, p_149673_4_);
	            int j1 = i1 & 3;
	            boolean flag = (i1 & 4) != 0;
	            boolean flag1 = false;
	            boolean flag2 = (i1 & 8) != 0;

	            if (flag)
	            {
	                if (j1 == 0 && p_149673_5_ == 2)
	                {
	                    flag1 = !flag1;
	                }
	                else if (j1 == 1 && p_149673_5_ == 5)
	                {
	                    flag1 = !flag1;
	                }
	                else if (j1 == 2 && p_149673_5_ == 3)
	                {
	                    flag1 = !flag1;
	                }
	                else if (j1 == 3 && p_149673_5_ == 4)
	                {
	                    flag1 = !flag1;
	                }
	            }
	            else
	            {
	                if (j1 == 0 && p_149673_5_ == 5)
	                {
	                    flag1 = !flag1;
	                }
	                else if (j1 == 1 && p_149673_5_ == 3)
	                {
	                    flag1 = !flag1;
	                }
	                else if (j1 == 2 && p_149673_5_ == 4)
	                {
	                    flag1 = !flag1;
	                }
	                else if (j1 == 3 && p_149673_5_ == 2)
	                {
	                    flag1 = !flag1;
	                }

	                if ((i1 & 16) != 0)
	                {
	                    flag1 = !flag1;
	                }
	            }

	            return flag2 ? this.field_150017_a[flag1?1:0] : this.field_150016_b[flag1?1:0];
	        }
	        else
	        {
	            return this.field_150016_b[0];
	        }
	    }

	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister p_149651_1_)
	    {
	        this.field_150017_a = new IIcon[2];
	        this.field_150016_b = new IIcon[2];
	        this.field_150017_a[0] = p_149651_1_.registerIcon(this.getTextureName() + "_upper");
	        this.field_150016_b[0] = p_149651_1_.registerIcon(this.getTextureName() + "_lower");
	        this.field_150017_a[1] = new IconFlipped(this.field_150017_a[0], true, false);
	        this.field_150016_b[1] = new IconFlipped(this.field_150016_b[0], true, false);
	    }
	    
	    @Override
	    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	    {
	            int i1 = this.func_150012_g(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
	            int j1 = i1 & 7;
	            j1 ^= 4;

	            if ((i1 & 8) == 0)
	            {
	                p_149727_1_.setBlockMetadataWithNotify(p_149727_2_, p_149727_3_, p_149727_4_, j1, 2);
	                p_149727_1_.markBlockRangeForRenderUpdate(p_149727_2_, p_149727_3_, p_149727_4_, p_149727_2_, p_149727_3_, p_149727_4_);
	            }
	            else
	            {
	                p_149727_1_.setBlockMetadataWithNotify(p_149727_2_, p_149727_3_ - 1, p_149727_4_, j1, 2);
	                p_149727_1_.markBlockRangeForRenderUpdate(p_149727_2_, p_149727_3_ - 1, p_149727_4_, p_149727_2_, p_149727_3_, p_149727_4_);
	            }

	            p_149727_1_.playAuxSFXAtEntity(p_149727_5_, 1003, p_149727_2_, p_149727_3_, p_149727_4_, 0);
	            return true;
	        }
}
