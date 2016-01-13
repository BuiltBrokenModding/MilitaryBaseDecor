package com.builtbroken.militarybasedecor.future.content.block;

import com.builtbroken.mc.api.items.ISimpleItemRenderer;
import com.builtbroken.mc.lib.transform.region.Cube;
import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.prefab.tile.Tile;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.future.FutureModule;
import com.builtbroken.militarybasedecor.references.Assets;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
public class TileMeshedFloorPanel extends Tile implements ISimpleItemRenderer {

    public TileMeshedFloorPanel() {
        super("meshed_floor_panel", Material.iron);
        this.creativeTab = (MilitaryBaseDecor.CREATIVE_TAB_1);
        this.isOpaque = false;
        this.renderNormalBlock = false;
        this.renderTileEntity = true;
        this.itemBlock = ItemBlockFuture.class;
        this.bounds = new Cube(0.0F, 0.94F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public Tile newTile() {
        return new TileMeshedFloorPanel();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon() {
        return FutureModule.metalMeshBlock.getIcon(0, 0);
    }

    public void renderInventoryItem(IItemRenderer.ItemRenderType type, ItemStack itemStack, Object... data) {
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        GL11.glScaled(1f, 1f, 1f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.MESHED_FLOOR_PANEL_TEXTURE);
        Assets.MESHED_FLOOR_PANEL_MODEL.renderAll();
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return new Cube(0, 0, 0, 1, 3, 1).add(x(), y(), z()).toAABB();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderDynamic(Pos pos, float frame, int pass) {
        //Render Meshed Floor Panel
        GL11.glPushMatrix();
        GL11.glTranslatef(pos.xf() + 0.5f, pos.yf() + 0.5f, pos.zf() + 0.5f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.MESHED_FLOOR_PANEL_TEXTURE);
        Assets.MESHED_FLOOR_PANEL_MODEL.renderAll();
        GL11.glPopMatrix();
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {

    }

}
