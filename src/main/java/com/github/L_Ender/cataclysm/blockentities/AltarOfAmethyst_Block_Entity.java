package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.L_Ender.cataclysm.init.ModRecipeTypes;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import com.github.L_Ender.cataclysm.message.MessageUpdateblockentity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Clearable;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class AltarOfAmethyst_Block_Entity extends BlockEntity implements Clearable {
    private static final int NUM_SLOTS = 1;
    private final NonNullList<ItemStack> items = NonNullList.withSize(NUM_SLOTS, ItemStack.EMPTY);
    public int blessingProgress;
    public int tickCounts;
    public boolean brightThisTick = false;
    private final RecipeManager.CachedCheck<Container, AltarOfAmethystRecipe> quickCheck = RecipeManager.createCheck(ModRecipeTypes.AMETHYST_BLESS.get());

    public AltarOfAmethyst_Block_Entity(BlockPos p_155301_, BlockState p_155302_) {
        super(ModTileentites.ALTAR_OF_AMETHYST.get(), p_155301_, p_155302_);
    }

    public static void cookTick(Level p_155307_, BlockPos p_155308_, BlockState p_155309_, AltarOfAmethyst_Block_Entity p_155310_) {
        p_155310_.brightThisTick = false;
        p_155310_.tickCounts++;
        ItemStack itemstack = p_155310_.items.get(0);
        if (!itemstack.isEmpty()) {
            Container container = new SimpleContainer(itemstack);
            Optional<AltarOfAmethystRecipe> ingredient = p_155310_.quickCheck.getRecipeFor(container, p_155307_);
            ItemStack finale = ingredient.map((p_270054_) -> p_270054_.getResult().copy()).orElse(itemstack);
            if(ingredient.isPresent()){
                p_155310_.brightThisTick = true;
                if(p_155310_.blessingProgress >= ingredient.get().getTime()) {
                    ItemStack current = p_155310_.getItem(0).copy();
                    current.shrink(1);
                    if(!current.isEmpty()){
                        ItemEntity itemEntity = new ItemEntity(p_155307_, p_155308_.getX() + 0.5F, p_155308_.getY() + 0.5F, p_155308_.getZ() + 0.5F, current);
                        if(!p_155307_.isClientSide){
                            p_155307_.addFreshEntity(itemEntity);
                        }
                    }
                    p_155310_.setItem(0, finale);
                }
            }

        }

        if(!p_155310_.brightThisTick){
            p_155310_.blessingProgress = 0;
        }else{
            p_155310_.blessingProgress++;
        }

    }
    
    public int getContainerSize() {
        return this.items.size();
    }

    public ItemStack getItem(int index) {
        return this.items.get(index);
    }

    public void setItem(int index, ItemStack stack) {
        this.items.set(index, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }
        this.saveAdditional(this.getUpdateTag());
        if (!level.isClientSide) {
            Cataclysm.sendMSGToAll(new MessageUpdateblockentity(this.getBlockPos().asLong(), items.get(0)));
        }
    }

    public int getMaxStackSize() {
        return 1;
    }
    

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public void load(CompoundTag p_155312_) {
        super.load(p_155312_);
        this.items.clear();
        ContainerHelper.loadAllItems(p_155312_, this.items);
        if (p_155312_.contains("blessingProgress", 11)) {
            this.blessingProgress = p_155312_.getInt("blessingProgress");
        }

    }

    protected void saveAdditional(CompoundTag p_187486_) {
        super.saveAdditional(p_187486_);
        ContainerHelper.saveAllItems(p_187486_, this.items, true);
        p_187486_.putInt("blessingProgress", this.blessingProgress);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundtag, this.items, true);
        return compoundtag;
    }

    public Optional<AltarOfAmethystRecipe> getCookableRecipe(ItemStack p_59052_) {
        return this.items.stream().noneMatch(ItemStack::isEmpty) ? Optional.empty() : this.quickCheck.getRecipeFor(new SimpleContainer(p_59052_), this.level);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }
}
