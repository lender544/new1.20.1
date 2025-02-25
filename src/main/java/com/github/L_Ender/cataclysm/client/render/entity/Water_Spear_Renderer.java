package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Elemental_Spear_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.projectile.Water_Spear_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Water_Spear_Renderer extends EntityRenderer<Water_Spear_Entity>
{

    private static final ResourceLocation[] TEXTURE_PROGRESS = new ResourceLocation[8];

    public Elemental_Spear_Model model;

    public Water_Spear_Renderer(EntityRendererProvider.Context manager)
    {
        super(manager);
        this.model = new Elemental_Spear_Model<>(manager.bakeLayer(CMModelLayers.ELEMENTAL_SPEAR_MODEL));
        for(int i = 0; i < 6; i++){
            TEXTURE_PROGRESS[i] = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/sea/spear/water_spear_" + i + ".png");
        }
    }


    @Override
    public void render(Water_Spear_Entity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        float f = Mth.rotLerp(partialTicks, entity.yRotO, entity.getYRot());
        float f1 = Mth.lerp(partialTicks, entity.xRotO, entity.getXRot());
        this.model.setupAnim(f, f1);
        VertexConsumer vertexconsumer = buffer.getBuffer(CMRenderTypes.getGhost(this.getTextureLocation(entity)));
      //  this.model.setupAnim(f, f1);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(Water_Spear_Entity entity)
    {
        return getGrowingTexture((int) ((entity.tickCount * 0.75F) % 6));
    }

    public ResourceLocation getGrowingTexture(int age) {
        return TEXTURE_PROGRESS[Mth.clamp(age, 0, 6)];
    }

}
