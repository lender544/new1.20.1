package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla;

import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModDataAttachments;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.items.Tidal_Claws;
import com.github.L_Ender.cataclysm.message.MessageHookFalling;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class Scylla_Storm_Bringer_Entity extends AbstractArrow {
	private static final EntityDataAccessor<Integer> HOOKED_ENTITY_ID = SynchedEntityData.defineId(Scylla_Storm_Bringer_Entity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Optional<UUID>> CONTROLLER_UUID = SynchedEntityData.defineId(Scylla_Storm_Bringer_Entity.class, EntityDataSerializers.OPTIONAL_UUID);
	private static final EntityDataAccessor<Integer> CONTROLLER_ID = SynchedEntityData.defineId(Scylla_Storm_Bringer_Entity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> GRAB = SynchedEntityData.defineId(Scylla_Storm_Bringer_Entity.class, EntityDataSerializers.BOOLEAN);

	private double maxRange = 0D;
	private double maxSpeed = 12D;
	private Entity hookedEntity;
	private ItemStack stack;

	public Scylla_Storm_Bringer_Entity(EntityType<? extends Scylla_Storm_Bringer_Entity> p_37561_, Level p_37562_) {
		super(p_37561_, p_37562_);
		this.setBaseDamage(15);
	}

	public Scylla_Storm_Bringer_Entity(Level p_37569_, LivingEntity p_37570_, ItemStack p_37571_) {
		super(ModEntities.SCYLLA_STORM_BRINGER.get(), p_37570_, p_37569_, p_37571_, null);
		this.setBaseDamage(15);

	}


	public Scylla_Storm_Bringer_Entity(Level p_338686_, double p_338771_, double p_338674_, double p_338477_, ItemStack p_338255_) {
		super(ModEntities.SCYLLA_STORM_BRINGER.get(), p_338771_, p_338674_, p_338477_, p_338686_, p_338255_, p_338255_);
		this.setBaseDamage(15);
	}

	public Vec3 getChainFrom(float partialTicks) {
		return this.getPosition(partialTicks).add(0, 0.0, 0);
	}

	public Vec3 getChainTo(float partialTicks) {
		if (getOwner() !=null) {
			return getOwner().getPosition(partialTicks).add(0, getOwner().getBbHeight(), 0);
		}
		return this.getPosition(partialTicks).add(0, 0.3, 0);
	}


	protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
		super.defineSynchedData(p_326229_);
		p_326229_.define(HOOKED_ENTITY_ID, 0);
		p_326229_.define(CONTROLLER_UUID, Optional.empty());
		p_326229_.define(CONTROLLER_ID, -1);
		p_326229_.define(GRAB, false);
	}

	@Nullable
	public UUID getControllerUUID() {
		return this.entityData.get(CONTROLLER_UUID).orElse(null);
	}

	public void setControllerUUID(@Nullable UUID uniqueId) {
		this.entityData.set(CONTROLLER_UUID, Optional.ofNullable(uniqueId));
	}

	public Entity getController() {
		if (!level().isClientSide) {
			final UUID id = getControllerUUID();
			return id == null ? null : ((ServerLevel) level()).getEntity(id);
		} else {
			int id = this.entityData.get(CONTROLLER_ID);
			return id == -1 ? null : level().getEntity(id);
		}
	}

	public boolean getGrab() {
		return this.entityData.get(GRAB);
	}

	public void setGrab(boolean weapon) {
		this.entityData.set(GRAB, weapon);
	}


	@Override
	public void tick() {
		super.tick();
		Entity controller = getController();

		if (controller instanceof Scylla_Entity levi) {
			this.entityData.set(CONTROLLER_ID, levi.getId());
			levi.setAnchorUUID(this.getUUID());
			if (!level().isClientSide) {
				if (this.hookedEntity != null) {
					if (this.hookedEntity.isRemoved()) {
						this.hookedEntity = null;
					} else {
						this.setPos(this.hookedEntity.getX(), this.hookedEntity.getY(0.8D), this.hookedEntity.getZ());
					}
					if (this.getGrab()) {
						Entity target = hookedEntity;
						double brakeZone = (6D * (maxSpeed / 10));
						double pullSpeed = maxSpeed / 6D;
						Vec3 distance = levi.position().subtract(target.position().add(0, target.getBbHeight() / 2, 0));
						Vec3 motion = distance.normalize().scale(distance.length() < brakeZone ? (pullSpeed * distance.length()) / brakeZone : pullSpeed);

						if (Math.abs(distance.y) < 0.1D)
							motion = new Vec3(motion.x, 0, motion.z);
						if (new Vec3(distance.x, 0, distance.z).length() < new Vec3(target.getBbWidth() / 2, 0, target.getBbWidth() / 2).length() / 1.4)
							motion = new Vec3(0, motion.y, 0);

						target.setDeltaMovement(motion);
						target.hurtMarked = true;

					}
				}
			}
		}

	}



	@Override
	protected void onHitEntity(EntityHitResult p_37573_) {
		Entity entity = p_37573_.getEntity();
		float f = 6.5F;
		Entity entity1 = this.getController();
		DamageSource damagesource = this.damageSources().trident(this, (Entity)(entity1 == null ? this : entity1));

		if (entity.hurt(damagesource, (float) this.getBaseDamage())) {
			if (entity.getType() == EntityType.ENDERMAN) {
				return;
			}

			if (entity instanceof LivingEntity livingentity) {
				this.doKnockback(livingentity, damagesource);
				this.doPostHurtEffects(livingentity);
			}
		}

		this.playSound(SoundEvents.TRIDENT_HIT, 1.0F, 1.0F);
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
	protected ItemStack getDefaultPickupItem() {
		return ItemStack.EMPTY;
	}


	protected void doKnockback(LivingEntity entity, DamageSource damageSource) {

		double d0 = 1.5D;

		double d1 = Math.max((double)0.0F, (double)1.0F - (entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE )* 1/3));
		Vec3 vec3 = this.getDeltaMovement().multiply((double)1.0F, (double)0.0F, (double)1.0F).normalize().scale(d0 * 0.6 * d1);
		if (vec3.lengthSqr() > (double)0.0F) {
			entity.push(vec3.x, 0.1, vec3.z);
		}


	}


	@Override
	protected void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		if(!level().isClientSide) {
			ScreenShake_Entity.ScreenShake(level(), this.position(), 25, 0.1f, 0, 20);
		}

	}

	protected double getDefaultGravity() {
		return 0.12;
	}

	protected SoundEvent getDefaultHitGroundSoundEvent() {
		return ModSounds.EXPLOSION.get();
	}


	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);

		maxRange = tag.getDouble("maxRange");
		maxSpeed = tag.getDouble("maxSpeed");
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putDouble("maxRange", maxRange);
		tag.putDouble("maxSpeed", maxSpeed);
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
