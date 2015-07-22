package com.builtbroken.militarybasedecor.worldwar2;

import com.builtbroken.mc.lib.mod.loadable.AbstractLoadable;
import com.builtbroken.militarybasedecor.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.worldwar2.content.block.*;
import com.builtbroken.militarybasedecor.worldwar2.content.item.ItemChocolate;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WorldWar2Module extends AbstractLoadable {

    public static Block corrugatedGalvanisedIronBlock;
    public static Block oliveDrabTexturedBlock;
    public static Block ammunitionBox;

    public static Item chocolate;

    @Override
    public void preInit() {
        if (MilitaryBaseDecor.CHOCOLATE_ENABLED) {
            chocolate = MilitaryBaseDecor.INSTANCE.getManager().newItem("chocolate", new ItemChocolate(0, 0F, false).setPotionEffect(20, 60, 1, 1F).setTextureName(MilitaryBaseDecor.DOMAIN + "chocolate").setUnlocalizedName("chocolate").setCreativeTab(MilitaryBaseDecor.CREATIVE_TAB));
        }
        ammunitionBox = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockAmmunitionBox.class, ItemBlockWorldWar2.class);
        corrugatedGalvanisedIronBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockCorrugatedGalvanisedIron.class, ItemBlockCorrugatedGalvanisedIron.class);
        oliveDrabTexturedBlock = MilitaryBaseDecor.INSTANCE.getManager().newBlock(BlockOliveDrabTexturedBlock.class, ItemBlockWorldWar2.class);

        MilitaryBaseDecor.CREATIVE_TAB.itemStack = new ItemStack(ammunitionBox);
    }

    @Override
    public void postInit() {
    }
}

