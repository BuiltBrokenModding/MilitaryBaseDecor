package com.builtbroken.militarybasedecor.modules.vanilla.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockButtonStone;
import net.minecraft.entity.Entity;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by olehenrikstabell on 31/07/16.
 */
public class BlockReinforcedButton extends BlockButton {

    public BlockReinforcedButton() {
        super(false);

        this.setBlockName("reinforced_button");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "reinforced_concrete"); //Temp until we get a texture
        this.setCreativeTab(MilitaryBaseDecor.MAIN_TAB);
        this.setHardness(2.5F);
        this.setResistance(35);
        this.setStepSound(soundTypeStone);
    }

    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
        return false;
    }

    @Override
    public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {}

    @Override
    public boolean canDropFromExplosion(Explosion p_149659_1_) {
        return false;
    }
}