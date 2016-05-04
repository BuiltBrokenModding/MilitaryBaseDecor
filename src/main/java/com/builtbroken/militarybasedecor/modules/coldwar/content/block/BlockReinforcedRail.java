package com.builtbroken.militarybasedecor.modules.coldwar.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import net.minecraft.block.BlockRail;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.world.World;

/**
 * @author DarkGuardsman
 */
public class BlockReinforcedRail extends BlockRail
{
    public BlockReinforcedRail()
    {
        super();
        this.setBlockName("reinforced_rail");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "reinforced_rail");
        this.setHardness(10F);
        this.setResistance(10F);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1);
    }

    @Override
    public float getRailMaxSpeed(World world, EntityMinecart cart, int y, int x, int z)
    {
        return 0.6f;
    }
}
