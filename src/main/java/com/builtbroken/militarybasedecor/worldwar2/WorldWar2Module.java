package com.builtbroken.militarybasedecor.worldwar2;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.managers.ConfigManager;
import com.builtbroken.militarybasedecor.prefab.BlockColoredStairs;
import com.builtbroken.militarybasedecor.worldwar2.content.block.*;
import com.builtbroken.militarybasedecor.worldwar2.content.item.ItemChocolate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WorldWar2Module extends AbstractLoadable {
    public static String[] colors =
            {
                    "Black",
                    "Red",
                    "Green",
                    "Brown",
                    "Blue",
                    "Purple",
                    "Cyan",
                    "LightGray",
                    "Gray",
                    "Pink",
                    "Lime",
                    "Yellow",
                    "LightBlue",
                    "Magenta",
                    "Orange",
                    "White"
            };

    public static Block corrugatedGalvanisedIronBlock;
    public static Block oliveDrabTexturedBlock;
    public static Block ammunitionBox;
    public static Block equipmentCrate;
    public static Block reinforcedConcrete;
    public static Block reinforcedConcreteStairs[] = new Block[16];


    public static Item chocolate;

    @Override
    public void preInit() {
        if (ConfigManager.CHOCOLATE_ENABLED) {
            chocolate = MilitaryBaseDecor.INSTANCE.getManager().newItem("chocolate", new ItemChocolate(0, 0F, false).setPotionEffect(20, 60, 1, 1F).setUnlocalizedName("chocolate").setTextureName(MilitaryBaseDecor.DOMAIN + "chocolate").setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1));
        }
        ammunitionBox = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAmmunitionBox.class, ItemBlockWorldWar2.class);
        corrugatedGalvanisedIronBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockCorrugatedGalvanisedIron.class, ItemBlockCorrugatedGalvanisedIron.class);
        oliveDrabTexturedBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockOliveDrabTexturedBlock.class, ItemBlockWorldWar2.class);
        equipmentCrate = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockEquipmentCrate.class, ItemBlockWorldWar2.class);
        reinforcedConcrete = MilitaryBaseDecor.INSTANCE.getManager().newBlock("concrete_reinforced", new BlockColored(Material.rock).setHardness(20).setResistance(175).setStepSound(Block.soundTypeStone).setBlockName("concrete_reinforced").setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1), ItemBlockWorldWar2.class);
        for (int i = 0; i < 16; i++) {
            reinforcedConcreteStairs[i] = MilitaryBaseDecor.INSTANCE.getManager().newBlock("concrete_reinforced_stairs_" + i, new BlockColoredStairs(reinforcedConcrete, i).setResistance(175).setHardness(20).setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB_1).setStepSound(Block.soundTypeStone), ItemBlockWorldWar2.class);
        }
        MilitaryBaseDecor.CREATIVE_TAB_1.itemStack = new ItemStack(ammunitionBox);
    }

    @Override
    public void postInit() {

        WW2Recipes.initItemRecipes();
        WW2Recipes.initBlockRecipes();
    }
}