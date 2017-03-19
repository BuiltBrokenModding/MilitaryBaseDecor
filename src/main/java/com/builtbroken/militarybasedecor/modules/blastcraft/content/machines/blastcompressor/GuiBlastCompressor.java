package com.builtbroken.militarybasedecor.modules.blastcraft.content.machines.blastcompressor;

import com.builtbroken.mc.prefab.gui.GuiContainerBase;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * @see <a href="https://github.com/BuilBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry Stabell) on 18.03.2017 for MilitaryBaseDecor.
 */
public class GuiBlastCompressor extends GuiContainerBase
{
    private static final ResourceLocation texture = new ResourceLocation(MilitaryBaseDecor.DOMAIN, "textures/gui/blast_compressor.png");
    private TileBlastCompressor tileBlastCompressor;

    public GuiBlastCompressor(EntityPlayer player, TileBlastCompressor blastCompressor)
    {
        super(new ContainerBlastCompressor(player, blastCompressor));
        this.tileBlastCompressor = blastCompressor;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        String s = this.tileBlastCompressor.hasCustomInventoryName() ? this.tileBlastCompressor.getInventoryName() : I18n.format(this.tileBlastCompressor.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        if (this.tileBlastCompressor.burnTime > 0)
        {
            int i1 = getBurnTimeRemainingScaled(13);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
            i1 = getCookProgressScaled(24);
            this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
        }
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled(int value)
    {
        return this.tileBlastCompressor.processingTicks * value / 200;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    public int getBurnTimeRemainingScaled(int value)
    {
        if (tileBlastCompressor.burnTimeItem == 0)
        {
            tileBlastCompressor.burnTimeItem = 200;
        }

        return tileBlastCompressor.burnTime * value / tileBlastCompressor.burnTimeItem;
    }
}
