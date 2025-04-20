package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.Ignis_Model;
import com.github.L_Ender.cataclysm.client.render.entity.Ignis_Renderer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
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
public class Ignis_Shield_Layer extends RenderLayer<Ignis_Entity, Ignis_Model> {

    private final Ignis_Model model = new Ignis_Model();

    private static final ResourceLocation IGNIS_SHIELD = new ResourceLocation("cataclysm:textures/entity/ignis/ignis_shield.png");

    private static final ResourceLocation IGNIS_SOUL_SHIELD = new ResourceLocation("cataclysm:textures/entity/ignis/ignis_soul_shield.png");

    private static final ResourceLocation IGNIS_SHIELD_CRACK1 = new ResourceLocation("cataclysm:textures/entity/ignis/ignis_shield_crack1.png");

    private static final ResourceLocation IGNIS_SHIELD_CRACK2 = new ResourceLocation("cataclysm:textures/entity/ignis/ignis_shield_crack2.png");

    private static final ResourceLocation IGNIS_SHIELD_CRACK3 = new ResourceLocation("cataclysm:textures/entity/ignis/ignis_shield_crack3.png");

    public Ignis_Shield_Layer(Ignis_Renderer renderIgnis) {
        super(renderIgnis);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ignis_Entity ignis, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ResourceLocation lvt_12_3_;
        if (ignis.getBossPhase() < 1) {
            lvt_12_3_ = IGNIS_SHIELD;
        } else {
            lvt_12_3_ = IGNIS_SOUL_SHIELD;
        }
        this.getParentModel().copyPropertiesTo(this.model);
        this.model.setupAnim(ignis, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        VertexConsumer lvt_13_1_ = bufferIn.getBuffer(RenderType.entityCutoutNoCull(lvt_12_3_));
        this.model.renderToBuffer(matrixStackIn, lvt_13_1_, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        if (ignis.getShieldDurability() > 0) {
            VertexConsumer lvt_13_2_ =
                    ignis.getShieldDurability() >= 3 ? bufferIn.getBuffer(RenderType.entityCutoutNoCull(IGNIS_SHIELD_CRACK3))
                            : ignis.getShieldDurability() == 2 ? bufferIn.getBuffer(RenderType.entityCutoutNoCull(IGNIS_SHIELD_CRACK2))
                            : bufferIn.getBuffer(RenderType.entityCutoutNoCull(IGNIS_SHIELD_CRACK1));
            this.model.renderToBuffer(matrixStackIn, lvt_13_2_, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }



    }
}