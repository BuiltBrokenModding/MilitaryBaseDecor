package com.builtbroken.militarybasedecor.vanilla.content.block;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import com.builtbroken.mc.api.items.ISimpleItemRenderer;
import com.builtbroken.mc.lib.render.model.loader.EngineModelLoader;
import com.builtbroken.mc.lib.transform.region.Cube;
import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.prefab.tile.Tile;
import com.builtbroken.mc.prefab.tile.TileEnt;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.references.Assets;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.IModelCustom;

public class TilePole extends TileEnt implements ISimpleItemRenderer{
	
	public TilePole() {
		super("pane_pole", Material.iron);
		this.itemBlock = ItemBlockVanilla.class;
		this.isOpaque = false;
        this.renderNormalBlock = false;
        this.renderTileEntity = true;
        this.bounds = new Cube(0.42F, 0F, 0.42F, 0.60F, 1F, 0.60F);
	}

	@Override
    public Tile newTile()
    {
        return new TilePole();
    }
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon()
    {
        return Blocks.iron_block.getIcon(0, 0);
    }
	
	@Override
	public void renderInventoryItem(IItemRenderer.ItemRenderType type, ItemStack itemStack, Object... data) {
		GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.PANE_POLE_TEXTURE);
        Assets.PANE_POLE_MODEL.renderAll();
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
        //Render Pole
        GL11.glPushMatrix();
        GL11.glTranslatef(pos.xf() + 0.5f, pos.yf() + 0.5f, pos.zf() + 0.5f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.PANE_POLE_TEXTURE);
        Assets.PANE_POLE_MODEL.renderAll();
        GL11.glPopMatrix();
    }
}