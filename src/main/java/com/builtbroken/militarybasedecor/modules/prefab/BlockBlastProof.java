package com.builtbroken.militarybasedecor.modules.prefab;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by Ole on 13.01.2016.
 */
public class BlockBlastProof extends Block {

    public BlockBlastProof() {
        super(Material.glass); // Glass can't burn unlike most other materials except air.
        this.setHardness(50f);
        this.setResistance(6000000.0F);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_2);
    }

    @Override
    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {return false;}

    @Override
    public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {;}

    @Override
    public boolean canDropFromExplosion(Explosion p_149659_1_) {return false;}

}
