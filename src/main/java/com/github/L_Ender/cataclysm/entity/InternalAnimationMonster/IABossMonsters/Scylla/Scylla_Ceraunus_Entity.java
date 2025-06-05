package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Spark_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.message.MessageEntityCamera;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PacketDistributor;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class Scylla_Ceraunus_Entity extends AbstractArrow {

	private static final EntityDataAccessor<Optional<UUID>> CONTROLLER_UUID = SynchedEntityData.defineId(Scylla_Ceraunus_Entity.class, EntityDataSerializers.OPTIONAL_UUID);
	private static final EntityDataAccessor<Integer> CONTROLLER_ID = SynchedEntityData.defineId(Scylla_Ceraunus_Entity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> GRAB = SynchedEntityData.defineId(Scylla_Ceraunus_Entity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Float> Y_ROT_OLD = SynchedEntityData.defineId(Scylla_Ceraunus_Entity.class, EntityDataSerializers.FLOAT);
	private static final EntityDataAccessor<Float> X_ROT_OLD = SynchedEntityData.defineId(Scylla_Ceraunus_Entity.class, EntityDataSerializers.FLOAT);
	private static final EntityDataAccessor<Boolean> HOOK_MODE = SynchedEntityData.defineId(Scylla_Ceraunus_Entity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> PHASE = SynchedEntityData.defineId(Scylla_Ceraunus_Entity.class, EntityDataSerializers.INT);
	public Scylla_Ceraunus_Entity(EntityType type, Level worldIn) {
		super(type, worldIn);
	}

	public Scylla_Ceraunus_Entity(EntityType type, double x, double y, double z, Level worldIn) {
		this(type, worldIn);
		this.setPos(x, y, z);
	}

	public Scylla_Ceraunus_Entity(Level worldIn, LivingEntity shooter) {
		this(ModEntities.SCYLLA_CERAUNUS.get(), shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
		this.setOwner(shooter);
		if (shooter instanceof Player) {
			this.pickup = Pickup.ALLOWED;
		}
	}


	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(CONTROLLER_UUID, Optional.empty());
		this.entityData.define(CONTROLLER_ID, -1);
		this.entityData.define(GRAB, false);
		this.entityData.define(HOOK_MODE, false);
		this.entityData.define(Y_ROT_OLD, 0F);
		this.entityData.define(X_ROT_OLD, 0F);
		this.entityData.define(PHASE, 0);
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

	public boolean getHookMode() {
		return this.entityData.get(HOOK_MODE);
	}

	public void setHookMode(boolean weapon) {
		this.entityData.set(HOOK_MODE, weapon);
	}

	public float getYrotOld() {
		return this.entityData.get(Y_ROT_OLD);
	}

	public void setYrotOld(float rot) {
		this.entityData.set(Y_ROT_OLD, rot);
	}

	public float getXrotOld() {
		return this.entityData.get(X_ROT_OLD);
	}

	public void setXrotOld(float rot) {
		this.entityData.set(X_ROT_OLD, rot);
	}

	public int getPhase() {
		return this.entityData.get(PHASE);
	}

	public void setPhase(int phase) {
		this.entityData.set(PHASE, phase);
	}

	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);

		if (tag.hasUUID("ControllerUUID")) {
			this.setControllerUUID(tag.getUUID("ControllerUUID"));
		}
		this.setHookMode(tag.getBoolean("Hook"));
		this.setGrab(tag.getBoolean("Grab"));
		this.setPhase(tag.getInt("Phase"));
	}

	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		if (this.getControllerUUID() != null) {
			tag.putUUID("ControllerUUID", this.getControllerUUID());
		}
		tag.putBoolean("Hook", this.getHookMode());
		tag.putBoolean("Grab", this.getGrab());
		tag.putInt("Phase", this.getPhase());
	}

	@Override
	public void tick() {
		super.tick();
		Entity controller = getController();

		if (controller instanceof Scylla_Entity levi) {
			this.entityData.set(CONTROLLER_ID, levi.getId());
			levi.setAnchorUUID(this.getUUID());

			if (this.getHookMode()) {
				if (this.getGrab()) {
					if (!level().isClientSide) {
						for (LivingEntity entity : level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().deflate(0.2f))) {
							if (entity.equals(controller)) {
								this.discard();
							}
						}
					}
				}
			} else {
				if (this.getGrab()) {
					if (!this.isAcceptibleReturnOwner()) {
						this.discard();
					} else {
						this.setNoPhysics(true);
						Vec3 vec3 = controller.getEyePosition().subtract(this.position());
						this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.015 * (double) 3, this.getZ());
						this.setYRot(getYrotOld());
						//this.setXRot(getXrotOld());
						if (this.level().isClientSide) {
							this.yOld = this.getY();
						}else {
							if (!this.getPassengers().isEmpty()) {
								if (this.getPassengers().get(0).isShiftKeyDown()) {
									this.getPassengers().get(0).setShiftKeyDown(false);
								}
							}
							for (LivingEntity entity : level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().deflate(0.2f))) {
								if (entity.equals(controller)) {
									if (!this.getPassengers().isEmpty()) {
										Cataclysm.NETWORK_WRAPPER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> this.getPassengers().get(0)), new MessageEntityCamera(this.getPassengers().get(0).getId(), false));
									}
									this.discard();
								}
							}
						}

						double d0 = 0.2;
						this.setDeltaMovement(this.getDeltaMovement().scale(0.95).add(vec3.normalize().scale(d0)));
					}
				}

			}
		}
	}


	private boolean isAcceptibleReturnOwner() {
		Entity entity = this.getController();
		return entity == null || !entity.isAlive() ? false : !(entity instanceof ServerPlayer) || !entity.isSpectator();
	}

	@Override
	protected void onHitEntity(EntityHitResult p_37573_) {
		Entity entity = p_37573_.getEntity();
		Entity entity1 = this.getController();
		DamageSource damagesource = CMDamageTypes.causeStormBringerDamage(this, (Entity)(entity1 == null ? this : entity1));
		if (entity.hurt(damagesource, (float) this.getBaseDamage())) {

			if (entity.getType() == EntityType.ENDERMAN) {
				return;
			}

			if (entity instanceof LivingEntity livingentity) {
				this.doKnockback(livingentity, damagesource);
				this.doPostHurtEffects(livingentity);
			}
			if(!this.getHookMode()) {
				if (this.getPassengers().isEmpty()) {
					if (!this.level().isClientSide) {
						entity.startRiding(this, true);
						Cataclysm.NETWORK_WRAPPER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), new MessageEntityCamera(entity.getId(),true));
					}
				}
			}
		}

	}

	@Override
	protected void onHitBlock(BlockHitResult p_37573_) {
		super.onHitBlock(p_37573_);
		double DeltaMovementX = this.random.nextGaussian() * 0.1D;
		double DeltaMovementY = this.random.nextGaussian() * 0.02D;
		double DeltaMovementZ = this.random.nextGaussian() * 0.1D;
		if (this.level().isClientSide) {
			for (int i1 = 0; i1 < 5 + random.nextInt(2); i1++) {
				this.level().addParticle(ModParticle.SPARK.get(), this.getX(), this.getY(), this.getZ(), DeltaMovementX, DeltaMovementY, DeltaMovementZ);
			}
		}else{
			Entity entity1 = this.getController();

			if(entity1 instanceof LivingEntity living) {
				if(this.getPhase() > 0) {
					for (int i = 0; i < this.getPhase(); i++) {
						Spark_Entity peq = new Spark_Entity(this.level(), living);
						peq.setDamage((float) CMConfig.ScyllaLightningStormDamage);
						peq.setAreaDamage((float) CMConfig.ScyllaLightningAreaDamage);
						peq.setAreaRadius(1.0F);
						peq.setHpDamage((float) CMConfig.ScyllaLightningStormHpDamage);
						peq.shoot((this.random.nextFloat() - 0.5) * 0.5F, this.random.nextFloat() * 0.4F + 0.01F, (this.random.nextFloat() - 0.5) * 0.5F, 1.0F, 1F);
						peq.setPos(this.getX(), this.getY() + 0.03, this.getZ());
						this.level().addFreshEntity(peq);
					}
				}
			}
		}



	}

	public double getPassengersRidingOffset() {
		return 0.5D;
	}

	@Override
	protected ItemStack getPickupItem() {
		return ItemStack.EMPTY;
	}

	protected boolean tryPickup(Player player) {
		return super.tryPickup(player) || this.isNoPhysics() && this.ownedBy(player) && player.getInventory().add(this.getPickupItem());
	}


	public boolean shouldRiderSit() {
		return false;
	}


	@Override
	public boolean shouldRenderAtSqrDistance(double distance) {
		return true;
	}

	protected float getWaterInertia() {
		return 0.95F;
	}

	protected void doKnockback(LivingEntity entity, DamageSource damageSource) {

		double d0 = 1.5D;

		double d1 = Math.max((double)0.0F, (double)1.0F - (entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE )* 1/3));
		Vec3 vec3 = this.getDeltaMovement().multiply((double)1.0F, (double)0.0F, (double)1.0F).normalize().scale(d0 * 0.6 * d1);
		if (vec3.lengthSqr() > (double)0.0F) {
			entity.push(vec3.x, 0.1, vec3.z);
		}


	}


	protected void onHit(HitResult result) {
		super.onHit(result);

		if (!this.level().isClientSide) {
			setXrotOld(this.getXRot());
			setYrotOld(this.getYRot());
			ScreenShake_Entity.ScreenShake(level(), this.position(), 25, 0.1f, 0, 20);
			setGrab(true);
		}

	}

	public boolean canChangeDimensions() {
		return false;
	}

	protected float getGravity() {
		return 0.08F;
	}

	protected SoundEvent getDefaultHitGroundSoundEvent() {
		return SoundEvents.GENERIC_EXPLODE;
	}
}
