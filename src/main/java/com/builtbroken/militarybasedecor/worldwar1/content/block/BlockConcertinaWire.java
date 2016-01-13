package com.builtbroken.militarybasedecor.worldwar1.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockConcertinaWire extends Block {

    public PlayerCapabilities capabilities = new PlayerCapabilities();

    public BlockConcertinaWire() {
        super(Material.iron);
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
        this.setBlockName("concertina_wire");
        this.setBlockTextureName(MilitaryBaseDecor.DOMAIN + ":" + "concertina_wire");
    }

    // TODO make it 100% creative mode, not just flying...
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity) {
        if (!this.capabilities.isCreativeMode && !this.capabilities.isFlying) {
            entity.setInWeb();
            entity.attackEntityFrom(DamageSource.cactus, 1.0F);
        }
        if (this.capabilities.isCreativeMode && this.capabilities.isFlying) {

        }
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
        return null;
    }

    public int getRenderType() {
        return 1;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }
}