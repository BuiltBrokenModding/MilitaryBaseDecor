package com.builtbroken.militarybasedecor.content.init;

import com.builtbroken.militarybasedecor.content.block.*;
import com.builtbroken.militarybasedecor.content.block.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;

import java.util.ArrayList;
import java.util.List;

public class MBDInit {

    public static final List<Item> ITEMS = new ArrayList<Item>();
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final DamageSource DAMAGE_WIRED_FENCE = (new DamageSource("wiredFence"));

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

    public static final Block BLOCK_ROPE_FENCE = new BlockPaneFence("rope_fence", Material.WOOD, true, SoundType.WOOD);
    public static final Block BLOCK_WIRED_FENCE = new BlockPaneFence("wired_fence", Material.IRON, true, SoundType.METAL);
    public static final Block BLOCK_CHAIN_LINK_FENCE = new BlockPaneFence("chain_link_fence", Material.IRON, true, SoundType.METAL);
    public static final Block BLOCK_BARBED_WIRE_FENCE = new BlockDamagingPaneFence("barbed_wire_fence", Material.IRON, true, SoundType.METAL);
    public static final Block BLOCK_BARBED_WIRE_FENCE_BLOODY = new BlockDamagingPaneFence("barbed_wire_fence_bloody", Material.IRON, true, SoundType.METAL);

    public static final Block BLOCK_FENCE_TOPPER = new BlockFenceTopper("fence_topper", Material.IRON, MapColor.IRON, SoundType.METAL, 1.5f);
    public static final Block BLOCK_FENCE_TOPPER_CORNER = new BlockFenceTopperCorner("fence_topper_corner", Material.IRON, MapColor.IRON, SoundType.METAL, 1.5f);
    public static final Block BLOCK_FENCE_TOPPER_BLOODY = new BlockFenceTopper("fence_topper_bloody", Material.IRON, MapColor.IRON, SoundType.METAL, 1.5f);
    public static final Block BLOCK_FENCE_TOPPER_CORNER_BLOODY = new BlockFenceTopperCorner("fence_topper_corner_bloody", Material.IRON, MapColor.IRON, SoundType.METAL, 1.5f);
    public static final Block BLOCK_FENCE_TOPPER_BARBED = new BlockFenceTopper("fence_topper_barbed", Material.IRON, MapColor.IRON, SoundType.METAL, 2f);
    public static final Block BLOCK_FENCE_TOPPER_BARBED_BLOODY = new BlockFenceTopper("fence_topper_barbed_bloody", Material.IRON, MapColor.IRON, SoundType.METAL, 2f);

    public static final Block BLOCK_WOODEN_BARRICADE = new BlockBarricade("wooden_barricade", Material.WOOD, MapColor.WOOD, SoundType.WOOD);
    public static final Block BLOCK_WOODEN_BARRICADE_2 = new BlockBarricade("wooden_barricade_2", Material.WOOD, MapColor.WOOD, SoundType.WOOD);
    public static final Block BLOCK_STRENGTHENED_WOODEN_BARRICADE = new BlockBarricade("strengthened_wooden_barricade", Material.WOOD, MapColor.WOOD, SoundType.WOOD);
    public static final Block BLOCK_STRENGTHENED_WOODEN_BARRICADE_2 = new BlockBarricade("strengthened_wooden_barricade_2", Material.WOOD, MapColor.WOOD, SoundType.WOOD);

    public static final Block BLOCK_EQUIPMENT_CRATE = new BlockEquipmentCrate("equipment_crate", Material.IRON, MapColor.BLACK, SoundType.METAL);

    public static final Block BLOCK_CONCERTINA_WIRE = new BlockDamaging("concertina_wire", Material.IRON, MapColor.AIR, SoundType.METAL, 1.5f);
    public static final Block BLOCK_CONCERTINA_WIRE_2 = new BlockConcertinaWire("concertina_wire_2", Material.IRON, MapColor.IRON, SoundType.METAL, 2.0f);
    public static final Block BLOCK_CONCERTINA_WIRE_2_BLOODY = new BlockConcertinaWire("concertina_wire_2_bloody", Material.IRON, MapColor.IRON, SoundType.METAL, 2.0f);

    // Storage Blocks
    public static final Block BLOCK_AMMO_CRATE = new BlockAmmoCrate();
    public static final Block BLOCK_AMMUNITION_BOX = new BlockAmmunitionBox();

}