package com.builtbroken.militarybasedecor.client;

import com.builtbroken.militarybasedecor.core.CommonProxy;
import com.builtbroken.militarybasedecor.modules.worldwar1.content.render.RenderBasicMixer;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Created by robert on 12/7/2014.
 */
public class ClientProxy extends CommonProxy
{

    @Override
    public void init()
    {
        RenderingRegistry.registerBlockHandler(new RenderBasicMixer());
    }

}
