package com.builtbroken.militarybasedecor.client;

import com.builtbroken.mc.lib.mod.ModCreativeTab;
import com.builtbroken.militarybasedecor.core.ConfigManager;
import com.builtbroken.militarybasedecor.modules.blastcraft.Blastcraft;
import com.builtbroken.militarybasedecor.modules.coldwar.ColdWarModule;
import com.builtbroken.militarybasedecor.modules.future.FutureModule;
import com.builtbroken.militarybasedecor.modules.gunpowder.GunpowderModule;
import com.builtbroken.militarybasedecor.modules.vanilla.VanillaModule;
import com.builtbroken.militarybasedecor.modules.worldwar1.WorldWar1Module;
import com.builtbroken.militarybasedecor.modules.worldwar2.WorldWar2Module;

import java.util.List;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blog/development/license.md"></a> for what you can and can't do with the code.
 * Created by Hennamann(Henry) on 16/01/2017.
 */
public class MBDCreativeTab extends ModCreativeTab {

    public MBDCreativeTab()
    {
        super("MilitaryBaseDecor");
    }

    @Override
    public void displayAllReleventItems(List list)
    {
        // Vanilla Module Blocks
        if (ConfigManager.VANILLA_ENABLED) {
            add(list, VanillaModule.reinforcedWoodenCasing);
            add(list, VanillaModule.reinforcedSoil);
            add(list, VanillaModule.reinforcedMetalCasing);
            add(list, VanillaModule.reinforcedStone);
            add(list, VanillaModule.reinforcedMetal);
            add(list, VanillaModule.reinforcedGlass);
            add(list, VanillaModule.reinforcedButton);
            add(list, VanillaModule.simpleCamoBlock);
        }

        if (ConfigManager.GUNPOWDER_ERA_ENABLED) {
            add(list, GunpowderModule.limecrete);
            add(list, GunpowderModule.picketFence);
            add(list, GunpowderModule.rope);
            add(list, GunpowderModule.tangledRope);
            add(list, GunpowderModule.ropeFence);
        }

        if (ConfigManager.WORLD_WAR_ONE_ENABLED) {
            add(list, WorldWar1Module.bag);
            add(list, WorldWar1Module.bagCement);
            add(list, WorldWar1Module.liquidConcreteBucket);
            add(list, WorldWar1Module.basicMixerItem);
            add(list, WorldWar1Module.basicConcrete);
            add(list, WorldWar1Module.blockWireFence);
            add(list, WorldWar1Module.blockFenceTopper);
            add(list, WorldWar1Module.itemWireCutters);
            add(list, WorldWar1Module.sandBag);
            add(list, WorldWar1Module.camouflageBlock);
        }

        if (ConfigManager.WORLD_WAR_TWO_ENABLED) {
            add(list, WorldWar2Module.rebar);
            add(list, WorldWar2Module.rebarMesh);
            add(list, WorldWar2Module.reinforcedConcrete);
            add(list, WorldWar2Module.oliveDrabTexturedBlock);
            add(list, WorldWar2Module.corrugatedGalvanisedIronBlock);
            add(list, WorldWar2Module.ammunitionBox);
            add(list, WorldWar2Module.equipmentCrate);
        }

        if (ConfigManager.COLD_WAR_ENABLED) {
            add(list, ColdWarModule.bituminousCoal);
            add(list, ColdWarModule.bituminousCoalBucket);
            add(list, ColdWarModule.liquidBitumenBucket);
            add(list, ColdWarModule.asphalt);
            add(list, ColdWarModule.icbmConcrete);
            add(list, ColdWarModule.highStrengthConcrete);
            add(list, ColdWarModule.reinforcedRail);
        }

        if (ConfigManager.FUTURE_ENABLED) {
            add(list, FutureModule.ultraHighPerformanceConcrete);
        }

        if (ConfigManager.BLASTCRAFT_ENABLED) {
            add(list, Blastcraft.hardenedBrick);
            add(list, Blastcraft.rawBlastProofWalling);
            add(list, Blastcraft.blastProofWalling);
            add(list, Blastcraft.blastProofGlass);
            add(list, Blastcraft.blastProofTrapDoor);
            add(list, Blastcraft.carbonPlatedWalling);
        }

    }

}
