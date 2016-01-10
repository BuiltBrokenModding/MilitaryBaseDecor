package com.builtbroken.militarybasedecor.worldwar1.content.block;

import com.builtbroken.mc.api.items.ISimpleItemRenderer;
import com.builtbroken.mc.lib.transform.region.Cube;
import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.prefab.tile.Tile;
import com.builtbroken.mc.prefab.tile.TileMachine;
import com.builtbroken.militarybasedecor.references.Assets;
import com.builtbroken.militarybasedecor.vanilla.content.block.ItemBlockVanilla;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class TilePaneBarbs extends TileMachine implements ISimpleItemRenderer {

    public TilePaneBarbs() {
        super("pane_barbs", Material.iron);
        this.isOpaque = false;
        this.renderNormalBlock = false;
        this.renderTileEntity = true;
        this.itemBlock = ItemBlockWorldWar1.class;
        this.bounds = new Cube(0F, 0F, 0F, 1F, 0.35F, 1F);
    }

    @Override
    public void onCollide(Entity entity) {
        entity.setInWeb();
        entity.attackEntityFrom(DamageSource.cactus, 1.0F);
    }

    @Override
    public Tile newTile() {
        return new TilePaneBarbs();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon() {
        return Blocks.iron_block.getIcon(0, 0);
    }

    @Override
    public void renderInventoryItem(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, Object... objects) {
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        GL11.glScaled(.8f, .8f, .8f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.PANE_BARBS_TEXTURE);
        Assets.PANE_BARBS_MODEL.renderAll();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderDynamic(Pos pos, float frame, int pass) {
        //Render Pane Barbs
        GL11.glPushMatrix();
        GL11.glTranslatef(pos.xf() + 0.5f, pos.yf() + 0.5f, pos.zf() + 0.5f);
        switch (facing) {
            case EAST:
                break;
            case WEST:
                GL11.glRotatef(180f, 0, 1f, 0);
                break;
            case SOUTH:
                GL11.glRotatef(-90f, 0, 1f, 0);
                break;
            default:
                GL11.glRotatef(90f, 0, 1f, 0);
                break;
        }
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.PANE_BARBS_TEXTURE);
        Assets.PANE_BARBS_MODEL.renderAll();
        GL11.glPopMatrix();
    }
}