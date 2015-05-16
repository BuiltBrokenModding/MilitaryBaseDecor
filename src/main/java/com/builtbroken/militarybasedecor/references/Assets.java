package com.builtbroken.militarybasedecor.references;

import com.builtbroken.mc.lib.render.model.loader.EngineModelLoader;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class Assets {
	
	    //Models
	    public static final IModelCustom PANE_BARBS_MODEL = model("Pane_Barbs.tcn");
		public static final IModelCustom MESHED_FLOOR_PANEL_MODEL = model("Meshed_Floor_Panel.tcn");

	    //Textures
	    public static final ResourceLocation PANE_BARBS_TEXTURE = texture("Pane_Barbs");
		public static final ResourceLocation MESHED_FLOOR_PANEL_TEXTURE = texture("Meshed_Floor_Panel");


	    public static IModelCustom model(String name)
	    {
	        return EngineModelLoader.loadModel(new ResourceLocation(MilitaryBaseDecor.DOMAIN, MilitaryBaseDecor.MODEL_PREFIX + name));
	    }

	    public static ResourceLocation texture(String name)
	    {
	        return new ResourceLocation(MilitaryBaseDecor.DOMAIN, "textures/models/" + name + ".png");
	    }
	}