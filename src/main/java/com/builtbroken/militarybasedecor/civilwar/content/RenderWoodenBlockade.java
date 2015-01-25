package com.builtbroken.militarybasedecor.civilwar.content;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT)
/**
 * Created by Ole on 25.01.2015.
 */
// TODO Finish this class
public class RenderWoodenBlockade extends Render implements IItemRenderer {

    public static final IModelCustom SMALL = AdvancedModelLoader.loadModel(new ResourceLocation(MilitaryBaseDecor.ID, MilitaryBaseDecor.MODEL_PREFIX + "blockade.tcn"));
    public static final ResourceLocation SMALL_TEXTURE = new ResourceLocation(MilitaryBaseDecor.ID, MilitaryBaseDecor.MODEL_TEXTURE_PATH + "blockade.png");

    public RenderWoodenBlockade(float f)
    {
        this.shadowSize = f;
    }


    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return this.shouldUseRenderHelper(type, item, null);
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        //TODO Add wooden blockade item class and reference it here!
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        //TODO Add wooden blockade item class and reference it here!
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float f, float f1)
    {

    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return null;
    }
}





