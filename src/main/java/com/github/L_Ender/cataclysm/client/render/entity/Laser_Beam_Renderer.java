package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Laser_Beam_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.projectile.Laser_Beam_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Matrix4f;

public class Laser_Beam_Renderer extends EntityRenderer<Laser_Beam_Entity> {

    private static final ResourceLocation TEXTURE_RED = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/harbinger/laser_beam.png");
    private static final RenderType RENDER_TYPE_RED = CMRenderTypes.CMEyes(TEXTURE_RED);
    public Laser_Beam_Model model;

    public Laser_Beam_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
        this.model = new Laser_Beam_Model(mgr.bakeLayer(CMModelLayers.LASER_BEAM_MODEL));
    }


    @Override
    public void render(Laser_Beam_Entity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        float f = Mth.rotLerp(partialTicks, entity.yRotO, entity.getYRot());
        float f1 = Mth.lerp(partialTicks, entity.xRotO, entity.getXRot());
        this.model.setupAnim(f, f1);
        VertexConsumer vertexconsumer = buffer.getBuffer(RENDER_TYPE_RED);
        //  this.model.setupAnim(f, f1);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);

    }

    @Override
    public ResourceLocation getTextureLocation(Laser_Beam_Entity entity) {
        return TEXTURE_RED;
    }
}
