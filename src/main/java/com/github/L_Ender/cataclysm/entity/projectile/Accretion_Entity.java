package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Clawdian_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Lightning_Area_Effect_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Optional;


public class Accretion_Entity extends ThrowableProjectile {

    private static final EntityDataAccessor<Optional<BlockState>> BLOCK_STATE = SynchedEntityData.defineId(Accretion_Entity.class, EntityDataSerializers.OPTIONAL_BLOCK_STATE);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Accretion_Entity.class, EntityDataSerializers.FLOAT);


    public Accretion_Entity(EntityType<Accretion_Entity> type, Level world) {
        super(type, world);
    }

    public Accretion_Entity(EntityType<Accretion_Entity> type, Level world, LivingEntity thrower) {
        super(type, thrower, world);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(BLOCK_STATE, Optional.empty());
        p_326229_.define(DAMAGE, 0F);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public void setBlockState(@Nullable BlockState state) {
        this.entityData.set(BLOCK_STATE, Optional.ofNullable(state));
    }

    @Nullable
    public BlockState getBlockState() {
        return (BlockState)((Optional)this.entityData.get(BLOCK_STATE)).orElse((Object)null);
    }


    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        if (this.level() instanceof ServerLevel serverlevel) {
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            boolean flag;
            if (entity1 instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity) entity1;
                DamageSource damagesource = this.damageSources().mobProjectile(this, livingentity);
                flag = entity.hurt(damagesource, this.getDamage());
                if (flag) {
                    if (entity.isAlive()) {
                        EnchantmentHelper.doPostAttackEffects(serverlevel, entity, damagesource);
                    }
                }
            } else {
                flag = entity.hurt(this.damageSources().inWall(), 5.0F);
            }

            if (flag && entity instanceof LivingEntity) {
                int i = 2;

                ((LivingEntity) entity).addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, 20 * i, 1), this.getEffectSource());
            }

        }
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            BlockState blockstate = this.getBlockState();
            if (blockstate != null) {
                this.level().levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, new BlockPos(this.blockPosition()), Block.getId(getBlockState()));
            }
            ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 20);
           // EarthQuakeSummon(8);
            this.discard();
        }
    }


    protected void EarthQuakeSummon(int quakeCount) {
        float angle = 360.0F / quakeCount;
        Entity entity1 = this.getOwner();
        if (entity1 instanceof LivingEntity living) {
            for (int i = 0; i < quakeCount; i++) {
                EarthQuake_Entity peq = new EarthQuake_Entity(this.level(), living);
                peq.setDamage(this.getDamage()/2);
                peq.shootFromRotation(this, 0, angle * i, 0.0F, 0.25F, 0.0F);
                peq.setPos(this.getX(), this.getY(), this.getZ());
                this.level().addFreshEntity(peq);

            }
        }

    }


    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        BlockState blockstate = this.getBlockState();
        if (blockstate != null) {
            compound.put("AccretionBlockState", NbtUtils.writeBlockState(blockstate));
        }
        compound.putFloat("Damage", this.getDamage());
    }


    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        BlockState blockstate = null;
        if (compound.contains("AccretionBlockState", 10)) {
            blockstate = NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), compound.getCompound("AccretionBlockState"));
            if (blockstate.isAir()) {
                blockstate = null;
            }
        }

        this.setBlockState(blockstate);
        this.setDamage(compound.getFloat("Damage"));
    }


    @Override
    public void tick() {
        super.tick();

        BlockState block = this.getBlockState();
        if (block != null) {
            if (block.getRenderShape() != RenderShape.INVISIBLE) {
                Vec3 vec3 = this.getDeltaMovement();
                this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0, 0, 0);
            }
        }

    }


    @Override
    protected double getDefaultGravity() {
        return 0.03F;
    }


}
