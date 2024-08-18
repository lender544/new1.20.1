package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.ModelIgnited_Revenant;
import com.github.L_Ender.cataclysm.client.render.entity.RendererIgnited_Revenant;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Revenant_Layer extends RenderLayer<Ignited_Revenant_Entity, ModelIgnited_Revenant> {

    private final ModelIgnited_Revenant model = new ModelIgnited_Revenant();

    private static final ResourceLocation REVENANT_SHIELD = new ResourceLocation(Cataclysm.MODID,"textures/entity/revenant_shield.png");


    public Revenant_Layer(RendererIgnited_Revenant renderIgnis) {
        super(renderIgnis);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ignited_Revenant_Entity revenant, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getParentModel().copyPropertiesTo(this.model);
        this.model.setupAnim(revenant, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer lvt_13_1_ = bufferIn.getBuffer(RenderType.entityCutoutNoCull(REVENANT_SHIELD));
        this.model.renderToBuffer(matrixStackIn, lvt_13_1_, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}