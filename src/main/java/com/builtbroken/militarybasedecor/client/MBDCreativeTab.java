package com.builtbroken.militarybasedecor.client;

import com.builtbroken.mc.framework.mod.ModCreativeTab;
import com.builtbroken.militarybasedecor.core.ConfigManager;
import com.builtbroken.militarybasedecor.modules.blastcraft.Blastcraft;
import com.builtbroken.militarybasedecor.modules.coldwar.ColdWarModule;
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
            add(list, "militarybasedecor:wood_casing");
            add(list, "militarybasedecor:reinforced_dirt");
            add(list, "militarybasedecor:reinforced_sand");
            add(list, "militarybasedecor:metal_casing");
            add(list, "militarybasedecor:reinforced_cobblestone");
            add(list, "militarybasedecor:reinforced_stone");
            add(list, "militarybasedecor:reinforced_stonebrick");
            add(list, "militarybasedecor:reinforced_iron");
            add(list, "militarybasedecor:reinforced_gold");
            add(list, "militarybasedecor:reinforced_glass_normal");
            add(list, VanillaModule.reinforcedGlass);
            add(list, VanillaModule.reinforcedButton);
            add(list, VanillaModule.simpleCamoBlock);
            add(list, "militarybasedecor:pervious_concrete");
            add(list, "militarybasedecor:glass_concrete");
        }
        // Gunpowder Era Module Blocks
        if (ConfigManager.GUNPOWDER_ERA_ENABLED) {
            add(list, "militarybasedecor:limecrete");
            add(list, GunpowderModule.picketFence);
            add(list, GunpowderModule.tangledRope);
            add(list, GunpowderModule.ropeFence);
        }
        // WW1 Module Blocks
        if (ConfigManager.WORLD_WAR_ONE_ENABLED) {
            add(list, WorldWar1Module.bag);
            add(list, WorldWar1Module.bagCement);
            add(list, "militarybasedecor:bundled_wire");
            add(list, WorldWar1Module.liquidConcreteBucket);
            add(list, WorldWar1Module.basicMixerItem);
            add(list, WorldWar1Module.basicConcrete);
            add(list, WorldWar1Module.blockWireFence);
            add(list, WorldWar1Module.blockFenceTopper);
            add(list, WorldWar1Module.itemWireCutters);
            add(list, "militarybasedecor:sand_bag");
            add(list, "militarybasedecor:camouflage_block_woodlands");
            add(list, "militarybasedecor:camouflage_block_desert");
            add(list, "militarybasedecor:camouflage_block_urban");
        }
        // WW2 Module Blocks
        if (ConfigManager.WORLD_WAR_TWO_ENABLED) {
            add(list, WorldWar2Module.rebar);
            add(list, WorldWar2Module.rebarMesh);
            add(list, WorldWar2Module.reinforcedConcrete);
            add(list, WorldWar2Module.oliveDrabTexturedBlock);
            add(list, WorldWar2Module.corrugatedGalvanisedIronBlock);
            add(list, WorldWar2Module.ammunitionBox);
            add(list, WorldWar2Module.equipmentCrate);
            add(list, WorldWar2Module.dragonsTeeth);
        }
        // Cold War Module Blocks
        if (ConfigManager.COLD_WAR_ENABLED) {
            add(list, ColdWarModule.bituminousCoal);
            add(list, ColdWarModule.bituminousCoalBucket);
            add(list, ColdWarModule.liquidBitumenBucket);
            add(list, ColdWarModule.asphalt);
            if (ConfigManager.ICBM_CONCRETE_ENABLED) {
                add(list, ColdWarModule.icbmConcrete);
            }
            add(list, ColdWarModule.reinforcedDoorItem);
            add(list, ColdWarModule.highStrengthConcrete);
            add(list, ColdWarModule.reinforcedRail);
        }
        // Blastcraft Blocks
        if (ConfigManager.BLASTCRAFT_ENABLED) {
            add(list, Blastcraft.blastCompressor);
            add(list, Blastcraft.hardenedBrick);
            add(list, Blastcraft.rawBlastProofWalling);
            add(list, Blastcraft.blastProofWalling);
            add(list, Blastcraft.blastProofGlassNormal);
            add(list, Blastcraft.blastProofGlassSeamless);
            add(list, Blastcraft.blastProofTrapDoor);
            add(list, Blastcraft.carbonPlatedWalling);
        }

    }

}
