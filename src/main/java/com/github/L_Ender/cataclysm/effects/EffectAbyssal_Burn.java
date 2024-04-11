package com.github.L_Ender.cataclysm.effects;


import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class EffectAbyssal_Burn extends MobEffect {

    public EffectAbyssal_Burn() {
        super(MobEffectCategory.HARMFUL, 0x6500ff);
    }

    public void applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        boolean flag =   LivingEntityIn.hurt(LivingEntityIn.damageSources().source(CMDamageTypes.ABYSSAL_BURN), 1.0F);
        if(flag && LivingEntityIn.getRandom().nextFloat() < (0.75f - LivingEntityIn.getHealth() / LivingEntityIn.getMaxHealth())) {
            if (!LivingEntityIn.level().isClientSide) {
                double d0 = LivingEntityIn.getX();
                double d1 = LivingEntityIn.getY();
                double d2 = LivingEntityIn.getZ();

                for (int i = 0; i < 8; ++i) {
                    double d3 = LivingEntityIn.getX() + (LivingEntityIn.getRandom().nextDouble() - 0.5D) * 8.0D;
                    double d4 = Mth.clamp(LivingEntityIn.getY() + (double) (LivingEntityIn.getRandom().nextInt(8) - 4), (double) LivingEntityIn.level().getMinBuildHeight(), (double) (LivingEntityIn.level().getMinBuildHeight() + ((ServerLevel) LivingEntityIn.level()).getLogicalHeight() - 1));
                    double d5 = LivingEntityIn.getZ() + (LivingEntityIn.getRandom().nextDouble() - 0.5D) * 8.0D;
                    if (LivingEntityIn.isPassenger()) {
                        LivingEntityIn.stopRiding();
                    }
                    Vec3 vec3 = LivingEntityIn.position();
                    LivingEntityIn.level().gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(LivingEntityIn));
                    net.minecraftforge.event.entity.EntityTeleportEvent.ChorusFruit event = net.minecraftforge.event.ForgeEventFactory.onChorusFruitTeleport(LivingEntityIn, d3, d4, d5);
                    if (randomTeleportInwater(LivingEntityIn,event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                        SoundEvent soundevent = LivingEntityIn instanceof Fox ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
                        LivingEntityIn.level().playSound((Player) null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                        LivingEntityIn.playSound(soundevent, 1.0F, 1.0F);
                        break;
                    }
                }

            }
        }
    }

    private boolean randomTeleportInwater(LivingEntity LivingEntityIn,double p_20985_, double p_20986_, double p_20987_, boolean p_20988_) {
        double d0 = LivingEntityIn.getX();
        double d1 = LivingEntityIn.getY();
        double d2 = LivingEntityIn.getZ();
        double d3 = p_20986_;
        boolean flag = false;
        BlockPos blockpos = BlockPos.containing(p_20985_, p_20986_, p_20987_);
        Level level = LivingEntityIn.level();
        if (level.hasChunkAt(blockpos)) {
            boolean flag1 = false;

            while(!flag1 && blockpos.getY() > level.getMinBuildHeight()) {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = level.getBlockState(blockpos1);
                if (blockstate.blocksMotion()) {
                    flag1 = true;
                } else {
                    --d3;
                    blockpos = blockpos1;
                }
            }

            if (flag1) {
                LivingEntityIn.teleportTo(p_20985_, d3, p_20987_);
                if (level.noCollision(LivingEntityIn)) {
                    flag = true;
                }
            }
        }

        if (!flag) {
            LivingEntityIn.teleportTo(d0, d1, d2);
            return false;
        } else {
            if (p_20988_) {
                level.broadcastEntityEvent(LivingEntityIn, (byte)46);
            }

            if (LivingEntityIn instanceof PathfinderMob) {
                ((PathfinderMob)LivingEntityIn).getNavigation().stop();
            }

            return true;
        }
    }


    public boolean isDurationEffectTick(int duration, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }

}
