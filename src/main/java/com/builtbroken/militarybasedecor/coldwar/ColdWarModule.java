package com.builtbroken.militarybasedecor.coldwar;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.mc.lib.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.coldwar.content.BlockAsphalt;
import com.builtbroken.militarybasedecor.vanilla.content.BlockConcrete;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/** Content themed after cold ware military bunkers and bases
 * Created by robert on 12/7/2014.
 */
public class ColdWarModule extends AbstractLoadable
{
    public static Block asphalt;

    @Override
    public void preInit()
    {
        asphalt = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAsphalt.class);
    }
}
