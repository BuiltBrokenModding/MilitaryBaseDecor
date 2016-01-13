package com.builtbroken.militarybasedecor.coldwar;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.coldwar.content.block.BlockAsphalt;
import com.builtbroken.militarybasedecor.coldwar.content.block.BlockReinforcedRail;
import com.builtbroken.militarybasedecor.coldwar.content.block.ItemBlockColdWar;
import com.builtbroken.militarybasedecor.vanilla.VanillaModule;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Content themed after cold ware military bunkers and bases
 * Created by robert on 12/7/2014.
 */
public class ColdWarModule extends AbstractLoadable {
    public static Block asphalt;
    public static Block reinforcedRail;

    @Override
    public void preInit() {
        asphalt = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAsphalt.class, ItemBlockColdWar.class);
        reinforcedRail = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockReinforcedRail.class, ItemBlockColdWar.class);

        MilitaryBaseDecor.CREATIVE_TAB_1.itemStack = new ItemStack(asphalt);
    }

    @Override
    public void postInit() {

        }
    }
