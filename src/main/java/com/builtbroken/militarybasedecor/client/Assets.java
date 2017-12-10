package com.builtbroken.militarybasedecor.client;

import com.builtbroken.mc.lib.render.model.loader.EngineModelLoader;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;

@SideOnly(Side.CLIENT)
public final class Assets
{
    //Models
    public static final IModelCustom PANE_BARBS_MODEL = model("Pane_Barbs.tcn");
    public static final WavefrontObject DRAGONS_TEETH = (WavefrontObject) model("dragons_teeth.obj");

    //Textures
    public static final ResourceLocation PANE_BARBS_TEXTURE = texture("pane_barbs");
    public static final ResourceLocation DRAGONS_TEETH_TEXTURE = texture("dragons_teeth");

    public static IModelCustom model(String name)
    {
        return EngineModelLoader.loadModel(new ResourceLocation(MilitaryBaseDecor.DOMAIN, MilitaryBaseDecor.MODEL_PATH + name));
    }

    public static ResourceLocation texture(String name)
    {
        return new ResourceLocation(MilitaryBaseDecor.DOMAIN, "textures/models/" + name + ".png");
    }
}