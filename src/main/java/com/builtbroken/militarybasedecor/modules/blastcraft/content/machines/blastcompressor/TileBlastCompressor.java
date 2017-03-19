package com.builtbroken.militarybasedecor.modules.blastcraft.content.machines.blastcompressor;

import com.builtbroken.jlib.type.Pair;
import com.builtbroken.mc.api.recipe.IMachineRecipeHandler;
import com.builtbroken.mc.api.tile.IGuiTile;
import com.builtbroken.mc.core.registry.implement.IRecipeContainer;
import com.builtbroken.mc.lib.helper.recipe.OreNames;
import com.builtbroken.mc.lib.helper.recipe.UniversalRecipe;
import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.prefab.inventory.InventoryUtility;
import com.builtbroken.mc.prefab.tile.TileModuleMachine;
import com.builtbroken.mc.prefab.tile.module.TileModuleInventory;
import com.builtbroken.militarybasedecor.client.MBDRecipeType;
import com.builtbroken.militarybasedecor.core.MilitaryBaseDecor;
import com.builtbroken.militarybasedecor.modules.blastcraft.Blastcraft;
import com.builtbroken.militarybasedecor.modules.blastcraft.content.block.ItemBlockBlastcraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

/**
 * @see <a href="https://github.com/BuilBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Henry Stabell) on 18.03.2017 for MilitaryBaseDecor.
 */
public class TileBlastCompressor extends TileModuleMachine implements IRecipeContainer, IGuiTile
{
    private static final int[] slotsTop = new int[]{0, 1};
    private static final int[] slotsBottom = new int[]{0, 1, 4};
    private static final int[] slotsSides = new int[]{2, 3};

    private String localizedName;

    protected boolean hasRecipe = false;
    protected int processingTicks = 0;
    protected int burnTime = 0;
    protected int burnTimeItem = 0;

    @SideOnly(Side.CLIENT)
    public static IIcon frontIcon;

    @SideOnly(Side.CLIENT)
    public static IIcon frontIconOn;

    @SideOnly(Side.CLIENT)
    public static IIcon sideIcon;

    @SideOnly(Side.CLIENT)
    public static IIcon topIcon;

    @SideOnly(Side.CLIENT)
    public static IIcon topIconOn;

    @SideOnly(Side.CLIENT)
    public static IIcon bottomIcon;

    public TileBlastCompressor()
    {
        super("blast_compressor", Material.rock);
        this.itemBlock = ItemBlockBlastcraft.class;
        this.resistance = 1;
        this.hardness = 5;
    }

    @Override
    protected IInventory createInventory()
    {
        return new TileModuleInventory(this, 5);
    }

    @Override
    public TileBlastCompressor newTile()
    {
        return new TileBlastCompressor();
    }

    public void setGuiDisplayName(String displayName) {
        this.localizedName = displayName;
    }

    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.localizedName : "container.blast_compressor";
    }

    public boolean hasCustomInventoryName() {
        return this.localizedName != null && this.localizedName.length() > 0;
    }

    @Override
    public void update()
    {
        super.update();

        if (isServer())
        {
            boolean isModified = false;
            //Reduce the fuel level
            if (burnTime > 0)
            {
                burnTime--;
            }

            //Check recipe once a second
            if (ticks % 20 == 0)
            {
                hasRecipe = getRecipeOutput(0) != null || getRecipeOutput(1) != null;
            }

            //Consume fuel when needed
            if (hasRecipe && burnTime <= 0)
            {
                this.burnTimeItem = this.burnTime = TileEntityFurnace.getItemBurnTime(getStackInSlot(4));
                isModified = true;
                if (burnTime > 0)
                {
                    //Bucket handling
                    if (getStackInSlot(4).stackSize == 1)
                    {
                        setInventorySlotContents(4, getStackInSlot(4).getItem().getContainerItem(getStackInSlot(4)));
                    }
                    else
                    {
                        decrStackSize(4, 1);
                    }
                }
            }

            if (this.burnTime > 0 && hasRecipe)
            {
                if (processingTicks >= 200)
                {
                    for (int slot = 0; slot <= 1; slot++)
                    {
                        Pair<ItemStack, Integer> recipeOutput = getRecipeOutput(slot);
                        if (recipeOutput != null)
                        {
                            if (addToOutput(recipeOutput.left(), true))
                            {
                                processingTicks = 0;
                                decrStackSize(recipeOutput.right(), 1);
                                isModified = true;
                            }
                        }
                    }
                }
                else
                {
                    processingTicks++;
                }
            }
            else
            {
                processingTicks = 0;
            }

            if (isModified)
            {
                this.markDirty();
            }
        }
    }

    @Override
    protected boolean onPlayerRightClick(EntityPlayer player, int side, Pos hit)
    {
        if (isServer())
        {
            openGui(player, MilitaryBaseDecor.INSTANCE);
        }
        return true;
    }

    @Override
    protected boolean onPlayerRightClickWrench(EntityPlayer player, int side, Pos hit)
    {
        //TODO Add ability to rotate with wrench
        return false;
    }

    /**
     * Gets the recipe for the furnace
     *
     * @return
     */
    public Pair<ItemStack, Integer> getRecipeOutput(int slot)
    {
        IMachineRecipeHandler recipeHandler = MBDRecipeType.ITEM_COMPRESSOR.getHandler();
        if (recipeHandler != null)
        {
            if (getStackInSlot(slot) != null)
            {
                Object out = recipeHandler.getRecipe(new Object[]{getStackInSlot(slot)}, 0, 0);
                if (out instanceof ItemStack)
                {
                    return new Pair(out, slot);
                }
            }
        }
        return null;
    }

    /**
     * Called to output an item
     *
     * @param stack    - stack to output
     * @param doAction - true will output stack, false will check for space only
     * @return
     */
    public boolean addToOutput(ItemStack stack, boolean doAction)
    {
        for (int i = 2; i <= 3; i++)
        {
            ItemStack slotStack = getStackInSlot(i);
            if (slotStack == null)
            {
                if (doAction)
                {
                    setInventorySlotContents(i, stack);
                }
                return true;
            }
            else if (InventoryUtility.stacksMatch(stack, slotStack) && InventoryUtility.roomLeftInSlot(this, i) >= stack.stackSize)
            {
                if (doAction)
                {
                    slotStack.stackSize += stack.stackSize;
                    setInventorySlotContents(i, slotStack);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canStore(ItemStack stack, int slot, ForgeDirection side)
    {
        if (slot == 0 || slot == 1)
        {
        }
        else if (slot == 4)
        {
            return TileEntityFurnace.isItemFuel(stack);
        }
        return false;
    }

    @Override
    public boolean canRemove(ItemStack stack, int slot, ForgeDirection side)
    {
        return slot == 2 || slot == 3;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        return side == 0 ? slotsBottom : (side == 1 ? slotsTop : slotsSides);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.burnTime = nbt.getInteger("cookTime");
        this.burnTimeItem = nbt.getInteger("cookTimeItem");
        this.processingTicks = nbt.getInteger("processingTicks");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("cookTime", burnTime);
        nbt.setInteger("cookTimeItem", burnTimeItem);
        nbt.setInteger("processingTicks", processingTicks);
    }

    @Override
    protected boolean useMetaForFacing()
    {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (side == 0)
        {
            return bottomIcon;
        }
        else if (side == 1)
        {
            return burnTime > 0 ? topIconOn : topIcon;
        }
        else if (side == meta)
        {
            return burnTime > 0 ? frontIconOn : frontIcon;
        }
        return sideIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        sideIcon = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "blastcraft/blast_compressor_side");
        topIcon = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "blastcraft/blast_compressor_top");
        topIconOn = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "blastcraft/blast_compressor_top_on");
        bottomIcon = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "blastcraft/blast_compressor_side"); // TODO possibly add a proper bottom texture, or just remove the bottomIcon.
        frontIcon = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "blastcraft/blast_compressor_front");
        frontIconOn = iconRegister.registerIcon(MilitaryBaseDecor.PREFIX + "blastcraft/blast_compressor_front_on");
    }

    @Override
    public void genRecipes(List<IRecipe> recipes)
    {
        recipes.add(newShapedRecipe(new ItemStack(Blastcraft.blastCompressor, 1, 0), "IFI", "PCP", "IMI", 'I', OreNames.PLATE_IRON, 'F', Blocks.furnace, 'P', Blocks.piston, 'C', UniversalRecipe.CIRCUIT_T1.get(), 'M', UniversalRecipe.MOTOR.get()));
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player)
    {
        return new ContainerBlastCompressor(player, this);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player)
    {
        return new GuiBlastCompressor(player, this);
    }
}