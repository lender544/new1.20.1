package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blocks.Boss_Respawn_Spawner_Block;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.LLibrary_Boss_Monster;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Clearable;
import net.minecraft.world.Container;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.ticks.ContainerSingleItem;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.Function;

public class Boss_Respawn_Spawner_Block_Entity extends BlockEntity implements Clearable, ContainerSingleItem {
	public int Animaitonticks;
	public int tickCount;
	public int animation = 0;
	public AnimationState openingAnimationState = new AnimationState();
	protected static final int SHORT_RANGE = 9, LONG_RANGE = 50;
	private Entity displayEntity;
	private EntityType<?> spawnType = null;
	protected boolean spawnedBoss = false;
	private final NonNullList<ItemStack> item = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);


	public Boss_Respawn_Spawner_Block_Entity(BlockPos pos, BlockState state) {
		super(ModTileentites.BOSS_RESPAWNER.get(), pos, state);
	}

	public AnimationState getAnimationState(String input) {
		if (input == "opening") {
			return this.openingAnimationState;
		}else {
			return new AnimationState();
		}
	}

	public boolean triggerEvent(int p_58837_, int p_58838_) {
		if (p_58837_ == 1) {
			this.openingAnimationState.start(this.tickCount);
			return true;
		} else {
			return super.triggerEvent(p_58837_, p_58838_);
		}
	}

	public static void tick(Level level, BlockPos pos, BlockState state, Boss_Respawn_Spawner_Block_Entity te) {
		te.tickCount++;
		if (te.spawnedBoss || !te.anyPlayerInRange(level)) {
			return;
		}

		if (state.getBlock() instanceof Boss_Respawn_Spawner_Block) {
			if (state.getValue(Boss_Respawn_Spawner_Block.LIT)) {
				++te.Animaitonticks;

				if (level instanceof ServerLevel serverLevel) {
						if (level.getDifficulty() != Difficulty.PEACEFUL) {
							if (te.Animaitonticks >= 19) {
								if (te.spawnMyBoss(serverLevel, pos)) {
									level.destroyBlock(pos, false);
									te.spawnedBoss = true;
								}
							}
						}
					}

			} else {
				te.Animaitonticks = 0;
			}
		}

	}

	public boolean anyPlayerInRange(Level level) {
		return level.hasNearbyAlivePlayer(this.getBlockPos().getX() + 0.5D, this.getBlockPos().getY() + 0.5D, this.getBlockPos().getZ() + 0.5D, this.getRange());
	}

	protected boolean spawnMyBoss(ServerLevel serverLevel, BlockPos pos) {
		Vec3 vec3 = Vec3.atLowerCornerWithOffset(pos, 0.5, 0, 0.5);
		Entity entity;
		try {
			entity = spawnType.create(serverLevel);
		} catch (Exception exception) {
			Cataclysm.LOGGER.warn("Failed to create mob", (Throwable) exception);
			return false;
		}

		if (entity != null) {
			entity.setPos(vec3);
			if (entity instanceof IABoss_monster iaBossMonster) {
				iaBossMonster.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(worldPosition), MobSpawnType.SPAWNER, null, null);
				ResourceLocation dimLoc = serverLevel.dimension().location();
				iaBossMonster.setDimensionType(dimLoc.toString());
				iaBossMonster.setHomePos(BlockPos.containing(vec3));
				// spawn it
			} else if (entity instanceof LLibrary_Boss_Monster llBossMonster) {
				llBossMonster.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(worldPosition), MobSpawnType.SPAWNER, null, null);
				ResourceLocation dimLoc = serverLevel.dimension().location();
				llBossMonster.setDimensionType(dimLoc.toString());
				llBossMonster.setHomePos(BlockPos.containing(vec3));
			}
			return serverLevel.addFreshEntity(entity);
		}
		return false;
	}


	protected int getRange() {
		return SHORT_RANGE;
	}


	public ItemStack getItem(int p_273280_) {
		return this.item.get(p_273280_);
	}

	public ItemStack removeItem(int p_273514_, int p_273414_) {
		ItemStack itemstack = Objects.requireNonNullElse(this.item.get(p_273514_), ItemStack.EMPTY);
		this.item.set(p_273514_, ItemStack.EMPTY);
		if (!itemstack.isEmpty()) {
			this.setChanged();
		}

		return itemstack;
	}

	public void setItem(int p_273461_, ItemStack p_273584_) {
		if (this.level != null) {
			this.item.set(p_273461_, p_273584_);
			this.setChanged();
		}

	}

	public void setEntityId(EntityType<?> type) {
		this.spawnType = type;
		this.setChanged();
	}

	public int getMaxStackSize() {
		return 1;
	}

	public boolean canPlaceItem(int p_273369_, ItemStack p_273689_) {
		return this.getItem(p_273369_).isEmpty();
	}

	public void onHit(Level level) {
		BlockPos blockpos = this.getBlockPos();
		BlockState state = this.getBlockState();
		if (!state.getValue(Boss_Respawn_Spawner_Block.LIT)) {
			level.setBlock(blockpos, state.setValue(Boss_Respawn_Spawner_Block.LIT, Boolean.valueOf(true)), 2);
			level.blockEvent(blockpos, this.getBlockState().getBlock(), 1, 0);
		}
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	public boolean canTakeItem(Container p_273497_, int p_273168_, ItemStack p_273785_) {
		return false;
	}

	public CompoundTag getUpdateTag() {
		return this.saveWithoutMetadata();
	}

	@Override
	public void load(CompoundTag tag) {
		super.load(tag);

		if (tag.contains("EntityType")) {
			String str = tag.getString("EntityType");
			this.spawnType = ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(str));
		}


		if (tag.contains("Item", 10)) {
			this.item.set(0, ItemStack.of(tag.getCompound("Item")));
		}
		this.Animaitonticks = tag.getInt("animationTicks");
	}


	@Override
	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		if (!this.getFirstItem().isEmpty()) {
			tag.put("Item", this.getFirstItem().save(new CompoundTag()));
		}
		tag.putInt("animationTicks", this.Animaitonticks);
		if (this.spawnType != null) {
			tag.putString("EntityType", ForgeRegistries.ENTITY_TYPES.getKey(this.spawnType).toString());
		}
	}
	public Entity getDisplayEntity(Level level) {
		if (displayEntity == null && spawnType != null || displayEntity != null && displayEntity.getType() != spawnType) {
			displayEntity = spawnType.create(level);
		}
		return displayEntity;
	}


	public boolean stillValid(Player p_273466_) {
		return Container.stillValidBlockEntity(this, p_273466_);
	}
}
