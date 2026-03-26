package com.github.L_Ender.cataclysm.entity.effect;


import com.github.L_Ender.cataclysm.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector3f;
import org.joml.Vector4f;


public class SkyColor_Entity extends Entity {

    private static final EntityDataAccessor<Float> RADIUS = SynchedEntityData.defineId(SkyColor_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(SkyColor_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> FADE_DURATION = SynchedEntityData.defineId(SkyColor_Entity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Integer> R = SynchedEntityData.defineId(SkyColor_Entity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Integer> G = SynchedEntityData.defineId(SkyColor_Entity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Integer> B = SynchedEntityData.defineId(SkyColor_Entity.class, EntityDataSerializers.INT);

    public SkyColor_Entity(EntityType<?> type, Level world) {
        super(type, world);
    }

    public SkyColor_Entity(Level world, Vec3 position, float radius, int r,int g,int b, int duration, int fadeDuration) {
        super(ModEntities.SKY_COLOR.get(), world);
        setRadius(radius);
        setR(r);
        setG(g);
        setB(b);
        setDuration(duration);
        setFadeDuration(fadeDuration);
        setPos(position.x, position.y, position.z);
    }

    @OnlyIn(Dist.CLIENT)
    public float getColorIntensity(Player player, float partialTicks) {
        float ticksDelta = tickCount + partialTicks;
        float timeFrac = 1.0f - Mth.clamp((ticksDelta - getDuration()) / (getFadeDuration() + 1.0f), 0.0f, 1.0f);
        float baseIntensity = ticksDelta < getDuration() ? 1.0f : timeFrac * timeFrac;
        Vec3 playerPos = player.getEyePosition(partialTicks);
        float effectRadius = getRadius();
        if (effectRadius <= 0) return 0.0f;
        float distFrac = (float) (1.0f - Mth.clamp(position().distanceTo(playerPos) / effectRadius, 0, 1));
        return baseIntensity * distFrac * distFrac;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide() && tickCount > getDuration() + getFadeDuration()) {
            discard();
        }
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(RADIUS, 10.0f);
        this.entityData.define(R, 0);
        this.entityData.define(G, 0);
        this.entityData.define(B,0);
        this.entityData.define(DURATION, 0);
        this.entityData.define(FADE_DURATION, 5);
    }

    public float getRadius() {
        return this.entityData.get(RADIUS);
    }
    public void setRadius(float radius) {
        this.entityData.set(RADIUS, radius);
    }

    public int getR() {
        return this.entityData.get(R);
    }
    public void setR(int r) {
        this.entityData.set(R, r);
    }

    public int getG() {
        return this.entityData.get(G);
    }
    public void setG(int g) {
        this.entityData.set(G, g);
    }

    public int getB() {
        return this.entityData.get(B);
    }
    public void setB(int b) {
        this.entityData.set(B, b);
    }

    public int getDuration() {
        return this.entityData.get(DURATION);
    }
    public void setDuration(int duration) {
        this.entityData.set(DURATION, duration);
    }
    public int getFadeDuration() {
        return this.entityData.get(FADE_DURATION);
    }
    public void setFadeDuration(int fadeDuration) {
        this.entityData.set(FADE_DURATION, fadeDuration);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        setRadius(compound.getFloat("radius"));
        setR(compound.getInt("R"));
        setG(compound.getInt("G"));
        setB(compound.getInt("B"));
        setDuration(compound.getInt("duration"));
        setFadeDuration(compound.getInt("fade_duration"));
        tickCount = compound.getInt("ticks_existed");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putFloat("radius", getRadius());
        compound.putInt("R", this.getR());
        compound.putInt("G", this.getG());
        compound.putInt("B", this.getB());
        compound.putInt("duration", getDuration());
        compound.putInt("fade_duration", getFadeDuration());
        compound.putInt("ticks_existed", tickCount);
    }

    public static void color(Level world, Vec3 position, float radius, int r,int g,int b, int duration, int fadeDuration) {
        if (!world.isClientSide) {
            SkyColor_Entity skyColorEntity = new SkyColor_Entity(world, position, radius, r,g,b, duration, fadeDuration);
            world.addFreshEntity(skyColorEntity);
        }
    }
}
