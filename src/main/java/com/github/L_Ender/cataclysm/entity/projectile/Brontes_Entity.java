package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.client.particle.Options.TrackLightningParticleOptions;
import com.github.L_Ender.cataclysm.entity.effect.Lightning_Storm_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
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
import net.neoforged.neoforge.entity.IEntityWithComplexSpawn;

public class Brontes_Entity extends AbstractArrow implements IEntityWithComplexSpawn {
	private static final EntityDataAccessor<Boolean> RETURN = SynchedEntityData.defineId(Brontes_Entity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Float> Y_ROT_OLD = SynchedEntityData.defineId(Brontes_Entity.class, EntityDataSerializers.FLOAT);
	private static final EntityDataAccessor<Float> X_ROT_OLD = SynchedEntityData.defineId(Brontes_Entity.class, EntityDataSerializers.FLOAT);
	private static final EntityDataAccessor<Float> AREA_DAMAGE = SynchedEntityData.defineId(Brontes_Entity.class, EntityDataSerializers.FLOAT);
	private static final EntityDataAccessor<Float> STORM_DAMAGE = SynchedEntityData.defineId(Brontes_Entity.class, EntityDataSerializers.FLOAT);
	public Brontes_Entity(EntityType type, Level worldIn) {
		super(type, worldIn);
	}

	public Brontes_Entity(EntityType type, double x, double y, double z, Level worldIn) {
		this(type, worldIn);
		this.setPos(x, y, z);
	}

	public Brontes_Entity(Level worldIn, LivingEntity shooter) {
		this(ModEntities.BRONTES.get(), shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
		this.setOwner(shooter);
		this.pickup = Pickup.DISALLOWED;
	}



	protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
		super.defineSynchedData(p_326229_);
		p_326229_.define(RETURN, false);
		p_326229_.define(Y_ROT_OLD, 0F);
		p_326229_.define(X_ROT_OLD, 0F);
		p_326229_.define(AREA_DAMAGE, 0F);
		p_326229_.define(STORM_DAMAGE, 0F);
	}



	public boolean getReturn() {
		return this.entityData.get(RETURN);
	}

	public void setReturn(boolean weapon) {
		this.entityData.set(RETURN, weapon);
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

	public float getAreaDamage() {
		return this.entityData.get(AREA_DAMAGE);
	}

	public void setAreaDamage(float rot) {
		this.entityData.set(AREA_DAMAGE, rot);
	}

	public float getStormDamage() {
		return this.entityData.get(STORM_DAMAGE);
	}

	public void setStormDamage(float rot) {
		this.entityData.set(STORM_DAMAGE, rot);
	}


	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);

		this.setReturn(tag.getBoolean("Return"));
		this.setStormDamage(tag.getFloat("StormDamage"));
		this.setAreaDamage(tag.getFloat("AreaDamage"));

	}

	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Return", this.getReturn());
		tag.putFloat("StormDamage", this.getStormDamage());
		tag.putFloat("AreaDamage", this.getAreaDamage());
	}

	@Override
	public void tick() {
		super.tick();
		if (this.getOwner() instanceof LivingEntity owner) {
			if (this.getReturn()) {
				if (!this.isAcceptibleReturnOwner()) {
					this.discard();
				} else {
					this.setNoPhysics(true);
					Vec3 vec3 = owner.getEyePosition().subtract(this.position());
					this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.015 * (double) 3, this.getZ());
					this.setYRot(getYrotOld());
					//this.setXRot(getXrotOld());
					if (this.level().isClientSide) {
						this.yOld = this.getY();
					} else {
						if (this.distanceTo(owner) < 3F) {
							this.discard();
						}
					}
					double d0 = 0.2;
					this.setDeltaMovement(this.getDeltaMovement().scale(0.95).add(vec3.normalize().scale(d0)));
				}

			}
		} else {
			discard();
		}


		Vec3 center = this.position().add(this.getDeltaMovement());
		Vec3 vec3 = center.add(new Vec3(random.nextFloat() - 0.5F, random.nextFloat() - 0.5F, random.nextFloat() - 0.5F));
		if (this.level().isClientSide) {
			this.level().addParticle((new TrackLightningParticleOptions(143, 241, 215)), center.x, center.y, center.z, vec3.x, vec3.y, vec3.z);

		}



	}


	private boolean isAcceptibleReturnOwner() {
		Entity entity = this.getOwner();
		return entity == null || !entity.isAlive() ? false : !(entity instanceof ServerPlayer) || !entity.isSpectator();
	}


	@Override
	protected void onHitEntity(EntityHitResult p_37573_) {
		Entity entity = p_37573_.getEntity();
		Entity entity1 = this.getOwner();
		DamageSource damagesource = CMDamageTypes.causePlayerCeraunusDamage(this, (Entity)(entity1 == null ? this : entity1));
		if (entity.hurt(damagesource, (float) this.getBaseDamage())) {
			if (entity.getType() == EntityType.ENDERMAN) {
				return;
			}

			if (entity instanceof LivingEntity livingentity) {
				this.doKnockback(livingentity, damagesource);
				this.doPostHurtEffects(livingentity);
				this.playSound(this.getHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
			}
		}

	}

	@Override
	protected void onHitBlock(BlockHitResult p_37573_) {
		super.onHitBlock(p_37573_);

	}

	public ItemStack getWeaponItem() {
		return this.getPickupItemStackOrigin();
	}

	protected boolean tryPickup(Player player) {
		return false;
	}

	protected ItemStack getDefaultPickupItem() {
		return new ItemStack(ModItems.CERAUNUS.get());
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
		Vec3 hitPos = result.getLocation();
		if (!this.level().isClientSide) {
			setXrotOld(this.getXRot());
			setYrotOld(this.getYRot());
			ScreenShake_Entity.ScreenShake(level(), this.position(), 25, 0.03f, 0, 20);

			float speed = 1.0F;

			final int quakeCount = 8;
			float angle = 360.0F / quakeCount;
			for (int i = 0; i < 8; i++) {
				double angleRad = Math.toRadians(i * angle);

				double xDir = Math.cos(angleRad);
				double zDir = Math.sin(angleRad);

				Spark_Entity peq = new Spark_Entity(this.level(), (LivingEntity)this.getOwner());

				peq.setPos(hitPos.x, hitPos.y + 0.1, hitPos.z);
				peq.setAreaDamage(this.getAreaDamage());
				peq.setDamage(this.getStormDamage());
				peq.setAreaRadius(1.0f);

				peq.shoot(xDir, 0.125 , zDir, speed, 5.0F);

				this.level().addFreshEntity(peq);
			}
			this.level().addFreshEntity(new Lightning_Storm_Entity(this.level(), this.getX(), this.getY(), this.getZ(), this.getYRot(), -9, this.getStormDamage(), 0, (LivingEntity)this.getOwner(),3.0F));


			setReturn(true);
		}else{
			if (this.level().isClientSide) {
				this.level().addParticle(ModParticle.LIGHTNING_EXPLODE.get(), hitPos.x, this.getY(), hitPos.z, 0, 0, 0);
			}
		}

	}

	public boolean canUsePortal(boolean allowPassengers) {
		return false;
	}

	protected double getDefaultGravity() {
		return 0.1;
	}

	protected SoundEvent getDefaultHitGroundSoundEvent() {
		return ModSounds.HEAVY_SMASH.get();
	}


	@Override
	public void writeSpawnData(RegistryFriendlyByteBuf buffer) {
		buffer.writeInt(this.getOwner() != null ? this.getOwner().getId() : -1);
	}

	@Override
	public void readSpawnData(RegistryFriendlyByteBuf buf) {
		Entity e = this.level().getEntity(buf.readInt());
		if (e instanceof LivingEntity) {
			this.setOwner(e);
		}
	}
}
