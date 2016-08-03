package com.builtbroken.militarybasedecor.modules.coldwar.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/5/2016.
 */
public class BlockICBMConcrete extends Block
{
    protected BlockICBMConcrete()
    {
        super(Material.rock);
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "icbmConcrete");
        this.setBlockName(MilitaryBaseDecor.PREFIX + "icbmConcrete");
    }
}
