package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.The_Harbinger_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.The_Harbinger_Renderer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector4f;

import static net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY;

@OnlyIn(Dist.CLIENT)
public class The_Harbinger_Jet_Layer extends RenderLayer<The_Harbinger_Entity, The_Harbinger_Model> {
    protected final EntityRenderDispatcher entityRenderDispatcher;
    private static final ResourceLocation[] TEXTURE_PROGRESS = new ResourceLocation[4];
    public The_Harbinger_Jet_Layer(The_Harbinger_Renderer renderIn, EntityRendererProvider.Context context) {
        super(renderIn);
        entityRenderDispatcher = context.getEntityRenderDispatcher();
        for(int i = 0; i < 4; i++){
            TEXTURE_PROGRESS[i] = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/harbinger/harbinger_jet_" + i + ".png");
        }
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Harbinger_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getAnimation() != The_Harbinger_Entity.MISSILE_FIRE_ANIAMATION) {
            rendercicle(matrixStackIn, bufferIn, packedLightIn, entity, partialTicks, true);
            rendercicle(matrixStackIn, bufferIn, packedLightIn, entity, partialTicks, false);
        }
    }


    private void rendercicle(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Harbinger_Entity entity, float partialTicks, boolean right){
        matrixStackIn.pushPose();
        float bodyYaw = Mth.rotLerp(partialTicks, entity.yBodyRotO, entity.yBodyRot);

        Vec3 offset = getRiderPosition(Vec3.ZERO, right);
        matrixStackIn.translate(offset.x, offset.y, offset.z);
        matrixStackIn.mulPose(new Quaternionf().rotateY((float) Math.toRadians(-bodyYaw)));

        float camYaw = this.entityRenderDispatcher.camera.getYRot();
        matrixStackIn.mulPose(new Quaternionf().rotateY((float) Math.toRadians(camYaw)));
        matrixStackIn.scale(1.25F, 1.25F, 1.25F);
        PoseStack.Pose posestack$pose = matrixStackIn.last();


        VertexConsumer portalStatic = bufferIn.getBuffer(CMRenderTypes.entityCutoutNoCull(getGrowingTexture(entity,(int) (((entity.tickCount + partialTicks) * 1.5F) % 4))));

        drawCircle(portalStatic, posestack$pose, packedLightIn, 1f, 1f, 1f);

        matrixStackIn.popPose();

    }

    private void drawCircle(VertexConsumer vertex,PoseStack.Pose normals, int packedLightIn, float r,float g,float b) {

        cirlceVertex(vertex, normals, packedLightIn, 0.0F, 0, 0, 0, 1.0F, r,g,b);
        cirlceVertex(vertex, normals, packedLightIn, 1.0F, 0, 1, 0, 1.0F, r,g,b);
        cirlceVertex(vertex, normals, packedLightIn, 1.0F, 1, 1, 1, 1.0F, r,g,b);
        cirlceVertex(vertex, normals, packedLightIn, 0.0F, 1, 0, 1, 1.0F, r,g,b);
    }

    private static void cirlceVertex(VertexConsumer vertex, PoseStack.Pose normals, int p_114093_, float p_114094_, int p_114095_, int p_114096_, int p_114097_, float alpha, float r,float g,float b) {
        vertex.addVertex(normals, p_114094_ - 0.5F, (float)p_114095_ - 0.25F, 0.0F)
                .setColor(r, g, b,  alpha)
                .setUv((float)p_114096_, (float)p_114097_)
                .setOverlay(NO_OVERLAY)
                .setLight(240)
                .setNormal(normals, 0.0F, -1.0F, 0.0F);
    }



    public ResourceLocation getGrowingTexture(The_Harbinger_Entity entity, int age) {
        return TEXTURE_PROGRESS[Mth.clamp(age, 0, 3)];
    }

    public Vec3 getRiderPosition(Vec3 offsetIn,boolean right) {
        PoseStack translationStack = new PoseStack();
        translationStack.pushPose();
        this.getParentModel().translateToHand(translationStack,right);
        Vector4f armOffsetVec = new Vector4f((float) offsetIn.x, (float) offsetIn.y, (float) offsetIn.z, 1.0F);
        armOffsetVec.mul(translationStack.last().pose());
        Vec3 vec3 = new Vec3(armOffsetVec.x(), armOffsetVec.y(), armOffsetVec.z());
        translationStack.popPose();
        return vec3;
    }

}


