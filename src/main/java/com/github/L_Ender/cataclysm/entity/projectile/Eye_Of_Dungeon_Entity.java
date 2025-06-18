package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Eye_Of_Dungeon_Entity extends Entity implements ItemSupplier {
    private static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK = SynchedEntityData.defineId(Eye_Of_Dungeon_Entity.class, EntityDataSerializers.ITEM_STACK);
    private static final EntityDataAccessor<Integer> R = SynchedEntityData.defineId(Eye_Of_Dungeon_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> G = SynchedEntityData.defineId(Eye_Of_Dungeon_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> B = SynchedEntityData.defineId(Eye_Of_Dungeon_Entity.class, EntityDataSerializers.INT);


    private double tx;
    private double ty;
    private double tz;
    private int life;


    private Vec3[] trailPositions = new Vec3[64];
    private int trailPointer = -1;

    public Eye_Of_Dungeon_Entity(EntityType<? extends Eye_Of_Dungeon_Entity> p_36957_, Level p_36958_) {
        super(p_36957_, p_36958_);
    }

    public Eye_Of_Dungeon_Entity(Level p_36960_, double p_36961_, double p_36962_, double p_36963_) {
        this(ModEntities.EYE_OF_DUNGEON.get(), p_36960_);
        this.setPos(p_36961_, p_36962_, p_36963_);
    }



    public ItemStack getItem() {
        return this.getEntityData().get(DATA_ITEM_STACK);
    }

    public void setItem(ItemStack p_32046_) {
        this.getEntityData().set(DATA_ITEM_STACK, Util.make(p_32046_.copy(), (p_36978_) -> {
            p_36978_.setCount(1);
        }));
    }

    private ItemStack getItemRaw() {
        return this.getEntityData().get(DATA_ITEM_STACK);
    }


    public int getR()
    {
        return this.entityData.get(R);
    }

    public void setR(int r)
    {
        this.entityData.set(R, r);
    }

    public int getG()
    {
        return this.entityData.get(G);
    }

    public void setG(int g)
    {
        this.entityData.set(G, g);
    }


    public int getB()
    {
        return this.entityData.get(B);
    }

    public void setB(int b)
    {
        this.entityData.set(B, b);
    }


    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DATA_ITEM_STACK, ItemStack.EMPTY);
        p_326229_.define(R, 0);
        p_326229_.define(G, 0);
        p_326229_.define(B, 0);
    }


    public void lerpMotion(double p_36984_, double p_36985_, double p_36986_) {
        this.setDeltaMovement(p_36984_, p_36985_, p_36986_);
        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            double d0 = Math.sqrt(p_36984_ * p_36984_ + p_36986_ * p_36986_);
            this.setYRot((float)(Mth.atan2(p_36984_, p_36986_) * (double)(180F / (float)Math.PI)));
            this.setXRot((float)(Mth.atan2(p_36985_, d0) * (double)(180F / (float)Math.PI)));
            this.yRotO = this.getYRot();
            this.xRotO = this.getXRot();
        }

    }

    public void signalTo(BlockPos p_36968_) {
        double d0 = (double)p_36968_.getX();
        int i = p_36968_.getY();
        double d1 = (double)p_36968_.getZ();
        double d2 = d0 - this.getX();
        double d3 = d1 - this.getZ();
        double d4 = Math.sqrt(d2 * d2 + d3 * d3);
        if (d4 > 12.0D) {
            this.tx = this.getX() + d2 / d4 * 12.0D;
            this.tz = this.getZ() + d3 / d4 * 12.0D;
            this.ty = this.getY() + 8.0D;
        } else {
            this.tx = d0;
            this.ty = (double)i;
            this.tz = d1;
        }

        this.life = 0;
    }

    public void tick() {
        if (this.getItem().isEmpty()) {
            this.discard();
        } else {
            super.tick();
            Vec3 vec3 = this.getDeltaMovement();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            double d3 = vec3.horizontalDistance();
            this.setXRot(lerpRotation(this.xRotO, (float) (Mth.atan2(vec3.y, d3) * (double) (180F / (float) Math.PI))));
            this.setYRot(lerpRotation(this.yRotO, (float) (Mth.atan2(vec3.x, vec3.z) * (double) (180F / (float) Math.PI))));
            if (!this.level().isClientSide) {
                double d4 = this.tx - d0;
                double d5 = this.tz - d2;
                float f = (float) Math.sqrt(d4 * d4 + d5 * d5);
                float f1 = (float) Mth.atan2(d5, d4);
                double d6 = Mth.lerp(0.0025D, d3, (double) f);
                double d7 = vec3.y;
                if (f < 1.0F) {
                    d6 *= 0.8D;
                    d7 *= 0.8D;
                }

                int j = this.getY() < this.ty ? 1 : -1;
                vec3 = new Vec3(Math.cos((double) f1) * d6, d7 + ((double) j - d7) * (double) 0.015F, Math.sin((double) f1) * d6);
                this.setDeltaMovement(vec3);
            }

            float f2 = 0.25F;
            if (this.isInWater()) {
                for (int i = 0; i < 4; ++i) {
                    this.level().addParticle(ParticleTypes.BUBBLE, d0 - vec3.x * 0.25D, d1 - vec3.y * 0.25D, d2 - vec3.z * 0.25D, vec3.x, vec3.y, vec3.z);
                }
            }

            Vec3 trailAt = this.position().add(0, this.getBbHeight() / 2F, 0);
            if (trailPointer == -1) {
                Vec3 backAt = trailAt;
                for (int i = 0; i < trailPositions.length; i++) {
                    trailPositions[i] = backAt;
                }
            }
            if (++this.trailPointer == this.trailPositions.length) {
                this.trailPointer = 0;
            }
            this.trailPositions[this.trailPointer] = trailAt;


            if (!this.level().isClientSide) {
                this.setPos(d0, d1, d2);
                ++this.life;
                if (this.life > 80 && !this.level().isClientSide) {
                    this.playSound(SoundEvents.ENDER_EYE_DEATH, 1.0F, 1.0F);
                    this.discard();
                }
            } else {
                this.setPosRaw(d0, d1, d2);
            }

        }
    }

    public static float lerpRotation(float p_37274_, float p_37275_) {
        while(p_37275_ - p_37274_ < -180.0F) {
            p_37274_ -= 360.0F;
        }

        while(p_37275_ - p_37274_ >= 180.0F) {
            p_37274_ += 360.0F;
        }

        return Mth.lerp(0.2F, p_37274_, p_37275_);
    }

    public void addAdditionalSaveData(CompoundTag p_36975_) {
        ItemStack itemstack = this.getItemRaw();
        if (!itemstack.isEmpty()) {
            p_36975_.put("Item", this.getItem().save(this.registryAccess()));
        }
        p_36975_.putInt("R", this.getR());
        p_36975_.putInt("G", this.getG());
        p_36975_.putInt("B", this.getB());
    }

    public void readAdditionalSaveData(CompoundTag p_36970_) {
        if (p_36970_.contains("Item", 10)) {
            this.setItem(ItemStack.parse(this.registryAccess(), p_36970_.getCompound("Item")).orElse(this.getDefaultItem()));
        } else {
            this.setItem(this.getDefaultItem());
        }
        this.setR(p_36970_.getInt("R"));
        this.setG(p_36970_.getInt("G"));
        this.setB(p_36970_.getInt("B"));
    }

    private ItemStack getDefaultItem() {
        return new ItemStack(ModItems.DESERT_EYE.get());
    }


    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    public boolean isAttackable() {
        return false;
    }

    public Vec3 getTrailPosition(int pointer, float partialTick) {
        if (this.isRemoved()) {
            partialTick = 1.0F;
        }
        int i = this.trailPointer - pointer & 63;
        int j = this.trailPointer - pointer - 1 & 63;
        Vec3 d0 = this.trailPositions[j];
        Vec3 d1 = this.trailPositions[i].subtract(d0);
        return d0.add(d1.scale(partialTick));
    }

    public boolean hasTrail() {
        return trailPointer != -1;
    }
}
