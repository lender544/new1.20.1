package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster;


import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;
import java.util.UUID;

public class Internal_Animation_Monster extends Monster implements Enemy {

    public static final EntityDataAccessor<Integer> ATTACK_STATE = SynchedEntityData.defineId(Internal_Animation_Monster.class, EntityDataSerializers.INT);

    protected boolean dropAfterDeathAnim = false;
    public int killDataRecentlyHit;
    public DamageSource killDataCause;
    public Player killDataAttackingPlayer;
    public int attackTicks;
    public int attackCooldown;
    public int customDeathTime;

    public Internal_Animation_Monster(EntityType entity, Level world) {
        super(entity, world);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACK_STATE, 0);
    }


    public int getAttackState() {
        return this.entityData.get(ATTACK_STATE);
    }

    public void setAttackState(int input) {
        this.attackTicks = 0;
        this.entityData.set(ATTACK_STATE, input);
        this.level().broadcastEntityEvent(this, (byte) -input);
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id <= 0) {
            this.attackTicks = 0;
        }else {
            super.handleEntityEvent(id);
        }
    }

    public void tick() {
        super.tick();

        if (this.getAttackState() > 0) {
            ++this.attackTicks;
        }

        if (this.attackCooldown > 0) {
            --this.attackCooldown;
        }
    }

    public static void setConfigattribute(LivingEntity entity, double hpconfig, double dmgconfig) {
        AttributeInstance maxHealthAttr = entity.getAttribute(Attributes.MAX_HEALTH);
        if (maxHealthAttr != null) {
            double difference = maxHealthAttr.getBaseValue() * hpconfig - maxHealthAttr.getBaseValue();
            maxHealthAttr.addTransientModifier(new AttributeModifier(UUID.fromString("9513569b-57b6-41f5-814e-bdc49b81799f"), "Health config multiplier", difference, AttributeModifier.Operation.ADDITION));
            entity.setHealth(entity.getMaxHealth());
        }
        AttributeInstance attackDamageAttr = entity.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attackDamageAttr != null) {
            double difference = attackDamageAttr.getBaseValue() * dmgconfig - attackDamageAttr.getBaseValue();
            attackDamageAttr.addTransientModifier(new AttributeModifier(UUID.fromString("5b17d7cb-294e-4379-88ab-136c372bec9b"), "Attack config multiplier", difference, AttributeModifier.Operation.ADDITION));

        }
    }

    public double getAngleBetweenEntities(Entity first, Entity second) {
        return Math.atan2(second.getZ() - first.getZ(), second.getX() - first.getX()) * (180 / Math.PI) + 90;
    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        ((Player)livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte)30);
    }

    @Override
    protected final void tickDeath() {
        onDeathUpdate(this.deathtimer());
    }

    public int deathtimer(){
        return 20;
    }

    protected void onDeathAIUpdate() {}

    private void onDeathUpdate(int deathDuration) { // TODO copy from entityLiving
        onDeathAIUpdate();

        ++this.deathTime;
        if (this.deathTime >= deathDuration && !this.level().isClientSide() && !this.isRemoved()) {
            lastHurtByPlayer = killDataAttackingPlayer;
            lastHurtByPlayerTime = killDataRecentlyHit;
            if (!this.level().isClientSide && dropAfterDeathAnim && killDataCause != null) {
                dropAllDeathLoot(killDataCause);
            }
            this.level().broadcastEntityEvent(this, (byte) 60);
            this.remove(Entity.RemovalReason.KILLED);
        }
    }

    @Override
    public void die(DamageSource cause) // TODO copy from entityLiving
    {
        if (net.minecraftforge.common.ForgeHooks.onLivingDeath(this, cause)) return;
        if (!this.dead) {
            Entity entity = cause.getEntity();
            LivingEntity livingentity = this.getKillCredit();
            if (this.deathScore >= 0 && livingentity != null) {
                livingentity.awardKillScore(this, this.deathScore, cause);
            }

            if (this.isSleeping()) {
                this.stopSleeping();
            }

            this.dead = true;
            this.getCombatTracker().recheckStatus();
            if (this.level() instanceof ServerLevel) {
                if (entity == null || entity.killedEntity((ServerLevel)this.level(), this)) {
                    this.gameEvent(GameEvent.ENTITY_DIE);
                    this.createWitherRose(livingentity);
                    if (!dropAfterDeathAnim){
                        this.dropAllDeathLoot(cause);
                    }
                }
            }
            killDataCause = cause;
            killDataRecentlyHit = this.lastHurtByPlayerTime;
            killDataAttackingPlayer = lastHurtByPlayer;

            this.level().broadcastEntityEvent(this, (byte)3);
            this.setPose(Pose.DYING);
        }
    }

    protected void repelEntities(float x, float y, float z, float radius) {
        List<LivingEntity> nearbyEntities = getEntityLivingBaseNearby(x, y, z, radius);
        for (Entity entity : nearbyEntities) {
            if (entity.isPickable() && !entity.noPhysics) {
                double angle = (getAngleBetweenEntities(this, entity) + 90) * Math.PI / 180;
                entity.setDeltaMovement(-0.1 * Math.cos(angle), entity.getDeltaMovement().y, -0.1 * Math.sin(angle));
            }
        }
    }

    public boolean canBePushedByEntity(Entity entity) {
        return true;
    }

    // TODO: Copied from parent classes
    @Override
    public void push(Entity entityIn) {
        if (!this.isSleeping()) {
            if (!this.isPassengerOfSameVehicle(entityIn)) {
                if (!entityIn.noPhysics && !this.noPhysics) {
                    double d0 = entityIn.getX() - this.getX();
                    double d1 = entityIn.getZ() - this.getZ();
                    double d2 = Mth.absMax(d0, d1);
                    if (d2 >= (double)0.01F) {
                        d2 = Mth.sqrt((float) d2);
                        d0 = d0 / d2;
                        d1 = d1 / d2;
                        double d3 = 1.0D / d2;
                        if (d3 > 1.0D) {
                            d3 = 1.0D;
                        }

                        d0 = d0 * d3;
                        d1 = d1 * d3;
                        d0 = d0 * (double)0.05F;
                        d1 = d1 * (double)0.05F;
                        // d0 = d0 * (double)(1.0F - this.entityCollisionReduction);
                        // d1 = d1 * (double)(1.0F - this.entityCollisionReduction);
                        if (!this.isVehicle()) {
                            if (canBePushedByEntity(entityIn)) {
                                this.push(-d0, 0.0D, -d1);
                            }
                        }

                        if (!entityIn.isVehicle()) {
                            entityIn.push(d0, 0.0D, d1);
                        }
                    }

                }
            }
        }
    }

    public  List<LivingEntity> getEntityLivingBaseNearby(double distanceX, double distanceY, double distanceZ, double radius) {
        return getEntitiesNearby(LivingEntity.class, distanceX, distanceY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getEntitiesNearby(Class<T> entityClass, double dX, double dY, double dZ, double r) {
        return level().getEntitiesOfClass(entityClass, getBoundingBox().inflate(dX, dY, dZ), e -> e != this && distanceTo(e) <= r + e.getBbWidth() / 2f && e.getY() <= getY() + dY);
    }
}
