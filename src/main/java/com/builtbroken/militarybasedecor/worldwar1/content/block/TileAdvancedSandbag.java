package com.builtbroken.militarybasedecor.worldwar1.content.block;

import com.builtbroken.mc.api.items.ISimpleItemRenderer;
import com.builtbroken.mc.lib.transform.region.Cube;
import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.prefab.tile.Tile;
import com.builtbroken.militarybasedecor.references.Assets;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Ole on 5/17/2015.
 */
public class TileAdvancedSandbag extends Tile implements ISimpleItemRenderer {

    public TileAdvancedSandbag() {
        super("advanced_sandbag", Material.cloth);
        this.isOpaque = false;
        this.renderNormalBlock = false;
        this.renderTileEntity = true;
        this.itemBlock = ItemBlockWorldWar1.class;
    }

    @Override
    public Tile newTile() {
        return new TileAdvancedSandbag();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon() {
        return VanillaModule.sandBag.getIcon(0, 0);
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return new Cube(0, 0, 0, 1, 3, 1).add(x(), y(), z()).toAABB();
    }

    @Override
    public void renderInventoryItem(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, Object... objects) {
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glScaled(.8f, .8f, .8f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.ADVANCED_SANDBAG_TEXTURE);
        Assets.ADVANCED_SANDBAG_MODEL.renderAll();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderDynamic(Pos pos, float frame, int pass) {
        //Render Advanced Sandbag
        GL11.glPushMatrix();
        GL11.glTranslatef(pos.xf() + 0.5f, pos.yf() + 0.5f, pos.zf() + 0.5f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.ADVANCED_SANDBAG_TEXTURE);
        Assets.ADVANCED_SANDBAG_MODEL.renderAll();
        GL11.glPopMatrix();
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {

    }
}