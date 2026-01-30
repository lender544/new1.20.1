package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.client.particle.Options.AfterImageParticleOptions;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.Cindaria_Renderer;
import com.github.L_Ender.cataclysm.config.CMClientConfig;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

//https://github.com/seymourimadeit/Piglin-Proliferation/blob/main/src/main/java/tallestred/piglinproliferation/client/particles/AfterImageParticle.java
public class AfterImageParticle extends Particle {
    private final int EntityId;
    private final boolean ghost;
    public AfterImageParticle(ClientLevel world, double x, double y, double z, int r, int g, int b,int entityId,boolean ghost,int lifetimes) {
        super(world, x, y, z);
        this.setSize(6.0F, 6.0F);
        this.x = x;
        this.y = y;
        this.z = z;
        this.rCol = r;
        this.gCol = g;
        this.bCol =  b;
        this.EntityId = entityId;
        this.lifetime = lifetimes;
        this.ghost = ghost;
    }


    public AABB getRenderBoundingBox(float partialTicks) {
        return getBoundingBox().inflate(0.0);
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();

        }
        Entity from = this.getFromEntity();
        if(from == null){
            remove();
        }
    }

    public Entity getFromEntity() {
        return EntityId == -1 ? null : level.getEntity(EntityId);
    }


    @Override
    public void render(@NotNull VertexConsumer vertex, Camera camera, float tick) {
        MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
        Vec3 vec3 = camera.getPosition();
        EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();

        double lerpX = Mth.lerp(tick, this.xo, this.x);
        double lerpY = Mth.lerp(tick, this.yo, this.y);
        double lerpZ = Mth.lerp(tick, this.zo, this.z);
        float colorR = this.rCol / 255.0F;
        float colorG = this.gCol / 255.0F;
        float colorB = this.bCol / 255.0F;
        float colorA = 0.5F / Math.abs((float) age + 1);

        PoseStack stack = new PoseStack();
        Entity entity = this.getFromEntity();

        if (entity instanceof LivingEntity living) {
            EntityRenderer<? super LivingEntity> rendererRaw = entityRenderDispatcher.getRenderer(living);

            if (rendererRaw instanceof LivingEntityRenderer) {
                LivingEntityRenderer<LivingEntity, EntityModel<LivingEntity>> renderer = (LivingEntityRenderer<LivingEntity, EntityModel<LivingEntity>>) rendererRaw;
                java.util.function.Function<VertexConsumer, VertexConsumer> createTintedBuffer = (originalBuffer) -> new VertexConsumer() {
                    @Override
                    public VertexConsumer addVertex(float x, float y, float z) {
                        originalBuffer.addVertex(x, y, z);
                        return this;
                    }

                    @Override
                    public VertexConsumer setColor(int r, int g, int b, int a) {
                        originalBuffer.setColor(
                                (int) (r * colorR),
                                (int) (g * colorG),
                                (int) (b * colorB),
                                (int) (a * colorA)
                        );
                        return this;
                    }

                    @Override
                    public VertexConsumer setUv(float u, float v) {
                        originalBuffer.setUv(u, v);
                        return this;
                    }

                    @Override
                    public VertexConsumer setUv1(int u, int v) {
                        originalBuffer.setUv1(u, v); // Overlay
                        return this;
                    }

                    @Override
                    public VertexConsumer setUv2(int u, int v) {
                        originalBuffer.setUv2(u, v); // Light
                        return this;
                    }

                    @Override
                    public VertexConsumer setNormal(float x, float y, float z) {
                        originalBuffer.setNormal(x, y, z);
                        return this;
                    }
                };

                Minecraft minecraft = Minecraft.getInstance();
                boolean flag = !living.isInvisible();
                boolean flag1 = !flag && !living.isInvisibleTo(minecraft.player);
                boolean flag2 = minecraft.shouldEntityAppearGlowing(living);


                    MultiBufferSource tintedSource = (requestedType) -> {

                        boolean hasTexture = requestedType.format().getElements().contains(VertexFormatElement.UV0);
                        boolean hasNormal = requestedType.format().getElements().contains(VertexFormatElement.NORMAL);

                        if (hasTexture && hasNormal) {
                            RenderType ghostType = this.getRenderType(living, renderer, flag, flag1, flag2);
                            VertexConsumer originalBuffer = multibuffersource$buffersource.getBuffer(ghostType);
                            return createTintedBuffer.apply(originalBuffer);
                        } else {
                            VertexConsumer originalBuffer = multibuffersource$buffersource.getBuffer(requestedType);
                            return createTintedBuffer.apply(originalBuffer);
                        }
                    };

                    entityRenderDispatcher.render(living,
                            lerpX - vec3.x(), lerpY - vec3.y(), lerpZ - vec3.z(),
                            living.getYRot(), tick, stack, tintedSource, entityRenderDispatcher.getPackedLightCoords(living, tick));

            }
        }
    }

    /*
    @Override
    public void render(@NotNull VertexConsumer vertex, Camera camera, float tick) {
        MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
        Vec3 vec3 = camera.getPosition();
        EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();

        float colorR = this.rCol / 255.0F;
        float colorG = this.gCol / 255.0F;
        float colorB = this.bCol / 255.0F;
        float colorA = 0.5F / Math.abs((float) age + 1);

        PoseStack stack = new PoseStack();
        if (this.getFromEntity() instanceof LivingEntity living) {
            if (!CMConfig.custombossbar) {
                multibuffersource$buffersource.getBuffer(RenderType.entityTranslucent(entityRenderDispatcher.getRenderer(living).getTextureLocation(living)));
                entityRenderDispatcher.render(living, this.x - vec3.x(), this.y - vec3.y(), this.z - vec3.z(), living.getYRot(), tick, stack, multibuffersource$buffersource, entityRenderDispatcher.getPackedLightCoords(living, tick));
            } else {
                stack.pushPose();
                LivingEntityRenderer<LivingEntity, EntityModel<LivingEntity>> renderer = (LivingEntityRenderer<LivingEntity, EntityModel<LivingEntity>>) entityRenderDispatcher.getRenderer(living);
                EntityModel<LivingEntity> model = renderer.getModel();
                model.attackTime = living.getAttackAnim(tick);
                boolean shouldSit = living.isPassenger() && (living.getVehicle() != null && living.getVehicle().shouldRiderSit());
                model.riding = shouldSit;
                model.young = living.isBaby();
                float f = Mth.rotLerp(tick, living.yBodyRotO, living.yBodyRot);
                float f1 = Mth.rotLerp(tick, living.yHeadRotO, living.yHeadRot);
                float f2 = f1 - f;
                stack.translate(this.x - vec3.x(), (this.y - vec3.y()) + 1.4F, this.z - vec3.z());
                if (shouldSit && living.getVehicle() instanceof LivingEntity livingentity) {
                    f = Mth.rotLerp(tick, livingentity.yBodyRotO, livingentity.yBodyRot);
                    f2 = f1 - f;
                    float f3 = Mth.wrapDegrees(f2);
                    if (f3 < -85.0F) {
                        f3 = -85.0F;
                    }

                    if (f3 >= 85.0F) {
                        f3 = 85.0F;
                        f = f1 - f3;
                    } else {
                        f = f1 - f3;
                    }

                    if (f3 * f3 > 2500.0F) {
                        f += f3 * 0.2F;
                    }

                    f2 = f1 - f;
                }

                float f6 = Mth.lerp(tick, living.xRotO, living.getXRot());
                if (living.getPose() == Pose.SLEEPING) {
                    Direction direction = living.getBedOrientation();
                    if (direction != null) {
                        float f4 = living.getEyeHeight(Pose.STANDING) - 0.1F;
                        stack.translate((float) (-direction.getStepX()) * f4, 0.0D, (float) (-direction.getStepZ()) * f4);
                    }
                }
                float f7 = (float) living.tickCount + tick;

                stack.mulPose(Axis.YP.rotationDegrees(180.0F - f));
                ((LivingEntityRendererAccessor) renderer).accessorScale(living, stack, tick);
                stack.scale(-1.0F, -1.0F, 1.0F);
                float f8 = 0.0F;
                float f5 = 0.0F;
                if (!shouldSit && living.isAlive()) {
                    f8 = living.walkAnimation.speed(tick);
                    f5 = living.walkAnimation.position(tick);
                    if (living.isBaby()) {
                        f5 *= 3.0F;
                    }

                    if (f8 > 1.0F) {
                        f8 = 1.0F;
                    }
                }

                model.prepareMobModel(living, f5, f8, tick);
                model.setupAnim(living, f5, f8, f7, f2, f6);
                Minecraft minecraft = Minecraft.getInstance();
                boolean flag = !living.isInvisible();
                boolean flag1 = !flag && !living.isInvisibleTo(minecraft.player);
                boolean flag2 = minecraft.shouldEntityAppearGlowing(living);
                RenderType rendertype = getRenderType(living, renderer, flag, flag1, flag2);

                if (rendertype != null) {
                    VertexConsumer originalBuffer = multibuffersource$buffersource.getBuffer(rendertype);
                    VertexConsumer tintedBuffer = new VertexConsumer() {
                        @Override
                        public VertexConsumer addVertex(float x, float y, float z) {
                            originalBuffer.addVertex(x, y, z);
                            return this;
                        }

                        @Override
                        public VertexConsumer setColor(int r, int g, int b, int a) {
                            originalBuffer.setColor(
                                    (int) (r * colorR),
                                    (int) (g * colorG),
                                    (int) (b * colorB),
                                    (int) (a * colorA)
                            );
                            return this;
                        }

                        @Override
                        public VertexConsumer setUv(float u, float v) {
                            originalBuffer.setUv(u, v);
                            return this;
                        }

                        @Override
                        public VertexConsumer setUv1(int u, int v) {
                            originalBuffer.setUv1(u, v);
                            return this;
                        }

                        @Override
                        public VertexConsumer setUv2(int u, int v) {
                            originalBuffer.setUv2(u, v);
                            return this;
                        }

                        @Override
                        public VertexConsumer setNormal(float normalX, float normalY, float normalZ) {
                            originalBuffer.setNormal(normalX, normalY,normalZ);
                            return this;
                        }
                    };

                    int overlay = LivingEntityRenderer.getOverlayCoords(living, 0.0F);
                    model.renderToBuffer(stack, tintedBuffer, getLightColor(tick), overlay, -1);
                }
                stack.popPose();
            }
        }
    }


     */
    public RenderType getRenderType(LivingEntity p_230496_1_, LivingEntityRenderer<LivingEntity, ?> renderer,  boolean p_230496_2_, boolean p_230496_3_, boolean p_230496_4_) {
        ResourceLocation resourcelocation = renderer.getTextureLocation(p_230496_1_);
        if (p_230496_3_) {
            return RenderType.itemEntityTranslucentCull(resourcelocation);
        } else if (p_230496_2_) {
            return this.ghost && !CMClientConfig.shadersCompat ? CMRenderTypes.getGhost(resourcelocation) : RenderType.entityTranslucent(resourcelocation);
        } else {
            return p_230496_4_ ? RenderType.outline(resourcelocation) : null;
        }

    }


    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<AfterImageParticleOptions> {

        @Override
        public Particle createParticle(AfterImageParticleOptions data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            AfterImageParticle particle;
            particle = new AfterImageParticle(level, x, y, z, data.r(), data.g(),data.b(),data.entityid(), data.ghost(), data.lifeticks());
            return particle;
        }

    }

}
