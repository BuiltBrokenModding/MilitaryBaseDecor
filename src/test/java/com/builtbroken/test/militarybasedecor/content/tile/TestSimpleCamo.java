package com.builtbroken.test.militarybasedecor.content.tile;

import com.builtbroken.mc.testing.junit.AbstractTest;
import com.builtbroken.mc.testing.junit.VoltzTestRunner;
import com.builtbroken.mc.testing.junit.world.FakeWorld;
import com.builtbroken.mc.testing.tile.AbstractTileTest;
import com.builtbroken.militarybasedecor.modules.vanilla.content.block.camo.TileSimpleCamo;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * Junit test for {@link TileSimpleCamo}. Tests blockplacement, and block mimic functionality.
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry) on 10/22/2015.
 *
 */
@RunWith(VoltzTestRunner.class)
public class TestSimpleCamo extends AbstractTest {

    // Init tile to avoid NPE error on coderun.
    TileSimpleCamo tileCamo = new TileSimpleCamo("basic_camo", Material.rock);

    // Test tile placement
    @Test
    public void testSimpleCamoPlacement()
    {
        FakeWorld world = FakeWorld.newWorld("testSimpleCamoPlacement");
        world.setTileEntity(0, 10, 0, tileCamo);
    }

     // Test mimicblock functionality of SimpleCamo
    @Test
    public void testSimpleCamoMimic()
    {
        FakeWorld world = FakeWorld.newWorld("testSimpleCamoMimic");
        world.setTileEntity(0, 10, 0, tileCamo);
        // Set mimicblock to dirt to make sure it works
        tileCamo.stack = new ItemStack(Blocks.dirt);

        String s = tileCamo.toString();
    }

}
