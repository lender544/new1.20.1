package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.Scylla_Model;
import com.github.L_Ender.cataclysm.client.render.entity.Scylla_Renderer;
import com.github.L_Ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.L_Ender.cataclysm.client.render.etc.LightningRender;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector4f;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class Scylla_Eye_Spark_Layer extends RenderLayer<Scylla_Entity, Scylla_Model> {
    protected final EntityRenderDispatcher entityRenderDispatcher;

    private Map<UUID, LightningRender> lightningRenderMap = new HashMap<>();
    private final RandomSource rnd = RandomSource.create();
    public Scylla_Eye_Spark_Layer(Scylla_Renderer renderIn, EntityRendererProvider.Context context) {
        super(renderIn);
        entityRenderDispatcher = context.getEntityRenderDispatcher();
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Scylla_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        renderLightning(matrixStackIn,bufferIn,entity,partialTicks ,true);
        renderLightning(matrixStackIn,bufferIn,entity,partialTicks ,false);
    }


    private void renderLightning(PoseStack matrixStackIn, MultiBufferSource bufferIn, Scylla_Entity entity,float partialtick, boolean right){
        matrixStackIn.pushPose();
        Vec3 offset = new Vec3(0, 0.0F, 0F);
        Vec3 ridePos = getEyePosition(offset,right);
        matrixStackIn.translate(ridePos.x, ridePos.y, ridePos.z);
        if (entity.getEye()) {
            drawLightning(matrixStackIn, bufferIn, entity, 143,241,215,4,0.05F, partialtick);
        }

        matrixStackIn.popPose();
    }


    private void drawLightning(PoseStack matrixStackIn, MultiBufferSource bufferIn, Scylla_Entity entity, int r, int g, int b, int seg,float size, float partialTicks){

        matrixStackIn.pushPose();


        double x = (rnd.nextFloat() - 0.5F);
        double y = (rnd.nextFloat() - 0.5F);
        double z = (rnd.nextFloat() - 0.5F);

        LightningBoltData.BoltRenderInfo blueBoltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.5F, 0.85F, new Vector4f(r/255F, g/255F, b/255F, 0.8F), 0.1F);

        LightningBoltData bolt1 = new LightningBoltData(blueBoltData, Vec3.ZERO, new Vec3(x, y, z), seg)
                .size(size)
                .lifespan(3)
                .spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        LightningRender lightningRender = getLightingRender(entity.getUUID());
        lightningRender.update(entity, bolt1, partialTicks);

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





    public Vec3 getEyePosition(Vec3 offsetIn,boolean right) {
        PoseStack translationStack = new PoseStack();
        translationStack.pushPose();
        this.getParentModel().translateToEye(translationStack,right);
        Vector4f armOffsetVec = new Vector4f((float) offsetIn.x, (float) offsetIn.y, (float) offsetIn.z, 1.0F);
        armOffsetVec.mul(translationStack.last().pose());
        Vec3 vec3 = new Vec3(armOffsetVec.x(), armOffsetVec.y(), armOffsetVec.z());
        translationStack.popPose();
        return vec3;
    }

}


