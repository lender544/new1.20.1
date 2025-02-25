package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.Scylla_Model;
import com.github.L_Ender.cataclysm.client.render.entity.Scylla_Renderer;
import com.github.L_Ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.L_Ender.cataclysm.client.render.etc.LightningRender;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Vector4f;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class Scylla_Anchor_Layer extends RenderLayer<Scylla_Entity, Scylla_Model> {
    protected final EntityRenderDispatcher entityRenderDispatcher;

    private Map<UUID, LightningRender> lightningRenderMap = new HashMap<>();
    private final RandomSource rnd = RandomSource.create();
    public Scylla_Anchor_Layer(Scylla_Renderer renderIn, EntityRendererProvider.Context context) {
        super(renderIn);
        entityRenderDispatcher = context.getEntityRenderDispatcher();
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Scylla_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        renderAnchorLightning(matrixStackIn,bufferIn,entity,partialTicks);
    }



    private void renderAnchorLightning(PoseStack matrixStackIn, MultiBufferSource bufferIn, Scylla_Entity entity,float partialtick){
        matrixStackIn.pushPose();
        Vec3 offset = new Vec3(0, 0.0F, 0F);
        Vec3 ridePos = getAnchorPosition(offset);
        matrixStackIn.translate(ridePos.x, ridePos.y, ridePos.z);
        if (entity.getChainAnchor()) {
            if (entity.getAttackState() == 5) {
                drawLightningAnchor(matrixStackIn, bufferIn, entity, 1.5F, 143, 241, 215, 6, 0.05F, partialtick);
            }
        }
        matrixStackIn.popPose();
    }


    private void drawLightningAnchor(PoseStack matrixStackIn, MultiBufferSource bufferIn, Scylla_Entity entity, float xyz, int r, int g, int b, int seg,float size, float partialTicks){

        matrixStackIn.pushPose();


        double x = (rnd.nextFloat() - 0.5F) * xyz;
        double y = (rnd.nextFloat() - 0.5F) * xyz;
        double z = (rnd.nextFloat() - 0.5F) * xyz;

        LightningBoltData.BoltRenderInfo blueBoltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.5F, 0.85F, new Vector4f(r/255F, g/255F, b/255F, 0.8F), 0.1F);

        LightningBoltData bolt1 = new LightningBoltData(blueBoltData, Vec3.ZERO, new Vec3(x, y, z), seg)
                .size(size)
                .lifespan(1)
                .spawn(LightningBoltData.SpawnFunction.NO_DELAY)
                .fade(LightningBoltData.FadeFunction.NONE);
        LightningRender lightningRender = getLightingRender(entity.getUUID());
        if (!Minecraft.getInstance().isPaused()) {
            lightningRender.update(entity, bolt1, partialTicks);
        }
        lightningRender.render(partialTicks, matrixStackIn, bufferIn);
        matrixStackIn.popPose();

        if (!entity.isAlive() && lightningRenderMap.containsKey(entity.getUUID())) {
            lightningRenderMap.remove(entity.getUUID());
        }

    }


    private LightningRender getLightingRender(UUID uuid) {
        if (lightningRenderMap.get(uuid) == null) {
            lightningRenderMap.put(uuid, new LightningRender());
        }
        return lightningRenderMap.get(uuid);
    }


    public Vec3 getAnchorPosition(Vec3 offsetIn) {
        PoseStack translationStack = new PoseStack();
        translationStack.pushPose();
        this.getParentModel().translateChainAnchor(translationStack);
        Vector4f armOffsetVec = new Vector4f((float) offsetIn.x, (float) offsetIn.y, (float) offsetIn.z, 1.0F);
        armOffsetVec.mul(translationStack.last().pose());
        Vec3 vec3 = new Vec3(armOffsetVec.x(), armOffsetVec.y(), armOffsetVec.z());
        translationStack.popPose();
        return vec3;
    }
}


