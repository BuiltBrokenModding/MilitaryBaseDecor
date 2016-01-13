package com.builtbroken.militarybasedecor.worldwar1.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by Ole on 23.01.2015.
 */
public class BlockBarbedWireFence extends BlockPane {

    public PlayerCapabilities capabilities = new PlayerCapabilities();

    public BlockBarbedWireFence() {
        super("militarybasedecor:barbed_wire_fence", "militarybasedecor:wired_fence_top", Material.iron, true);
        this.setBlockName("barbed_wire_fence");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "barbed_wire_fence");
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
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

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity) {
        return true;
    }
}
