package com.builtbroken.militarybasedecor.modules.coldwar.content.block;

import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.coldwar.ColdWarModule;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

/**
 * @see <a href="https://github.com/BuilBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry Stabell) on 12.02.2017 for VoltzEngine.
 */
public class BlockReinforcedDoor extends BlockDoor {

    private IIcon[] textures;

    public BlockReinforcedDoor() {
        super(Material.iron);
        this.setHardness(10F);
        this.setResistance(10F);
        this.setStepSound(Block.soundTypeMetal);
        this.setCreativeTab((CreativeTabs)null);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.textures = new IIcon[2];
        this.textures[0] = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "reinforced_door_upper");
        this.textures[1] = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "reinforced_door_lower");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess iBlockAccess, int x, int y, int z, int side) {
        return this.getIcon(side, iBlockAccess.getBlockMetadata(x, y, z));
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return (meta & 8) == 8?this.textures[0]:this.textures[1];
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return ColdWarModule.reinforcedDoorItem;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return (p_149650_1_ & 8) != 0 ? null : (ColdWarModule.reinforcedDoorItem);
    }

}