package com.builtbroken.militarybasedecor.modules.future.content.block;

import com.builtbroken.mc.api.items.ISimpleItemRenderer;
import com.builtbroken.mc.lib.transform.region.Cube;
import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.prefab.tile.Tile;
import com.builtbroken.militarybasedecor.client.Assets;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ole on 5/15/2015.
 */
public class TileGlassFloorPanel extends Tile implements ISimpleItemRenderer
{

    public TileGlassFloorPanel()
    {
        super("glass_floor_panel", Material.glass);
        this.creativeTab = (MilitaryBaseDecor.CREATIVE_TAB_1);
        this.isOpaque = false;
        this.renderNormalBlock = false;
        this.renderTileEntity = true;
        this.stepSound = Block.soundTypeGlass;
        this.itemBlock = ItemBlockFuture.class;
        this.bounds = new Cube(0.0F, 0.94F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public Tile newTile()
    {
        return new TileGlassFloorPanel();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon()
    {
        return Blocks.glass.getIcon(0, 0);
    }

    @Override
    public void renderInventoryItem(IItemRenderer.ItemRenderType type, ItemStack itemStack, Object... data)
    {
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        GL11.glScaled(1f, 1f, 1f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.GLASS_FLOOR_PANEL_TEXTURE);
        Assets.GLASS_FLOOR_PANEL_MODEL.renderAll();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
    {
        return new Cube(0, 0, 0, 1, 3, 1).add(x(), y(), z()).toAABB();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderDynamic(Pos pos, float frame, int pass)
    {
        //Render Glass Floor Panel
        GL11.glPushMatrix();
        GL11.glTranslatef(pos.xf() + 0.5f, pos.yf() + 0.5f, pos.zf() + 0.5f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.GLASS_FLOOR_PANEL_TEXTURE);
        Assets.GLASS_FLOOR_PANEL_MODEL.renderAll();
        GL11.glPopMatrix();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {

    }

}
