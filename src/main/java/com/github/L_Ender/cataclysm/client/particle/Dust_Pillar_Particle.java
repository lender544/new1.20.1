package com.github.L_Ender.cataclysm.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientBlockExtensions;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class Dust_Pillar_Particle extends TextureSheetParticle {
    private final BlockPos pos;
    private final float uo;
    private final float vo;

    public Dust_Pillar_Particle(ClientLevel p_108282_, double p_108283_, double p_108284_, double p_108285_, double p_108286_, double p_108287_, double p_108288_, BlockState p_108289_) {
        this(p_108282_, p_108283_, p_108284_, p_108285_, p_108286_, p_108287_, p_108288_, p_108289_, BlockPos.containing(p_108283_, p_108284_, p_108285_));
    }

    public Dust_Pillar_Particle(ClientLevel p_172451_, double p_172452_, double p_172453_, double p_172454_, double p_172455_, double p_172456_, double p_172457_, BlockState p_172458_, BlockPos p_172459_) {
        super(p_172451_, p_172452_, p_172453_, p_172454_, p_172455_, p_172456_, p_172457_);
        this.pos = p_172459_;
        this.setSprite(Minecraft.getInstance().getBlockRenderer().getBlockModelShaper().getParticleIcon(p_172458_));
        this.gravity = 1.0F;
        this.rCol = 0.6F;
        this.gCol = 0.6F;
        this.bCol = 0.6F;
        if (IClientBlockExtensions.of(p_172458_).areBreakingParticlesTinted(p_172458_, p_172451_, p_172459_)) {
            int i = Minecraft.getInstance().getBlockColors().getColor(p_172458_, p_172451_, p_172459_, 0);
            this.rCol *= (float)(i >> 16 & 255) / 255.0F;
            this.gCol *= (float)(i >> 8 & 255) / 255.0F;
            this.bCol *= (float)(i & 255) / 255.0F;
        }

        this.quadSize /= 2.0F;
        this.uo = this.random.nextFloat() * 3.0F;
        this.vo = this.random.nextFloat() * 3.0F;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.TERRAIN_SHEET;
    }

    protected float getU0() {
        return this.sprite.getU((double)((this.uo + 1.0F) / 4.0F * 16.0F));
    }

    protected float getU1() {
        return this.sprite.getU((double)(this.uo / 4.0F * 16.0F));
    }

    protected float getV0() {
        return this.sprite.getV((double)(this.vo / 4.0F * 16.0F));
    }

    protected float getV1() {
        return this.sprite.getV((double)((this.vo + 1.0F) / 4.0F * 16.0F));
    }

    public int getLightColor(float p_108291_) {
        int i = super.getLightColor(p_108291_);
        return i == 0 && this.level.hasChunkAt(this.pos) ? LevelRenderer.getLightColor(this.level, this.pos) : i;
    }

    public Dust_Pillar_Particle updateSprite(BlockState state, BlockPos pos) {
        if (pos != null) {
            this.setSprite(Minecraft.getInstance().getBlockRenderer().getBlockModelShaper().getTexture(state, this.level, pos));
        }

        return this;
    }
    @Nullable
    static Dust_Pillar_Particle createTerrainParticle(BlockParticleOption type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        BlockState blockstate = type.getState();

        return !blockstate.isAir() && !blockstate.is(Blocks.MOVING_PISTON) ?  (new Dust_Pillar_Particle(level, x, y, z, xSpeed, ySpeed, zSpeed, blockstate)).updateSprite(blockstate, type.getPos()) : null;
    }

    @OnlyIn(Dist.CLIENT)
    public static class DustPillarProvider implements ParticleProvider<BlockParticleOption> {
        public DustPillarProvider() {
        }

        @Nullable
        public Particle createParticle(BlockParticleOption p_338199_, ClientLevel p_338462_, double p_338552_, double p_338714_, double p_338211_, double p_338881_, double p_338238_, double p_338376_) {
            Particle particle = Dust_Pillar_Particle.createTerrainParticle(p_338199_, p_338462_, p_338552_, p_338714_, p_338211_, p_338881_, p_338238_, p_338376_);
            if (particle != null) {
                particle.setParticleSpeed(p_338462_.random.nextGaussian() / (double)30.0F, p_338238_ + p_338462_.random.nextGaussian() / (double)2.0F, p_338462_.random.nextGaussian() / (double)30.0F);
                particle.setLifetime(p_338462_.random.nextInt(20) + 20);
            }

            return particle;
        }
    }



}
