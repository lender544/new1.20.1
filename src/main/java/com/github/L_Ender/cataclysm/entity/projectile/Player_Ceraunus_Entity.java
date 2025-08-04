package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.IHoldEntity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.message.MessageEntityCameraSwitch;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.IEntityWithComplexSpawn;
import net.neoforged.neoforge.network.PacketDistributor;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class Player_Ceraunus_Entity extends AbstractArrow implements IEntityWithComplexSpawn {
	private static final EntityDataAccessor<Boolean> RETURN = SynchedEntityData.defineId(Player_Ceraunus_Entity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Float> Y_ROT_OLD = SynchedEntityData.defineId(Player_Ceraunus_Entity.class, EntityDataSerializers.FLOAT);
	private static final EntityDataAccessor<Float> X_ROT_OLD = SynchedEntityData.defineId(Player_Ceraunus_Entity.class, EntityDataSerializers.FLOAT);


	public Player_Ceraunus_Entity(EntityType type, Level worldIn) {
		super(type, worldIn);
	}

	public Player_Ceraunus_Entity(EntityType type, double x, double y, double z, Level worldIn) {
		this(type, worldIn);
		this.setPos(x, y, z);
	}

	public Player_Ceraunus_Entity(Level worldIn, LivingEntity shooter) {
		this(ModEntities.PLAYER_CERAUNUS.get(), shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
		this.setOwner(shooter);
		this.pickup = Pickup.DISALLOWED;
	}



	protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
		super.defineSynchedData(p_326229_);
		p_326229_.define(RETURN, false);
		p_326229_.define(Y_ROT_OLD, 0F);
		p_326229_.define(X_ROT_OLD, 0F);
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


	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);

		this.setReturn(tag.getBoolean("Return"));
	}

	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Return", this.getReturn());
	}

	@Override
	public void tick() {
		super.tick();
		if(this.getOwner() instanceof LivingEntity owner) {
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
		}else{
			discard();
		}
	}


	private boolean isAcceptibleReturnOwner() {
		Entity entity = this.getOwner();
		return entity == null || !entity.isAlive() ? false : !(entity instanceof ServerPlayer) || !entity.isSpectator();
	}


	public Vec3 ChainPos() {
		Vec3 pos = this.position();

		float yaw = this.getYRot();
		float pitch = this.getXRot();

		double offsetBack = 25D;
		double offsetDown = 0.1D;

		double x = -Mth.sin((float) Math.toRadians(yaw)) * Mth.cos((float) Math.toRadians(pitch)) * offsetBack;
		double y = -Mth.sin((float) Math.toRadians(pitch)) * offsetBack - offsetDown;
		double z = Mth.cos((float) Math.toRadians(yaw)) * Mth.cos((float) Math.toRadians(pitch)) * offsetBack;

        return pos.add(x, y, z);
	}

	@Override
	protected void onHitEntity(EntityHitResult p_37573_) {
		Entity entity = p_37573_.getEntity();
		Entity entity1 = this.getOwner();
		DamageSource damagesource = CMDamageTypes.causeStormBringerDamage(this, (Entity)(entity1 == null ? this : entity1));
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
		double DeltaMovementX = getRandom().nextGaussian() * 0.1D;
		double DeltaMovementY = getRandom().nextGaussian() * 0.02D;
		double DeltaMovementZ = getRandom().nextGaussian() * 0.1D;
		if (this.level().isClientSide) {
			for (int i1 = 0; i1 < 5 + random.nextInt(2); i1++) {
				this.level().addParticle(ModParticle.SPARK.get(), this.getX(), this.getY(), this.getZ(), DeltaMovementX, DeltaMovementY, DeltaMovementZ);
			}
		}
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

		if (!this.level().isClientSide) {
			setXrotOld(this.getXRot());
			setYrotOld(this.getYRot());
			ScreenShake_Entity.ScreenShake(level(), this.position(), 25, 0.03f, 0, 20);
			setReturn(true);
		}

	}

	public boolean canUsePortal(boolean allowPassengers) {
		return false;
	}

	protected double getDefaultGravity() {
		return 0.08;
	}

	protected SoundEvent getDefaultHitGroundSoundEvent() {
		return ModSounds.HEAVY_SMASH.get();
	}

	public Vec3 getChainTo(float partialTicks) {
		if (this.getOwner() !=null) {
			return getOwner().getPosition(partialTicks);
		}
		return this.getPosition(partialTicks).add(0, 0.0, 0);
	}

	public Vec3 getChainFrom(float partialTicks) {
		return this.getPosition(partialTicks).add(0, 0.0, 0);
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
