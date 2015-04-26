package com.builtbroken.militarybasedecor.vanilla.content.block;

import io.netty.buffer.ByteBuf;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.common.util.ForgeDirection;

import com.builtbroken.mc.api.items.ISimpleItemRenderer;
import com.builtbroken.mc.api.tile.IRotation;
import com.builtbroken.mc.lib.transform.region.Cube;
import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.prefab.tile.Tile;
import com.builtbroken.mc.prefab.tile.TileEnt;
import com.builtbroken.mc.prefab.tile.TileMachine;
import com.builtbroken.militarybasedecor.references.Assets;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TilePaneBarbs extends TileMachine implements ISimpleItemRenderer{
	
	public TilePaneBarbs() {
		super("pane_barbs", Material.iron);
		this.itemBlock = ItemBlockVanilla.class;
		this.isOpaque = false;
        this.renderNormalBlock = false;
        this.renderTileEntity = true;
        this.bounds = new Cube(0F, 0F, 0F, 1F, 0.35F, 1F);
	}
	
	@Override
	public void onCollide(Entity entity)
    {
		entity.setInWeb();
		entity.attackEntityFrom(DamageSource.cactus, 1.0F);
    }

	@Override
    public Tile newTile()
    {
        return new TilePaneBarbs();
    }

	@SideOnly(Side.CLIENT)
    public IIcon getIcon()
    {
        return Blocks.iron_block.getIcon(0, 0);
    }
	
	@Override
	public void renderInventoryItem(IItemRenderer.ItemRenderType type, ItemStack itemStack, Object... data) {
		GL11.glTranslatef(0.7f, 0.7f, 0.7f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.PANE_BARBS_TEXTURE);
        Assets.PANE_BARBS_MODEL.renderAll();;
	}
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
    {
        return new Cube(0, 0, 0, 1, 3, 1).add(x(), y(), z()).toAABB();
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void renderDynamic(Pos pos, float frame, int pass)
    {
        //Render Pane Barbs
        GL11.glPushMatrix();
        GL11.glTranslatef(pos.xf() + 0.5f, pos.yf() + 0.5f, pos.zf() + 0.5f);
        switch(facing)
        {
        	case EAST: break;
        	case WEST: GL11.glRotatef(180f, 0, 1f, 0); break;
        	case SOUTH: GL11.glRotatef(-90f, 0, 1f, 0); break;
        	default: GL11.glRotatef(90f, 0, 1f, 0); break;
        }
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.PANE_BARBS_TEXTURE);
        Assets.PANE_BARBS_MODEL.renderAll();
        GL11.glPopMatrix();
    }
	
	 @SideOnly(Side.CLIENT)
	    public void registerIcons(IIconRegister iconRegister)
	    {

	    }
}