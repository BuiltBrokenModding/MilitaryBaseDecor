package com.builtbroken.militarybasedecor.modules.worldwar2.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.worldwar2.WorldWar2Module;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blog/development/license.md"></a> for what you can and can't do with the code.
 * Created by Hennamann(Henry) on 17/01/2017.
 */
public class BlockLiquidReinforcedConcrete extends Block {

    public BlockLiquidReinforcedConcrete() {
        super(Material.rock);
        this.setBlockName("liquid_reinforced_concrete");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "concrete/concrete_reinforced/concrete_reinforced_liquid_rebar");
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        world.setBlock(x, y, z, WorldWar2Module.reinforcedConcrete);
    }
}
