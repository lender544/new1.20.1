package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Ignited_Revenant_Model;
import com.github.L_Ender.cataclysm.client.render.entity.Ignited_Revenant_Renderer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Revenant_Layer extends RenderLayer<Ignited_Revenant_Entity, Ignited_Revenant_Model> {

    private final Ignited_Revenant_Model model = new Ignited_Revenant_Model();

    private static final ResourceLocation REVENANT_SHIELD = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/revenant_shield.png");


    public Revenant_Layer(Ignited_Revenant_Renderer renderIgnis) {
        super(renderIgnis);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ignited_Revenant_Entity revenant, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getParentModel().copyPropertiesTo(this.model);
        this.model.setupAnim(revenant, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer lvt_13_1_ = bufferIn.getBuffer(RenderType.entityCutoutNoCull(REVENANT_SHIELD));
        this.model.renderToBuffer(matrixStackIn, lvt_13_1_, packedLightIn, OverlayTexture.NO_OVERLAY);
    }
}