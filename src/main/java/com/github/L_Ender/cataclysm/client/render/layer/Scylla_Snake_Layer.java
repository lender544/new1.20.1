package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Scylla_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.Scylla_Renderer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Scylla_Snake_Layer extends RenderLayer<Scylla_Entity, Scylla_Model> {
    private static final ResourceLocation LAYER_TEXTURES  = new ResourceLocation(Cataclysm.MODID,"textures/entity/scylla/scylla_snake.png");

    public Scylla_Snake_Layer(Scylla_Renderer renderIn) {
        super(renderIn);

    }

    public ResourceLocation getLayerTextureLocation() {
        return LAYER_TEXTURES;
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Scylla_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType ghost = CMRenderTypes.getGhost(this.getLayerTextureLocation());
        VertexConsumer VertexConsumer = bufferIn.getBuffer(ghost);

        float alpha = 0.35F;
        int i1 = FastColor.ARGB32.color((int) (alpha * 255),255, 255, 255);

        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY,1f,1f,1f,0.35F);


    }
}


