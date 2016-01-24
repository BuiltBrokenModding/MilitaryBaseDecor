package com.builtbroken.militarybasedecor.worldwar1.content.block;

import com.builtbroken.mc.api.items.ISimpleItemRenderer;
import com.builtbroken.mc.api.tile.IRotation;
import com.builtbroken.mc.lib.transform.region.Cube;
import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.prefab.tile.Tile;
import com.builtbroken.mc.prefab.tile.TileEnt;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.references.Assets;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class TilePaneBarbs extends TileEnt implements ISimpleItemRenderer, IRotation {
    protected ForgeDirection facing;

    public TilePaneBarbs() {
        super("pane_barbs", Material.iron);
        this.creativeTab = (MilitaryBaseDecor.CREATIVE_TAB_1);
        this.isOpaque = false;
        this.renderNormalBlock = false;
        this.renderTileEntity = true;
        this.itemBlock = ItemBlockWorldWar1.class;
        this.bounds = new Cube(0F, 0F, 0F, 1F, 0.35F, 1F);
        this.facing = ForgeDirection.NORTH;
    }

    public void onPlaced(EntityLivingBase entityLiving, ItemStack itemStack) {
        super.onPlaced(entityLiving, itemStack);
        this.facing = this.determineForgeDirection(entityLiving);
    }

    public ForgeDirection getDirection() {
        if(this.facing == null) {
            this.facing = ForgeDirection.NORTH;
        }
        return this.facing;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        if(nbt.hasKey("facing")) {
            this.facing = ForgeDirection.getOrientation(nbt.getByte("facing"));
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        if(this.facing != null && this.facing != ForgeDirection.NORTH) {
            nbt.setByte("facing", (byte)this.facing.ordinal());
        }
    }

    public void readDescPacket(ByteBuf buf) {
        this.facing = ForgeDirection.getOrientation(buf.readByte());
    }

    public void writeDescPacket(ByteBuf buf) {
        buf.writeByte(this.facing != null?this.facing.ordinal():2);
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