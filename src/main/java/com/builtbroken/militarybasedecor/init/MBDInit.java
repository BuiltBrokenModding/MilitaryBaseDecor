package com.builtbroken.militarybasedecor.init;

import com.builtbroken.militarybasedecor.block.*;
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
    public static final Block BLOCK_WOODEN_CASING = new BlockTransparent("wooden_casing", Material.WOOD, MapColor.WOOD, SoundType.WOOD);
    public static final Block BLOCK_METAL_CASING = new BlockTransparent("metal_casing", Material.IRON, MapColor.IRON, SoundType.METAL);

    public static final Block BLOCK_REINFORCED_DIRT = new BlockBase("reinforced_dirt", Material.WOOD, MapColor.DIRT, SoundType.WOOD);
    public static final Block BLOCK_REINFORCED_SAND = new BlockBase("reinforced_sand", Material.WOOD, MapColor.SAND, SoundType.WOOD);
    public static final Block BLOCK_REINFORCED_COBBLESTONE = new BlockBase("reinforced_cobblestone", Material.IRON, MapColor.STONE, SoundType.METAL);
    public static final Block BLOCK_REINFORCED_STONE = new BlockBase("reinforced_stone", Material.WOOD, MapColor.STONE, SoundType.METAL);
    public static final Block BLOCK_REINFORCED_BRICKS = new BlockBase("reinforced_bricks", Material.WOOD, MapColor.STONE, SoundType.METAL);
    public static final Block BLOCK_REINFORCED_IRON = new BlockBase("reinforced_iron", Material.IRON, MapColor.IRON, SoundType.METAL);
    public static final Block BLOCK_REINFORCED_GOLD = new BlockBase("reinforced_gold", Material.IRON, MapColor.GOLD, SoundType.METAL);
    public static final Block BLOCK_REINFORCED_BUTTON = new BlockReinforcedButton("reinforced_button");
    public static final Block BLOCK_REINFORCED_GLASS = new BlockTransparent("reinforced_glass", Material.GLASS, MapColor.AIR, SoundType.GLASS);

    public static final Block BLOCK_WIRED_FENCE = new BlockWireFence("wired_fence", Material.IRON, true, SoundType.METAL);
    public static final Block BLOCK_CHAIN_LINK_FENCE = new BlockWireFence("chain_link_fence", Material.IRON, true, SoundType.METAL);
    public static final Block BLOCK_BARBED_WIRE_FENCE = new BlockDamagingWireFence("barbed_wire_fence", Material.IRON, true, SoundType.METAL);
    public static final Block BLOCK_BARBED_WIRE_FENCE_BLOODY = new BlockDamagingWireFence("barbed_wire_fence_bloody", Material.IRON, true, SoundType.METAL);

    public static final Block BLOCK_FENCE_TOPPER = new BlockFenceTopper("fence_topper", Material.IRON, MapColor.IRON, SoundType.METAL);

    // ITEMS

}