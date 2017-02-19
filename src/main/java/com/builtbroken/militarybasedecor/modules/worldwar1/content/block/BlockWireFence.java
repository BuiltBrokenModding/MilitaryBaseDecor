package com.builtbroken.militarybasedecor.modules.worldwar1.content.block;

import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.mc.lib.helper.recipe.OreNames;
import com.builtbroken.militarybasedecor.core.ConfigManager;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.worldwar1.WorldWar1Module;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;


public class BlockWireFence extends BlockPane implements IRecipeContainer
{
    public static final IIcon[] icon = new IIcon[4];
    public static final IIcon[] iconTop = new IIcon[4];

    public BlockWireFence()
    {
        super("wire_fence", MilitaryBaseDecor.PREFIX + "wired_fence_top", Material.iron, false);
        this.setBlockName("wire_fence");
        this.setHardness(3.0F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(null);
    }

    @SideOnly(Side.CLIENT)
    public IIcon func_150104_b(int p_150104_1_)
    {
        return icon[~p_150104_1_ & 3];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon func_149735_b(int p_149735_1_, int p_149735_2_)
    {
        return icon[p_149735_2_ % iconTop.length];
    }

    @SideOnly(Side.CLIENT)
    public static int func_150103_c(int p_150103_0_) {
        return p_150103_0_ & 3;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.func_149735_b(p_149691_1_, ~p_149691_2_ & 3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
        super.registerBlockIcons(reg);

        icon[0] = reg.registerIcon(MilitaryBaseDecor.PREFIX + "barbed_wire_fence_bloody");
        icon[1] = reg.registerIcon(MilitaryBaseDecor.PREFIX + "barbed_wire_fence");
        icon[2] = reg.registerIcon(MilitaryBaseDecor.PREFIX + "chain_link_fence");
        icon[3] = reg.registerIcon(MilitaryBaseDecor.PREFIX + "wired_fence");
        iconTop[0] = reg.registerIcon(MilitaryBaseDecor.PREFIX + "wired_fence_top");
        iconTop[1] = reg.registerIcon(MilitaryBaseDecor.PREFIX + "wired_fence_top");
        iconTop[2] = reg.registerIcon(MilitaryBaseDecor.PREFIX + "wired_fence_top");
        iconTop[3] = reg.registerIcon(MilitaryBaseDecor.PREFIX + "wired_fence_top");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xhit, float yhit, float zhit)
    {
        if (!world.isRemote)
        {
            if (WireFence.getType(world, x, y, z) == WireFence.WIRE) {
                if (player.getHeldItem() != null && player.getHeldItem().getItem() == WorldWar1Module.itemWireCutters) {
                    if (world.setBlockToAir(x, y, z)) {
                        world.playSoundEffect(x, y, z, "militarybasedecor:wirecutters", 2.0F, 1.0F);
                        player.inventory.addItemStackToInventory(new ItemStack(this, 1, 0));
                        player.inventoryContainer.detectAndSendChanges();
                        player.getHeldItem().damageItem(1, player);

                        if (ConfigManager.WIRECUTTERS_CHAT) {
                            player.addChatMessage(new ChatComponentText(player.getDisplayName() + " " + StatCollector.translateToLocal("wire_cutters.chattext.wiredfence")));
                        }
                    }
                }
            } else if (WireFence.getType(world, x, y, z) == WireFence.CHAIN) {
                if (player.getHeldItem() != null && player.getHeldItem().getItem() == WorldWar1Module.itemWireCutters) {
                    if (world.setBlockToAir(x, y, z)) {
                        world.playSoundEffect(x, y, z, "militarybasedecor:wirecutters", 2.0F, 1.0F);
                        player.inventory.addItemStackToInventory(new ItemStack(this, 1, 1));
                        player.inventoryContainer.detectAndSendChanges();
                        player.getHeldItem().damageItem(1, player);

                        if (ConfigManager.WIRECUTTERS_CHAT) {
                            player.addChatMessage(new ChatComponentText(player.getDisplayName() + " " + StatCollector.translateToLocal("wire_cutters.chattext.chainfence")));
                        }
                    }
                }
            } else if (WireFence.getType(world, x, y, z) == WireFence.BARBED) {
                if (player.getHeldItem() != null && player.getHeldItem().getItem() == WorldWar1Module.itemWireCutters) {
                    if (world.setBlockToAir(x, y, z)) {
                        world.playSoundEffect(x, y, z, "militarybasedecor:wirecutters", 2.0F, 1.0F);
                        player.inventory.addItemStackToInventory(new ItemStack(this, 1, 2));
                        player.inventoryContainer.detectAndSendChanges();
                        player.getHeldItem().damageItem(1, player);

                        if (ConfigManager.WIRECUTTERS_CHAT) {
                            player.addChatMessage(new ChatComponentText(player.getDisplayName() + " " + StatCollector.translateToLocal("wire_cutters.chattext.barbedfence")));
                        }
                    }
                }
            } else if (WireFence.getType(world, x, y, z) == WireFence.BARBEDBlOOD) {
                if (player.getHeldItem() != null && player.getHeldItem().getItem() == WorldWar1Module.itemWireCutters) {
                    if (world.setBlockToAir(x, y, z)) {
                        world.playSoundEffect(x, y, z, "militarybasedecor:wirecutters", 2.0F, 1.0F);
                        player.inventory.addItemStackToInventory(new ItemStack(this, 1, 3));
                        player.inventoryContainer.detectAndSendChanges();
                        player.getHeldItem().damageItem(1, player);

                        if (ConfigManager.WIRECUTTERS_CHAT) {
                            player.addChatMessage(new ChatComponentText(player.getDisplayName() + " " + StatCollector.translateToLocal("wire_cutters.chattext.barbedfence")));
                        }
                    }
                }
            }
        }
            return false;
        }

    @Override
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity player)
    {
        if (WireFence.getType(world, i, j, k) == WireFence.BARBED)
        {
            if (!(player instanceof EntityPlayer) || !((EntityPlayer) player).capabilities.isCreativeMode)
            {
                player.setInWeb();
                player.attackEntityFrom(DamageSource.cactus, 1.0F);
            }
        } else if (WireFence.getType(world, i, j, k) == WireFence.BARBEDBlOOD)
        {
            if (!(player instanceof EntityPlayer) || !((EntityPlayer) player).capabilities.isCreativeMode) {
                player.setInWeb();
                player.attackEntityFrom(DamageSource.cactus, 1.0F);
            }
        }
    }

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
        return true;
    }

    @Override
    public void genRecipes(List<IRecipe> recipes)
    {
        if (OreDictionary.doesOreNameExist(OreNames.ROD_IRON))
        {
            recipes.add(newShapedRecipe(new ItemStack(WorldWar1Module.blockWireFence, 8, 0), "RWR", "WWW", "RWR", 'W', WorldWar1Module.itemWire, 'R', OreNames.ROD_IRON));
        }
        else
        {
            recipes.add(newShapedRecipe(new ItemStack(WorldWar1Module.blockWireFence, 8, 0), "RWR", "WWW", "RWR", 'W', WorldWar1Module.itemWire, 'R', Items.stick));
        }
        recipes.add(newShapedRecipe(new ItemStack(WorldWar1Module.blockWireFence, 8, 1), "R R", " R ", "R R", 'R', WorldWar1Module.itemWire));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
        list.add(new ItemStack(item, 1, 3));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    /** Enum of wire types */
    public enum WireFence
    {
        WIRE,
        CHAIN,
        BARBED,
        BARBEDBlOOD;

        public static WireFence getType(World world, int x, int y, int z)
        {
            int meta = world.getBlockMetadata(x, y, z);
            if (meta > 0 && meta < WireFence.values().length)
            {
                return WireFence.values()[meta];
            }
            return WIRE;
        }
    }
}