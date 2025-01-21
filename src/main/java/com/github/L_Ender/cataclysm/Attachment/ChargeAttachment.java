package com.github.L_Ender.cataclysm.Attachment;

import com.github.L_Ender.cataclysm.entity.effect.Wall_Watcher_Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;


import java.util.List;

public class ChargeAttachment {

	private boolean charge;
	public int Timer;
	public int effectiveChargeTime;
	public  float dx;
	public float dz;
	public float damagePerEffectiveCharge;
	public float knockbackSpeedIndex;

	public void tick(LivingEntity entity) {
		if(isCharge()) {
			if (!entity.level().isClientSide()) {
				int temp = getTimer();
				setTimer(temp - 1);
				//Deal with rocket punch is valid
				if (temp > 0) {
					//Slightly enlarge player's hitbox
					AABB collideBox = entity.getBoundingBox().inflate(0.75f, 0.75f, 0.75f);

					//Collision Detection
					List<LivingEntity> checks = entity.level().getEntitiesOfClass(LivingEntity.class, collideBox);
					checks.remove(entity);

					//If any mob is detected
					if (!checks.isEmpty()) {
						// spawn an watchEntity to simulate rocket punch effect
						Wall_Watcher_Entity watchEntity = new Wall_Watcher_Entity(entity.level(), entity.blockPosition(), temp, effectiveChargeTime,
								knockbackSpeedIndex, damagePerEffectiveCharge, dx, dz,
								entity);

						List<LivingEntity> impact = entity.level().getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(3.5f, 0.75f, 3.5f));
						impact.remove(entity);

						for (LivingEntity target : impact) {
							// Deal damage
							if (!target.isAlliedTo(entity)) {
								boolean flag = target.hurt(entity.damageSources().mobProjectile(entity, entity), damagePerEffectiveCharge * effectiveChargeTime);
								watchEntity.watch(target);
								if (flag) {
									target.playSound(SoundEvents.ANVIL_LAND, 1.5f, 0.8F);
								}

							}
						}
						entity.level().addFreshEntity(watchEntity);

						// Player stop moving and clear pocket punch status
						entity.setDeltaMovement(0, 0, 0);
						entity.hurtMarked = true;
						setCharge(false);
					}
				}
				if (entity.horizontalCollision || temp == 0) {
					setCharge(false);
				}
			}
		}
	}
	
	public void setCharge(boolean charge) {
		this.charge = charge;
	}

	
	public boolean isCharge() {
		return this.charge;
	}


	
	public void setdamagePerEffectiveCharge(float damage) {
		this.damagePerEffectiveCharge = damage;
	}

	
	public float getdamagePerEffectiveCharge() {
		return this.damagePerEffectiveCharge;
	}

	
	public void setknockbackSpeedIndex(float knockback) {
		this.knockbackSpeedIndex = knockback;
	}

	
	public float getknockbackSpeedIndex() {
		return knockbackSpeedIndex;
	}

	
	public void seteffectiveChargeTime(int chargetime) {
		this.effectiveChargeTime = chargetime;
	}

	
	public int geteffectiveChargeTime() {
		return this.effectiveChargeTime;
	}

	
	public void setdx(float dx) {
		this.dx = dx;
	}

	
	public float getdx() {
		return this.dx ;
	}

	
	public void setdZ(float dz) {
		this.dz = dz;
	}

	
	public float getdZ() {
		return this.dz ;
	}


	
	public void setTimer(int timer) {
		this.Timer = timer;
	}

	
	public int getTimer() {
		return Timer;
	}
}
