package com.github.L_Ender.cataclysm.entity.Deepling;

import com.github.L_Ender.cataclysm.entity.AI.MobAIFindWater;
import com.github.L_Ender.cataclysm.entity.AI.MobAILeaveWater;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.Animation_Monster;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Coralssus_Entity;
import com.github.L_Ender.cataclysm.entity.etc.path.GroundPathNavigatorWide;
import com.github.L_Ender.cataclysm.entity.etc.ISemiAquatic;
import com.github.L_Ender.cataclysm.entity.etc.path.SemiAquaticPathNavigator;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidType;

import java.util.List;

public class AbstractDeepling extends LLibrary_Monster implements ISemiAquatic,Enemy {
    private int moistureAttackTime = 0;
    public float LayerBrightness, oLayerBrightness;
    public int LayerTicks;
    private boolean isLandNavigator;
    private static final EntityDataAccessor<Integer> MOISTNESS = SynchedEntityData.defineId(AbstractDeepling.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DEEPLINGSWIM = SynchedEntityData.defineId(AbstractDeepling.class, EntityDataSerializers.BOOLEAN);

    public AbstractDeepling(EntityType entity, Level world) {
        super(entity, world);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4, new MobAIFindWater(this,1.0D));
        this.goalSelector.addGoal(4, new MobAILeaveWater(this));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RidingCoralssus(this));
        this.goalSelector.addGoal(3, new StopRiding(this));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MOISTNESS, 40000);
        this.entityData.define(DEEPLINGSWIM, false);
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_THE_LEVIATHAN)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (isInWater() && this.isLandNavigator) {
            switchNavigator(false);
        }
        if (!isInWater() && !this.isLandNavigator) {
            switchNavigator(true);
        }

        if (this.isNoAi()) {
            this.setAirSupply(this.getMaxAirSupply());
        } else {
            if (this.isInWaterRainOrBubble()) {
                this.setMoistness(6000);
            } else {
                int dry = this.level().isDay() ? 2 : 1;
                this.setMoistness(this.getMoistness() - dry);
                if (this.getMoistness() <= 0 && moistureAttackTime-- <= 0) {
                    this.hurt(damageSources().dryOut(), random.nextInt(2) == 0 ? 1.0F : 0F);
                    moistureAttackTime = 20;
                }
            }
        }

        boolean flag1 = this.canInFluidType(this.getEyeInFluidType());

        if(flag1){
            if(this.level().noCollision(this, this.getSwimmingBox())) {
                if (!this.getDeeplingSwim()) {
                    setDeeplingSwim(true);
                }
                refreshDimensions();
            }
        }else{
            if(this.level().noCollision(this, this.getNormalBox())) {
                if (this.getDeeplingSwim()) {
                    setDeeplingSwim(false);
                }
                refreshDimensions();
            }
        }


        if (this.level().isClientSide){
            ++LayerTicks;
            this.LayerBrightness += (0.0F - this.LayerBrightness) * 0.8F;
        }
    }

    private boolean canInFluidType(FluidType type) {
        ForgeMod.WATER_TYPE.get();
        return type.canSwim(self());
    }

    public boolean isVisuallySwimming() {
        return this.getDeeplingSwim();
    }

    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.navigation = new GroundPathNavigatorWide(this, level());
            this.isLandNavigator = true;
        } else {
            this.navigation = new SemiAquaticPathNavigator(this, level());
            this.isLandNavigator = false;
        }
    }

    public AABB getSwimmingBox() {
        return new AABB(this.getX()- 1.15f, this.getY(), this.getZ() -1.15f,  this.getX() + 1.15f, this.getY()+ 0.6F, this.getZ() + 1.15f);
    }

    public AABB getNormalBox() {
        return new AABB(this.getX()- 0.6f, this.getY(), this.getZ() -0.6f,  this.getX() + 0.6f, this.getY()+ 2.3f, this.getZ() + 0.6f);
    }

    public EntityDimensions getSwimmingSize() {
        return this.getType().getDimensions().scale(this.getScale());
    }

    public EntityDimensions getDimensions(Pose poseIn) {
        return this.getDeeplingSwim() ? getSwimmingSize() : super.getDimensions(poseIn);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Moisture", this.getMoistness());

    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setMoistness(compound.getInt("Moisture"));

    }

    public int getMoistness() {
        return this.entityData.get(MOISTNESS);
    }

    public void setMoistness(int p_211137_1_) {
        this.entityData.set(MOISTNESS, p_211137_1_);
    }

    public boolean getDeeplingSwim() {
        return this.entityData.get(DEEPLINGSWIM);
    }

    public void setDeeplingSwim(boolean swim) {
        this.entityData.set(DEEPLINGSWIM, swim);
    }


    public MobType getMobType() {
        return MobType.WATER;
    }


    public boolean isPushedByFluid() {
        return !this.isSwimming();
    }

    public boolean canBreatheUnderwater() {
        return true;
    }


    @Override
    public boolean shouldEnterWater() {
        return getMoistness() < 300;
    }

    @Override
    public boolean shouldLeaveWater() {
        return this.getTarget() != null && !this.getTarget().isInWater();
    }

    @Override
    public boolean shouldStopMoving() {
        return false;
    }

    @Override
    public int getWaterSearchRange() {
        return 32;

    }

    static class RidingCoralssus extends Goal {
        private final AbstractDeepling drowned;

        public RidingCoralssus(AbstractDeepling p_32440_) {
            this.drowned = p_32440_;

        }

        public boolean canUse() {
            Coralssus_Entity sus = getClosestCoralssus_Entity();
            return !this.drowned.isPassenger() && sus !=null && this.drowned.getMoistness() > 300 && sus.isAlive() && !sus.isVehicle();
        }

        public void start() {
            Coralssus_Entity sus = getClosestCoralssus_Entity();
            if(sus !=null) {
                this.drowned.getNavigation().moveTo(sus, 1.0D);
            }
        }

        public void tick() {
            Coralssus_Entity sus = getClosestCoralssus_Entity();
            if(sus !=null) {
                this.drowned.getNavigation().moveTo(sus, 1.0D);
                if(this.drowned.distanceTo(sus) < 4.0f){
                    this.drowned.startRiding(sus, true);
                }

            }
        }

        public void stop() {
            this.drowned.getNavigation().stop();
        }

        private Coralssus_Entity getClosestCoralssus_Entity(){
            List<Coralssus_Entity> list = this.drowned.level().getEntitiesOfClass(Coralssus_Entity.class, this.drowned.getBoundingBox().inflate(15, 15, 15));
            Coralssus_Entity closest = null;
            if(!list.isEmpty()){
                for(Coralssus_Entity entity : list){
                    if((closest == null || closest.distanceTo(entity) > entity.distanceTo(entity))){
                        closest = entity;
                    }
                }
            }
            return closest;
        }
    }


    static class StopRiding extends Goal {
        private final AbstractDeepling drowned;

        public StopRiding(AbstractDeepling p_32440_) {
            this.drowned = p_32440_;

        }

        public boolean canUse() {
            return this.drowned.getMoistness() < 300 && drowned.isPassenger();
        }

        public void start() {
            drowned.stopRiding();
        }

    }

}
