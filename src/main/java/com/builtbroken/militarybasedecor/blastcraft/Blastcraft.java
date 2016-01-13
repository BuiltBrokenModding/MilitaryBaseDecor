package com.builtbroken.militarybasedecor.blastcraft;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;

/**
 * Created by ole on 13/01/16.
 */
public class Blastcraft extends AbstractLoadable {

    @Override
    public void preInit() {

    }

    @Override
    public void postInit() {

        BlastcraftRecipes.initItemRecipes();
        BlastcraftRecipes.initBlockRecipes();
    }

}
