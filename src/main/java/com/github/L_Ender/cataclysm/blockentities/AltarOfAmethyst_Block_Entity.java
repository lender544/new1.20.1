package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.L_Ender.cataclysm.init.ModRecipeTypes;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.Optional;

public class AltarOfAmethyst_Block_Entity extends BlockEntity implements Clearable  {
    private static final int NUM_SLOTS = 1;
    private final NonNullList<ItemStack> items = NonNullList.withSize(NUM_SLOTS, ItemStack.EMPTY);
    public int tickCounts;

    private final int[] blessingProgress = new int[1];
    private final int[] cookingTime = new int[1];

    public boolean brightThisTick = false;
    private final RecipeManager.CachedCheck<SingleRecipeInput, AltarOfAmethystRecipe> quickCheck = RecipeManager.createCheck(ModRecipeTypes.AMETHYST_BLESS.get());
    public AltarOfAmethyst_Block_Entity(BlockPos p_155301_, BlockState p_155302_) {
        super(ModTileentites.ALTAR_OF_AMETHYST.get(), p_155301_, p_155302_);
    }

    public static void cookTick(Level p_155307_, BlockPos p_155308_, BlockState p_155309_, AltarOfAmethyst_Block_Entity p_155310_) {
        p_155310_.brightThisTick = false;
        p_155310_.tickCounts++;
        for (int i = 0; i < p_155310_.items.size(); i++) {
            ItemStack itemstack = p_155310_.items.get(i);
            if (!itemstack.isEmpty()) {
                p_155310_.brightThisTick  = true;
                p_155310_.blessingProgress[i]++;
                if (p_155310_.blessingProgress[i] >= p_155310_.cookingTime[i]) {
                    SingleRecipeInput singlerecipeinput = new SingleRecipeInput(itemstack);
                    ItemStack itemstack1 = p_155310_.quickCheck
                            .getRecipeFor(singlerecipeinput, p_155307_)
                            .map(p_344662_ -> p_344662_.value().assemble(singlerecipeinput, p_155307_.registryAccess()))
                            .orElse(itemstack);
                    if (itemstack1.isItemEnabled(p_155307_.enabledFeatures())) {
                        Containers.dropItemStack(p_155307_, (double)p_155308_.getX(), (double)p_155308_.getY(), (double)p_155308_.getZ(), itemstack1);
                        p_155310_.items.set(i, ItemStack.EMPTY);
                        p_155307_.sendBlockUpdated(p_155308_, p_155309_, p_155309_, 3);
                        p_155307_.gameEvent(GameEvent.BLOCK_CHANGE, p_155308_, GameEvent.Context.of(p_155309_));
                    }
                }
            }
        }

        if (p_155310_.brightThisTick) {
            setChanged(p_155307_, p_155308_, p_155309_);
        }

    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public int getContainerSize() {
        return this.items.size();
    }

    public ItemStack getItem(int index) {
        return this.items.get(index);
    }


    public int getMaxStackSize() {
        return 1;
    }

    public void placeItem(@Nullable LivingEntity entity, int index, ItemStack stack) {
        this.getItems().set(index, stack);
        if (!stack.isEmpty() && stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }

        this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(entity, this.getBlockState()));
        this.markUpdated();
    }

    public void loadAdditional(CompoundTag p_155312_, HolderLookup.Provider p_324612_) {
        super.loadAdditional(p_155312_,p_324612_);
        this.items.clear();
        ContainerHelper.loadAllItems(p_155312_, this.items, p_324612_);
        if (p_155312_.contains("blessingProgress", 11)) {
            int[] aint = p_155312_.getIntArray("blessingProgress");
            System.arraycopy(aint, 0, this.blessingProgress, 0, Math.min(this.cookingTime.length, aint.length));
        }

        if (p_155312_.contains("blessingTotalTimes", 11)) {
            int[] aint1 = p_155312_.getIntArray("blessingTotalTimes");
            System.arraycopy(aint1, 0, this.cookingTime, 0, Math.min(this.cookingTime.length, aint1.length));
        }

    }

    protected void saveAdditional(CompoundTag p_187486_, HolderLookup.Provider p_324612_) {
        super.saveAdditional(p_187486_,p_324612_);
        ContainerHelper.saveAllItems(p_187486_, this.items, true, p_324612_);
        p_187486_.putIntArray("blessingProgress", this.blessingProgress);
        p_187486_.putIntArray("blessingTotalTimes", this.cookingTime);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag(HolderLookup.Provider p_324612_) {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundtag, this.items, true, p_324612_);
        return compoundtag;
    }


    public Optional<RecipeHolder<AltarOfAmethystRecipe>> getCookableRecipe(ItemStack p_59052_) {
        return this.items.stream().noneMatch(ItemStack::isEmpty) ? Optional.empty() : this.quickCheck.getRecipeFor(new SingleRecipeInput(p_59052_), this.level);
    }


    public boolean placeFood(@Nullable LivingEntity p_347582_, ItemStack p_238286_, int p_238287_) {
        for (int i = 0; i < this.items.size(); i++) {
            ItemStack itemstack = this.items.get(i);
            if (itemstack.isEmpty()) {
                this.cookingTime[i] = p_238287_;
                this.blessingProgress[i] = 0;
                this.items.set(i, p_238286_.consumeAndReturn(1, p_347582_));
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(p_347582_, this.getBlockState()));
                this.markUpdated();
                return true;
            }
        }

        return false;
    }

    private void markUpdated() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    public void dowse() {
        if (this.level != null) {
            this.markUpdated();
        }
    }

    @Override
    protected void applyImplicitComponents(BlockEntity.DataComponentInput p_338534_) {
        super.applyImplicitComponents(p_338534_);
        p_338534_.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyInto(this.getItems());
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder p_338620_) {
        super.collectImplicitComponents(p_338620_);
        p_338620_.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getItems()));
    }

    @Override
    public void removeComponentsFromTag(CompoundTag p_332690_) {
        p_332690_.remove("Items");
    }


}
