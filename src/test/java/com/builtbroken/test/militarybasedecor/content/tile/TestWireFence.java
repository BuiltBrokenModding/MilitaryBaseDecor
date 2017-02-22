package com.builtbroken.test.militarybasedecor.content.tile;

import java.io.File;

import com.builtbroken.mc.testing.junit.AbstractTest;
import com.builtbroken.mc.testing.junit.VoltzTestRunner;
import com.builtbroken.mc.testing.junit.server.FakeDedicatedServer;
import com.builtbroken.mc.testing.junit.testers.TestPlayer;
import com.builtbroken.mc.testing.junit.world.FakeWorld;
import com.builtbroken.mc.testing.junit.world.FakeWorldServer;
import com.builtbroken.militarybasedecor.modules.worldwar1.WorldWar1Module;
import com.mojang.authlib.GameProfile;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.builtbroken.militarybasedecor.modules.worldwar1.content.block.BlockWireFence;

/**
 *
 * Junit test for {@link BlockWireFence}. Tests blockplacement, and item drop.
 *
 * @see <a href="https://github.com/BuilBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry Stabell) on 22.02.2017 for VoltzEngine.
 */
@RunWith(VoltzTestRunner.class)
public class TestWireFence extends AbstractTest {

    // Get a server world and a player to test item and block functionality with.
    protected MinecraftServer server;
    protected FakeWorldServer serverWorld;
    protected FakeWorld world;
    protected TestPlayer player;

    BlockWireFence blockWireFence = new BlockWireFence();


    @Override
    public void setUpForEntireClass()
    {
        super.setUpForEntireClass();
        server = new FakeDedicatedServer(new File(FakeWorldServer.baseFolder, blockWireFence.getUnlocalizedName()));
        serverWorld = FakeWorldServer.newWorld(server, blockWireFence.getUnlocalizedName());
        world = FakeWorld.newWorld("testWorld");
        player = new TestPlayer(server, serverWorld, new GameProfile(null, "WireTester"));
    }

    @Override
    public void setUpForTest(String name)
    {
        super.setUpForTest(name);
        player.reset();
        serverWorld.setBlock(0, 0, 0, blockWireFence);
    }

    @Test
    public void testWireFencePlacement()
    {
        world.setBlock(0, 10, 0, blockWireFence);
    }

    @Test
    public void testWireFenceItemCut() {
        ItemStack wireCutters = new ItemStack(WorldWar1Module.itemWireCutters);

        world.setBlock(0, 10, 0, blockWireFence);
        player.inventory.setInventorySlotContents(player.inventory.currentItem, wireCutters);

        // TODO Finish this so it uses the wire cutters on the actual wire fence block.
    }
}
