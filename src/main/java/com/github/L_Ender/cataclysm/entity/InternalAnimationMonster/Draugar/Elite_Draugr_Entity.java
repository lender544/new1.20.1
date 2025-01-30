package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar;

import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Goals.Elite_DraugrAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.EnumSet;


public class Elite_Draugr_Entity extends Internal_Animation_Monster implements CrossbowAttackMob {
    private static final EntityDataAccessor<Boolean> IS_CHARGING_CROSSBOW = SynchedEntityData.defineId(Elite_Draugr_Entity.class, EntityDataSerializers.BOOLEAN);
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState ReloadAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public AnimationState attack2AnimationState = new AnimationState();
    public AnimationState swingAnimationState = new AnimationState();
    public AnimationState Shoot1AnimationState = new AnimationState();
    public AnimationState Shoot2AnimationState = new AnimationState();

    public Elite_Draugr_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 5;
    }

    protected void registerGoals() {
       this.goalSelector.addGoal(1, new CrossBowReloadGoal(this,0,1,1,30,15,12F));
        this.goalSelector.addGoal(0, new ReloadedGoal(this,1,0,20,20F));
        this.goalSelector.addGoal(0, new CrossBowShootGoal(this,0,4,0,23,15,12F));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new Elite_DraugrAttackGoal(this, 1.0D, 12F,true));

        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SnowGolem.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
    }

    public static AttributeSupplier.Builder elite_draugr() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.27F)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.MAX_HEALTH, 32)
                .add(Attributes.ARMOR, 3)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.1);
    }


    public AnimationState getAnimationState(String input) {
        if (input == "attack") {
            return this.attackAnimationState;
        } else if (input == "attack2") {
            return this.attack2AnimationState;
        } else if (input == "re_load") {
            return this.ReloadAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "swing") {
            return this.swingAnimationState;
        } else if (input == "shoot") {
            return this.Shoot1AnimationState;
        } else if (input == "shoot2") {
            return this.Shoot2AnimationState;
        }else {
            return new AnimationState();
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.ReloadAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.Shoot1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.swingAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.Shoot2AnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(IS_CHARGING_CROSSBOW, false);
    }

    protected AABB getAttackBoundingBox() {
        AABB aabb = super.getAttackBoundingBox();
        return aabb.deflate(0.05, (double)0.0F, 0.05);
    }

    public void stopAllAnimationStates() {
        this.attackAnimationState.stop();
        this.attack2AnimationState.stop();
        this.ReloadAnimationState.stop();
        this.swingAnimationState.stop();
        this.Shoot1AnimationState.stop();
        this.Shoot2AnimationState.stop();
    }

    public HumanoidArm getMainArm() {
        return HumanoidArm.LEFT;
    }

    public void handleEntityEvent(byte p_219360_) {
        if (p_219360_ == 4) {
            if (random.nextBoolean()) {
                this.attackAnimationState.start(this.tickCount);
            } else {
                this.attack2AnimationState.start(this.tickCount);
            }
        } else {
            super.handleEntityEvent(p_219360_);
        }
    }

    public boolean doHurtTarget(Entity p_219472_) {
        this.level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(p_219472_);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34088_, DifficultyInstance p_34089_, MobSpawnType p_34090_, @Nullable SpawnGroupData p_34091_ ) {
        SpawnGroupData spawngroupdata = super.finalizeSpawn(p_34088_, p_34089_, p_34090_, p_34091_);
        this.setItemSlot(EquipmentSlot.MAINHAND, this.createSpawnWeapon());
        return spawngroupdata;
    }


    private ItemStack createSpawnWeapon() {
        return  new ItemStack(Items.CROSSBOW);
    }


    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(true, this.tickCount);
        }
    }

    public void aiStep() {
        super.aiStep();

    }

@Override
protected void dropCustomDeathLoot(ServerLevel p_348503_, DamageSource p_34697_, boolean p_34699_) {
    super.dropCustomDeathLoot(p_348503_, p_34697_, p_34699_);
    if (p_34697_.getEntity() instanceof Creeper creeper && creeper.canDropMobsSkull()) {
        ItemStack itemstack = new ItemStack(ModItems.DRAUGR_HEAD.get());
        creeper.increaseDroppedSkulls();
        this.spawnAtLocation(itemstack);
    }

}


    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_MALEDICTUS)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.DRAUGR_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.DRAUGR_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.DRAUGR_IDLE.get();
    }


    public boolean isChargingCrossbow() {
        return this.entityData.get(IS_CHARGING_CROSSBOW);
    }

    public void setChargingCrossbow(boolean p_33302_) {
        this.entityData.set(IS_CHARGING_CROSSBOW, p_33302_);
    }

    @Override
    public void onCrossbowAttackPerformed() {
        this.noActionTime = 0;
    }

    @Override
    public void performRangedAttack(LivingEntity p_33317_, float p_33318_) {
        this.performCrossbowAttack(this, 1.6F);
    }


    private enum CrossbowState {
        UNCHARGED,
        CHARGING,
        CHARGED,
        READY_TO_ATTACK
    }


    static class CrossBowReloadGoal extends Goal {
        protected final Elite_Draugr_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;
        private CrossbowState crossbowState = CrossbowState.UNCHARGED;


        public CrossBowReloadGoal(Elite_Draugr_Entity entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && this.entity.getRandom().nextFloat() * 100.0F < 22f && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && isHoldingCrossbow() && !this.entity.isChargingCrossbow();
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.getAttackState() == attackstate && this.entity.attackTicks <= attackMaxtick;
        }

        private boolean isHoldingCrossbow() {
            return this.entity.isHolding(is -> is.getItem() instanceof CrossbowItem);
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if (entity.attackTicks == 5) {
                this.entity.startUsingItem(ProjectileUtil.getWeaponHoldingHand(this.entity, item -> item instanceof CrossbowItem));

            }
            int i = this.entity.getTicksUsingItem();
            ItemStack itemstack = this.entity.getUseItem();
            if (i >= CrossbowItem.getChargeDuration(itemstack,this.entity)) {
                this.entity.releaseUsingItem();
                this.entity.setChargingCrossbow(true);
            }

        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }


    }

    static class ReloadedGoal extends Goal {
        protected final Elite_Draugr_Entity entity;
        private final int getattackstate;
        private final int attackendstate;
        private final int attackseetick;
        private final float attackrange;

        public ReloadedGoal(Elite_Draugr_Entity entity, int getattackstate, int attackendstate,int attackseetick,float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackendstate = attackendstate;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }


        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && isHoldingCrossbow() && this.entity.isChargingCrossbow();
        }


        @Override
        public void start() {
            LivingEntity livingentity = this.entity.getTarget();
            boolean flag = true;
            if (livingentity != null) {
                float f = livingentity.getBbWidth();
                float dis = f * 2.5F * f * 2.5F + livingentity.getBbWidth();
                double d0 = this.entity.distanceToSqr(livingentity);
                if (d0 <= dis ) {
                    flag = false;
                }
            }
            if (flag) {
                this.entity.setAttackState(2);
            }else{
                this.entity.setAttackState(3);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean canContinueToUse() {
            return (this.entity.getAttackState() == 2 || this.entity.getAttackState() == 3 ) && this.entity.attackTicks <= 30;
        }

        private boolean isHoldingCrossbow() {
            return this.entity.isHolding(is -> is.getItem() instanceof CrossbowItem);
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
           if(this.entity.getAttackState() == 2) {
               if(target != null && entity.attackTicks == 10) {
                   this.entity.performRangedAttack(target, 1.0F);

                   this.entity.setChargingCrossbow(false);
               }
           }


            if(this.entity.getAttackState() == 3) {
                if (target != null && entity.attackTicks == 11) {
                    DamageSource damagesource = this.entity.damageSources().mobAttack(this.entity);
                    target.hurt(damagesource, (float) (this.entity.getAttributeValue(Attributes.ATTACK_DAMAGE)));

                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        protected double getAttackReachSqr(LivingEntity p_25556_) {
            float f = p_25556_.getBbWidth();
            return f * 2.5F * f * 2.5F + p_25556_.getBbWidth();
        }

    }

    static class CrossBowShootGoal extends Goal {
        protected final Elite_Draugr_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;


        public CrossBowShootGoal(Elite_Draugr_Entity entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && this.entity.getRandom().nextFloat() * 100.0F < 22f  && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && isHoldingCrossbow() && this.entity.isChargingCrossbow();
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.getAttackState() == attackstate && this.entity.attackTicks <= attackMaxtick;
        }

        private boolean isHoldingCrossbow() {
            return this.entity.isHolding(is -> is.getItem() instanceof CrossbowItem);
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if(target != null && entity.attackTicks == 11) {
                this.entity.performRangedAttack(target, 1.0F);
                ItemStack itemstack1 = this.entity.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this.entity, item -> item instanceof CrossbowItem));
                if(isHoldingCrossbow()) {
                    this.entity.getUseItem().set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.EMPTY);
                }
                this.entity.setChargingCrossbow(false);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
    
}





