package com.builtbroken.test.militarybasedecor.content.crafting;

import com.builtbroken.mc.testing.junit.AbstractTest;
import com.builtbroken.mc.testing.junit.VoltzTestRunner;
import com.builtbroken.mc.testing.junit.world.FakeWorld;
import com.builtbroken.militarybasedecor.modules.worldwar1.content.block.BlockBasicMixer;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Junit Test for basic concrete crafting. Creates a basic mixer tile and crafts 1 basic concrete block.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry) on 10/22/2015.
 *
 */
@RunWith(VoltzTestRunner.class)
public class TestBasicMixerCrafting extends AbstractTest
{

    // Init block to avoid NPE error on coderun.
    BlockBasicMixer blockMixer = new BlockBasicMixer();

    // Test block placement
    @Test
    public void testBasicMixerPlacement()
    {
        FakeWorld world = FakeWorld.newWorld("testBasicMixerPlacement");
        world.setBlock(0, 10, 0, blockMixer);
    }

    // Test Basic Concrete recipe
    @Test
    public void testBasicConcreteCrafting()
    {
        FakeWorld world = FakeWorld.newWorld("testBasicConcreteCrafting");

        world.setBlock(0, 10, 0, blockMixer);
        // Fill the basic mixer with liquid concrete
        blockMixer.func_150024_a(world, 0, 10, 0, 3);
        // Manually set the stickcount to 5 to avoid using rightclick
        blockMixer.stickCount = 5;
        blockMixer.makeBasicConcrete(world, 0, 10, 0);
    }
}