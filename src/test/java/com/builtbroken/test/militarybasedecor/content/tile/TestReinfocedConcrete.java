package com.builtbroken.test.militarybasedecor.content.tile;

import com.builtbroken.mc.testing.junit.AbstractTest;
import com.builtbroken.mc.testing.junit.VoltzTestRunner;
import com.builtbroken.mc.testing.junit.world.FakeWorld;
import com.builtbroken.militarybasedecor.modules.worldwar2.content.block.BlockLiquidReinforcedConcrete;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * Junit test for {@link BlockLiquidReinforcedConcrete}. Tests blockplacement, and reinforced concrete creation using blockupdates and ticks.
 *
 * @see <a href="https://github.com/BuilBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry Stabell) on 22.02.2017 for MilitaryBaseDecor.
 */
@RunWith(VoltzTestRunner.class)
public class TestReinfocedConcrete extends AbstractTest
{

    BlockLiquidReinforcedConcrete blockConcrete = new BlockLiquidReinforcedConcrete();

    @Test
    public void testLiquidReinforcedConcretePlacement()
    {
        FakeWorld world = FakeWorld.newWorld("testLiquidReinforcedPlacement");
        world.setBlock(0, 10, 0, blockConcrete);
    }

    @Test
    public void testReinforcedConcreteSolidifiying()
    {
        FakeWorld world = FakeWorld.newWorld("testReinforcedConcreteSolidifying");
        world.setBlock(0, 10, 0, blockConcrete);
        world.scheduleBlockUpdate(0, 10, 0, blockConcrete, 0);

        String s = blockConcrete.toString();
    }
}
