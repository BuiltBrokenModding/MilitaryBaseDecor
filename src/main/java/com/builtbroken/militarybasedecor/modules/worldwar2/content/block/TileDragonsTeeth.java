package com.builtbroken.militarybasedecor.modules.worldwar2.content.block;

import com.builtbroken.mc.api.items.ISimpleItemRenderer;
import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.mc.lib.transform.region.Cube;
import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.prefab.tile.Tile;
import com.builtbroken.mc.prefab.tile.TileEnt;
import com.builtbroken.militarybasedecor.client.Assets;
import com.builtbroken.militarybasedecor.modules.worldwar2.WorldWar2Module;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import java.util.List;

/**
 * WW2 Fortification Block mainly used to block tanks and other military vehicles. Meant for aesthetics rather than functionality in MBD
 * TODO Add more variants.
 * TODO Fix textures not binding (Might be an issue with the OBJ file itself...)
 *
 * @see <a href="https://github.com/BuilBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry Stabell) on 05.03.2017 for MilitaryBaseDecor.
 */
public class TileDragonsTeeth extends TileEnt implements ISimpleItemRenderer, IRecipeContainer {

    public TileDragonsTeeth()
    {
        super("dragons_teeth", Material.rock);
        this.isOpaque = false;
        this.renderNormalBlock = false;
        this.renderTileEntity = true;
        this.itemBlock = ItemBlockWorldWar2.class;
        this.bounds = new Cube(0F, 0F, 0F, 1F, 1F, 1F);
        this.hardness = 5;
        this.resistance = 3;
    }

    @Override
    public boolean canUpdate()
    {
        return false;
    }

    @Override
    public Tile newTile()
    {
        return new TileDragonsTeeth();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon()
    {
        return WorldWar2Module.reinforcedConcrete.getIcon(0, 0);
    }

    @Override
    public void renderInventoryItem(IItemRenderer.ItemRenderType itemRenderType, ItemStack itemStack, Object... objects)
    {
        GL11.glTranslatef(-2f, 7.9f, 5.7f);
        GL11.glScaled(5f, 10f, 5f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.DRAGONS_TEETH_TEXTURE);
        Assets.DRAGONS_TEETH.renderAll();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderDynamic(Pos pos, float frame, int pass)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef(pos.xf() + -3.85f, pos.yf() + 7.56f, pos.zf() + 5.65f);
        GL11.glScaled(6.21f, 10.59f, 6.22f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Assets.DRAGONS_TEETH_TEXTURE);
        Assets.DRAGONS_TEETH.renderAll();
        GL11.glPopMatrix();
    }

    // TODO Add recipe!
    @Override
    public void genRecipes(List<IRecipe> recipes) {}
}
