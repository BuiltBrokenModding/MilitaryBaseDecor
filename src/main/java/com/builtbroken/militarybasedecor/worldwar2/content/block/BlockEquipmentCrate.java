package com.builtbroken.militarybasedecor.worldwar2.content.block;

import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Created by Ole on 7/22/2015.
 * TODO Make a one slot storage GUI for any item from Armory.
 */
public class BlockEquipmentCrate extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    public BlockEquipmentCrate() {
        super(Material.iron);
        this.setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB);
        this.setBlockName("equipment_crate");
        this.setBlockTextureName(MilitaryBaseDecor.PREFIX + "equipment_crate_side");
        this.setHardness(1);
        this.setResistance(1);
        this.setStepSound(Block.soundTypeMetal);
    }
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.iconSide = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "equipment_crate_side");
        this.iconTop = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "equipment_crate_top");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return metadata == 0 && side == 2 ? this.iconSide : side == 3 ? this.iconSide : side == 4 ? this.iconSide : side == 5 ? this.iconSide : side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side == metadata ? this.iconSide : this.iconSide));
    }

}
