package com.github.L_Ender.cataclysm.capabilities;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.effect.Wall_Watcher_Entity;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import java.util.List;

public class ChargeCapability {
    public static ResourceLocation ID = new ResourceLocation(Cataclysm.MODID, "charge_cap");


    public interface IChargeCapability extends INBTSerializable<CompoundTag> {

        void tick(LivingEntity entity);

        void setCharge(boolean getCharge);

        boolean isCharge();

        void setTimer(int timer);

        int getTimer();

        void setdamagePerEffectiveCharge(float damage);

        float getdamagePerEffectiveCharge();

        void setknockbackSpeedIndex(float knockback);

        float getknockbackSpeedIndex();

        void seteffectiveChargeTime(int chargetime);

        int geteffectiveChargeTime();

        void setdx(float dx);

        float getdx();

        void setdZ(float dz);

        float getdZ();

    }

    public static class ChargeCapabilityImp implements IChargeCapability {

        private boolean charge;
        public int Timer;
        public int effectiveChargeTime;
        public  float dx;
        public float dz;
        public float damagePerEffectiveCharge;
        public float knockbackSpeedIndex;


        @Override
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


        @Override
        public void setCharge(boolean charge) {
            this.charge = charge;
        }

        @Override
        public boolean isCharge() {
            return this.charge;
        }


        @Override
        public void setdamagePerEffectiveCharge(float damage) {
            this.damagePerEffectiveCharge = damage;
        }

        @Override
        public float getdamagePerEffectiveCharge() {
            return this.damagePerEffectiveCharge;
        }

        @Override
        public void setknockbackSpeedIndex(float knockback) {
            this.knockbackSpeedIndex = knockback;
        }

        @Override
        public float getknockbackSpeedIndex() {
            return knockbackSpeedIndex;
        }

        @Override
        public void seteffectiveChargeTime(int chargetime) {
            this.effectiveChargeTime = chargetime;
        }

        @Override
        public int geteffectiveChargeTime() {
            return this.effectiveChargeTime;
        }

        @Override
        public void setdx(float dx) {
            this.dx = dx;
        }

        @Override
        public float getdx() {
            return this.dx ;
        }

        @Override
        public void setdZ(float dz) {
            this.dz = dz;
        }

        @Override
        public float getdZ() {
            return this.dz ;
        }


        @Override
        public void setTimer(int timer) {
            this.Timer = timer;
        }

        @Override
        public int getTimer() {
            return Timer;
        }

        @Override
        public CompoundTag serializeNBT() {
            CompoundTag tag = new CompoundTag();
            tag.putBoolean("isCharge", this.isCharge());
            tag.putInt("ChargeTime", this.geteffectiveChargeTime());
            tag.putFloat("ChargeDamage", this.getdamagePerEffectiveCharge());
            tag.putFloat("KnockbackSpeed", this.getknockbackSpeedIndex());
            tag.putFloat("dx", this.getdx());
            tag.putFloat("dz", this.getdZ());
            tag.putInt("timer", this.getTimer());
            return tag;
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            this.setCharge(nbt.getBoolean("isCharge"));
            this.seteffectiveChargeTime(nbt.getInt("ChargeTime"));
            this.setdamagePerEffectiveCharge(nbt.getFloat("ChargeDamage"));
            this.setknockbackSpeedIndex(nbt.getFloat("KnockbackSpeed"));
            this.setdx(nbt.getFloat("dx"));
            this.setdZ(nbt.getFloat("dz"));
            this.setTimer(nbt.getInt("timer"));

        }

        public static class ChargeProvider implements ICapabilityProvider, ICapabilitySerializable<CompoundTag> {
            private final LazyOptional<IChargeCapability> instance = LazyOptional.of(ChargeCapabilityImp::new);

            @Override
            public CompoundTag serializeNBT() {
                return instance.orElseThrow(NullPointerException::new).serializeNBT();
            }

            @Override
            public void deserializeNBT(CompoundTag nbt) {
                instance.orElseThrow(NullPointerException::new).deserializeNBT(nbt);
            }

            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
                return ModCapabilities.CHARGE_CAPABILITY.orEmpty(cap, instance.cast());
            }
        }
    }
}
