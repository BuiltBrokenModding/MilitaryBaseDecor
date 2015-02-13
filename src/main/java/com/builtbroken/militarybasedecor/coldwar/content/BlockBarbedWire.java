package com.builtbroken.militarybasedecor.coldwar.content;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * Created by Ole on 23.01.2015.
 */

// TODO fix crashes on block placement!
public class BlockBarbedWire extends BlockPane {

    public BlockBarbedWire()
    {
        super("militarybasedecor:barbedWire", "militarybasedecor:barbedWire", Material.iron, true);
        this.setBlockName("barbedWire");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "barbedWire");
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
        this.setHardness(5.0F);
        this.setResistance(20.0F);
        this.setStepSound(soundTypeMetal);
    }
    public void onEntityCollidedWithBlock(World world, int player, int player2, int player3, Entity entity)
    {
        entity.attackEntityFrom(DamageSource.cactus, 1.0F);
        entity.setInWeb();
    }
}

