package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.blocks.Altar_Of_Amethyst_Block;
import com.github.L_Ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.L_Ender.cataclysm.init.ModRecipeTypes;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;


import javax.annotation.Nullable;
import java.util.Optional;

public class AltarOfAmethyst_Block_Entity extends BlockEntity
{
	private final ItemStackHandler inventory = createHandler();
	private int cookingTime;
	private int cookingTimeTotal;


	private final RecipeManager.CachedCheck<SingleRecipeInput, AltarOfAmethystRecipe> quickCheck;

	public AltarOfAmethyst_Block_Entity(BlockPos pos, BlockState state) {
		super(ModTileentites.ALTAR_OF_AMETHYST.get(), pos, state);
		this.quickCheck = RecipeManager.createCheck(ModRecipeTypes.AMETHYST_BLESS.get());
	}

	public static void cookingTick(Level level, BlockPos pos, BlockState state, AltarOfAmethyst_Block_Entity skillet) {
		ItemStack cookingStack = skillet.getStoredStack();
		if (cookingStack.isEmpty()) {
			skillet.cookingTime = 0;
		} else {
			skillet.cookAndOutputItems(cookingStack, level,pos);
		}
	}


	private void cookAndOutputItems(ItemStack cookingStack, Level level, BlockPos pos) {
		++cookingTime;
		if (cookingTime >= cookingTimeTotal) {
			Optional<RecipeHolder<AltarOfAmethystRecipe>> recipe = getMatchingRecipe(cookingStack);
			if (recipe.isPresent()) {
				ItemStack resultStack = recipe.get().value().assemble(new SingleRecipeInput(cookingStack), level.registryAccess());
				Containers.dropItemStack(level, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), resultStack.copy());
				cookingTime = 0;
				inventory.extractItem(0, 1, false);
			}
		}
	}

	public boolean isCooking() {
		return hasStoredStack();
	}


	private Optional<RecipeHolder<AltarOfAmethystRecipe>> getMatchingRecipe(ItemStack stack) {
		if (level == null) return Optional.empty();
		return this.quickCheck.getRecipeFor(new SingleRecipeInput(stack), this.level);
	}

	@Override
	public void loadAdditional(CompoundTag compound, HolderLookup.Provider registries) {
		super.loadAdditional(compound, registries);
		inventory.deserializeNBT(registries, compound.getCompound("Inventory"));
		cookingTime = compound.getInt("CookTime");
		cookingTimeTotal = compound.getInt("CookTimeTotal");
	}

	@Override
	public void saveAdditional(CompoundTag compound, HolderLookup.Provider registries) {
		super.saveAdditional(compound, registries);
		compound.put("Inventory", inventory.serializeNBT(registries));
		compound.putInt("CookTime", cookingTime);
		compound.putInt("CookTimeTotal", cookingTimeTotal);
	}



	public ItemStack addItemToCook(ItemStack addedStack, Player player) {
		Optional<RecipeHolder<AltarOfAmethystRecipe>> recipe = getMatchingRecipe(addedStack);
		if (recipe.isPresent() && getStoredStack().isEmpty()) {
			ItemStack remainderStack = inventory.insertItem(0, addedStack.copy(), false);
			if (!ItemStack.matches(remainderStack, addedStack)) {
				cookingTimeTotal = Altar_Of_Amethyst_Block.getCookingTime(recipe.get().value().getTime());
				cookingTime = 0;
				return remainderStack;
			}
		}
		return addedStack;
	}

	public ItemStack removeItem() {
		return inventory.extractItem(0, getStoredStack().getMaxStackSize(), false);
	}

	public IItemHandler getInventory() {
		return inventory;
	}

	public ItemStack getStoredStack() {
		return inventory.getStackInSlot(0);
	}

	public boolean hasStoredStack() {
		return !getStoredStack().isEmpty();
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler()
		{
			@Override
			protected void onContentsChanged(int slot) {
				inventoryChanged();
			}
		};
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
	}


	@Override
	@Nullable
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
		return saveWithoutMetadata(registries);
	}
//
//	@Override
//	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
//		load(pkt.getTag());
//	}

	protected void inventoryChanged() {
		super.setChanged();
		if (level != null)
			level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
	}
}
