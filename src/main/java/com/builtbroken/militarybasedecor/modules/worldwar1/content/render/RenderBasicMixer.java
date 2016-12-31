package com.builtbroken.militarybasedecor.modules.worldwar1.content.render;

import com.builtbroken.militarybasedecor.modules.worldwar1.content.block.BlockBasicMixer;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * Created by hennamann on 30.12.2016.
 */
public class RenderBasicMixer implements ISimpleBlockRenderingHandler {

    public static int id = RenderingRegistry.getNextAvailableRenderId();

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        if (modelId == id)
        {
            IIcon[] icon = {BlockBasicMixer.textures[0], BlockBasicMixer.textures[1], BlockBasicMixer.textures[2], BlockBasicMixer.textures[3]};
            double d = 0.0625D;
            float f = 1.0F;
            renderer.renderStandardBlock(block, x, y, z);
            Tessellator tes = Tessellator.instance;
            tes.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
            int color = block.colorMultiplier(world, x, y, z);
            float r = (float)(color >> 16 & 255) / 255.0F;
            float g = (float)(color >> 8 & 255) / 255.0F;
            float b = (float)(color & 255) / 255.0F;
            float f4;

            if (EntityRenderer.anaglyphEnable)
            {
                float f5 = (r * 30.0F + g * 59.0F + b * 11.0F) / 100.0F;
                f4 = (r * 30.0F + g * 70.0F) / 100.0F;
                float f6 = (r * 30.0F + b * 70.0F) / 100.0F;
                r = f5;
                g = f4;
                b = f6;
            }

            tes.setColorOpaque_F(f * r, f * g, f * b);
            f4 = 0.125F;
            renderer.renderFaceXPos(block, (double)((float)x - 1.0F + f4), (double)y, (double)z, icon[2]);
            renderer.renderFaceXNeg(block, (double)((float)x + 1.0F - f4), (double)y, (double)z, icon[2]);
            renderer.renderFaceZPos(block, (double)x, (double)y, (double)((float)z - 1.0F + f4), icon[2]);
            renderer.renderFaceZNeg(block, (double)x, (double)y, (double)((float)z + 1.0F - f4), icon[2]);
            renderer.renderFaceYPos(block, (double)x, (double)((float)y - 1.0F + 0.25F), (double)z, icon[1]);
            renderer.renderFaceYNeg(block, (double)x, (double)((float)y + 1.0F - 0.75F), (double)z, icon[1]);
            int liquid = world.getBlockMetadata(x, y, z);

            if (liquid > 0)
            {
                IIcon iicon = BlockBasicMixer.textures[4];
                renderer.renderFaceYPos(block, (double)x, (double)((float)y - 1.0F + BlockBasicMixer.getRenderLiquidLevel(liquid)), (double)z, iicon);
            }

            renderer.setRenderBounds(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        }
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelID)
    {
        return false;
    }

    @Override
    public int getRenderId()
    {
        return id;
    }
}
