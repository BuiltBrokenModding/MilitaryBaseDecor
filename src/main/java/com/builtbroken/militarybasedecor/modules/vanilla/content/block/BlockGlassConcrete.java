package com.builtbroken.militarybasedecor.modules.vanilla.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blog/development/license.md"></a> for what you can and can't do with the code.
 * Created by Hennamann(Henry) on 17/01/2017.
 */
public class BlockGlassConcrete extends Block {

    public BlockGlassConcrete() {
        super(Material.rock);
        this.setBlockName("glass_concrete");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "concrete/concrete_glass");
        this.setResistance(5);
        this.setHardness(2);
        this.setStepSound(Block.soundTypeGlass);
    }
}
