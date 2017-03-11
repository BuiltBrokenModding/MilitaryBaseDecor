package com.builtbroken.militarybasedecor.modules.future;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.mc.lib.mod.loadable.ILoadable;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.future.block.ItemBlockFuture;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blog/development/license.md"></a> for what you can and can't do with the code.
 * Created by Hennamann(Henry) on 16/01/2017.
 */
public class FutureModule extends AbstractLoadable implements ILoadable {


    public static Block ultraHighPerformanceConcrete;

    @Override
    public void preInit()
    {
        ultraHighPerformanceConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock("ultra_high_performance_concrete", new BlockColored(Material.rock).setBlockName("ultra_high_performance_concrete").setBlockTextureName(MilitaryBaseDecor.PREFIX + "concrete/concrete_ultra_high_performance/concrete_ultra_high_performance").setCreativeTab(MilitaryBaseDecor.MAIN_TAB), ItemBlockFuture.class);
    }

    @Override
    public void init()
    {

    }

    @Override
    public void postInit()
    {

    }
}
