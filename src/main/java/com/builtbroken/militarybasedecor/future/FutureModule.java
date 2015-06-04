package com.builtbroken.militarybasedecor.future;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.future.content.block.TileGlassFloorPanel;
import com.builtbroken.militarybasedecor.future.content.block.TileMeshedFloorPanel;
import com.builtbroken.militarybasedecor.future.content.block.TileReinforcedGlassFloorPanel;
import net.minecraft.block.Block;

/**
 * A module set in the future, this module allows for a lot more imagination than the other modules.
 * Created by Ole on 4/27/2015.
 */
public class FutureModule extends AbstractLoadable {

    public static Block meshedFloorPanel;
    public static Block glassFloorPanel;
    public static Block reinforcedGlassPanel;

    @Override
    public void preInit() {

        meshedFloorPanel = MilitaryBaseDecor.INSTANCE.getManager().newBlock(TileMeshedFloorPanel.class);
        glassFloorPanel = MilitaryBaseDecor.INSTANCE.getManager().newBlock(TileGlassFloorPanel.class);
        reinforcedGlassPanel = MilitaryBaseDecor.INSTANCE.getManager().newBlock(TileReinforcedGlassFloorPanel.class);
    }

    @Override
    public void postInit() {

    }
}