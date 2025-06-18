package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.capabilities.HookCapability;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.items.Tidal_Claws;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class Tidal_Hook_Entity extends AbstractArrow {
	private static final EntityDataAccessor<Integer> HOOKED_ENTITY_ID = SynchedEntityData.defineId(Tidal_Hook_Entity.class, EntityDataSerializers.INT);

	private double maxRange = 0D;
	private double maxSpeed = 0D;
	private boolean isPulling = false;
	private Entity hookedEntity;
	private ItemStack stack;

	public Tidal_Hook_Entity(EntityType<? extends AbstractArrow> type, Player owner, Level world) {
		super(type, owner, world);
		this.setNoGravity(true);
		this.setBaseDamage(0);
	}

	public Tidal_Hook_Entity(Level world, double x, double y, double z) {
		super(ModEntities.TIDAL_HOOK.get(), x, y, z, world);
		this.setNoGravity(true);
		this.setBaseDamage(0);
	}

	public Tidal_Hook_Entity(EntityType<Tidal_Hook_Entity> tidal_hook_entityEntityType, Level level) {
		super(tidal_hook_entityEntityType, level);
		this.setNoGravity(true);
		this.setBaseDamage(0);
	}


	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(HOOKED_ENTITY_ID, 0);
	}

	@Override
	public void tick() {
		super.tick();
		HookCapability.IHookCapability hookCapability = ModCapabilities.getCapability(getOwner(), ModCapabilities.HOOK_CAPABILITY);
		if(getOwner() instanceof Player owner) {
			if (hookCapability != null) {
				if (isPulling && tickCount % 3 == 0) {
					level().playSound(null, getOwner().blockPosition(), ModSounds.TIDAL_HOOK_LOOP.get(), SoundSource.PLAYERS, 0.4F, 1F);
				}
				if (!level().isClientSide) {
					if (owner.isDeadOrDying() || !hookCapability.hasHook() || owner.distanceTo(this) > maxRange || !(owner.getMainHandItem().getItem() instanceof Tidal_Claws || owner.getOffhandItem().getItem() instanceof Tidal_Claws))
						kill();
					if (this.hookedEntity != null) {
						if (this.hookedEntity.isRemoved()) {
							this.hookedEntity = null;
							discard();
						} else {
							this.moveTo(this.hookedEntity.getX(), this.hookedEntity.getY(0.8D), this.hookedEntity.getZ());
						}
					}

					if (owner.getMainHandItem() == stack || owner.getOffhandItem() == stack) {
						if (isPulling) {
							Entity origin = this;



							double brakeZone = (6D * (maxSpeed / 10));
							double pullSpeed = maxSpeed / 6D;
							Vec3 distance = origin.position().subtract(owner.position().add(0, owner.getBbHeight() / 2, 0));
							Vec3 motion = distance.normalize().scale(distance.length() < brakeZone ? (pullSpeed * distance.length()) / brakeZone : pullSpeed);

							if (Math.abs(distance.y) < 0.1D)
								motion = new Vec3(motion.x, 0, motion.z);
							if (new Vec3(distance.x, 0, distance.z).length() < new Vec3(owner.getBbWidth() / 2, 0, owner.getBbWidth() / 2).length() / 1.4)
								motion = new Vec3(0, motion.y, 0);

							owner.setDeltaMovement(motion);
							owner.hurtMarked = true;

						}
					} else {
						kill();
					}
				}
			} else {
				kill();
			}
		}
	}

	@Override
	public void kill() {
		HookCapability.IHookCapability hookCapability = ModCapabilities.getCapability(	getOwner(), ModCapabilities.HOOK_CAPABILITY);
		if(!level().isClientSide && getOwner() instanceof Player owner) {
			if (hookCapability != null) {
				hookCapability.setHasHook(false);
				owner.setNoGravity(false);
			}
		}

		super.kill();
	}

	@Override
	public boolean shouldRenderAtSqrDistance(double distance) {
		return true;
	}

	protected float getWaterInertia() {
		return 1.0F;
	}

	@Override
	protected ItemStack getPickupItem() {
		return ItemStack.EMPTY;
	}

	@Override
	protected void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		isPulling = true;

		if(!level().isClientSide && getOwner() instanceof Player owner && hookedEntity == null) {
			owner.setNoGravity(true);
		}
	}

	public boolean canChangeDimensions() {
		return false;
	}

	protected SoundEvent getDefaultHitGroundSoundEvent() {
		return ModSounds.TIDAL_HOOK_HIT.get();
	}

	@Override
	protected void onHitEntity(EntityHitResult entityHitResult) {
		if(!level().isClientSide && getOwner() instanceof Player owner && entityHitResult.getEntity() != owner) {
			if((entityHitResult.getEntity() instanceof LivingEntity || entityHitResult.getEntity() instanceof EnderDragonPart) && hookedEntity == null) {
				hookedEntity = entityHitResult.getEntity();
				this.getEntityData().set(HOOKED_ENTITY_ID, hookedEntity.getId() + 1);
				isPulling = true;
			}
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);

		maxRange = tag.getDouble("maxRange");
		maxSpeed = tag.getDouble("maxSpeed");
		isPulling = tag.getBoolean("isPulling");
		stack = ItemStack.of(tag.getCompound("hookshotItem"));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putDouble("maxRange", maxRange);
		tag.putDouble("maxSpeed", maxSpeed);
		tag.putBoolean("isPulling", isPulling);
		tag.put("hookshotItem", stack.save(new CompoundTag()));;
	}

	public void setProperties(ItemStack stack, double maxRange, double maxVelocity, float pitch, float yaw, float roll, float modifierZ) {
		float f = 0.017453292F;
		float x = -Mth.sin(yaw * f) * Mth.cos(pitch * f);
		float y = -Mth.sin((pitch + roll) * f);
		float z = Mth.cos(yaw * f) * Mth.cos(pitch * f);
		this.shoot(x, y, z, modifierZ, 0);
		this.stack = stack;
		this.maxRange = maxRange;
		this.maxSpeed = maxVelocity;
	}
}
