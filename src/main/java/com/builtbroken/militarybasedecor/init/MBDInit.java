package com.builtbroken.militarybasedecor.init;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.util.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class MBDInit {

    public static final List<Item> ITEMS = new ArrayList<Item>();
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    // BLOCKS
    public static final Block BLOCK_REINFORCED_DIRT = new BlockBase("reinforced_dirt", Material.GROUND, MapColor.DIRT, SoundType.GROUND);

    // ITEMS

}